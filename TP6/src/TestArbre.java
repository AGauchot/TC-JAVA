// ----------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// ----------------------------------------------
//            Exercice sur les arbres
// ----------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;     // pour les saisies
import java.lang.reflect.*; 

//############################################################################
/** La classe Noeud sert à spécifier le type des valeurs que porte chaque
 *  noeud de l'arbre.  Pour être utilisable par la classe Arbre elle doit
 *  implanter les méthodes publiques :
 *     renvoieValeur(), compareAvec() et toString().
 */
class Noeud {
  // Attribut :
  private int valeur;

  // Constructeur :
  public Noeud(int x) {
    valeur = x;
  }

  // Méthodes :
  /** Retourne la valeur contenue dans le noeud. */
  public int renvoieValeur() {
    return valeur;
  }
  /** Compare la valeur du noeud avec la valeur contenue dans le noeud n2. */
  public int compareAvec(Noeud n2) {
    if(valeur == n2.valeur) return 0;
    else return (valeur < n2.valeur) ? -1 : 1;
  }
  /** Re-définit la méthode standard toString (toujours une bonne idée). */
  public String toString() {
    return String.valueOf(valeur);
  }
}  // Fin de la classe Noeud.
//############################################################################
  
//############################################################################
/** La classe Arbre est générique : elle s'appuie sur la classe Noeud de
 *  telle sorte qu'il suffit de changer le contenu de la classe Noeud pour
 *  créer des arbres d'entiers, de chaînes de caractères, ou de quelque
 *  type que ce soit.
 *  REMARQUE : on a fait le choix d'expliciter l'arbre vide sous la forme
 *             d'un arbre dont la racine vaut null.  L'arbre vide prend
 *             donc de la "place" en mémoire mais ca permet de lui donner
 *             le statut d'un arbre véritable avec possibilité de lui
 *             appliquer toutes les méthodes du type Arbre sans risquer de
 *             déclencher d'emblée une NullPointerException (sauf bien sûr
 *             si on fait l'erreur d'affecter directement null à une variable
 *             de type Arbre !).
 *             Une autre approche consisterait à dire qu'un arbre vide est
 *             un arbre qui vaut directement null (gain de place) mais du
 *             coup la plupart des méthodes ne s'appliqueraient qu'aux
 *             seuls arbres non vides.
 *             Chaque solution présente donc des avantages et des inconvénients.
 *             En fait, l'important est de faire un choix et de s'y tenir.
 */
class Arbre  {
  // Attributs :           ######### A COMPLETER ########
  Noeud racine;
  Arbre sag;
  Arbre sad;
  // Constructeurs :
  /** Construit un arbre vide. */
  public Arbre() {
    racine = null;
    sag = sad = null;
  }
  /** Construit un arbre à partir d'un simple noeud. */
  public Arbre(Noeud n) {
    racine=n;
    // NOTA-BENE : on ne doit surtout pas affecter la valeur null directement 
    // à sag et sad (sinon il y aurait 2 sortes d'arbres vides : ceux égaux 
    // à null et ceux dont la racine est égale à null... et cela compliquerait
    // la suite du programme).
    sag = sad = new Arbre();   
  }
  /** Construit un arbre à partir d'un noeud et de 2 arbres. */
  public Arbre(Noeud n, Arbre g, Arbre d) {
    racine = n;
    // RAPPEL : on ne doit surtout pas affecter la valeur null directement 
    // à sag et sad (voir ci-dessus)...
    if (g==null) {
      g = new Arbre();   
    }
    if (d==null) {
      d = new Arbre();   
    }
    sag = g;
    sad = d;
  }

  // Méthodes :
  public boolean estVide() {
    return racine == null;
  }
  public Noeud renvoieRacine() throws ArbreVideException {
    // Tenter d'accéder au sommet d'une arbre vide lance ArbreVideException :
    if (estVide()) {
      throw new ArbreVideException("Accès racine");
    }
    return racine;
  }
  /** Renvoie le Sous-Arbre Gauche. */
  public Arbre renvoieSAG() throws ArbreVideException {
    // Tenter d'accéder au SAG d'une arbre vide lance ArbreVideException :
    if (estVide()) {
      throw new ArbreVideException("Accès sous-arbre gauche");
    }
    return sag;
  }
  /** Renvoie le Sous-Arbre Droit. */
  public Arbre renvoieSAD() throws ArbreVideException {
    // Tenter d'accéder au SAD d'une arbre vide lance ArbreVideException :
    if (estVide()) {
      throw new ArbreVideException("Accès sous-arbre droit");
    }
    return sad;
  }
  /** Re-définit la méthode standard toString (toujours une bonne idée). 
   *  Remarque : les 'x' qui s'affichent représentent les sous-arbres vides.
   */
  public String toString() {
    if (estVide()) {
      return "x";
    }
    return "(" + racine + ' ' + sag.toString() + ' ' + sad.toString() + ')' ;
  }
  /** Affiche le contenu de l'arbre sous forme linéaire parenthésée.
   */
  public void affiche() {
    System.out.println(toString());
  }
  /** Affiche le contenu de l'arbre en deux dimensions (dans le plan).
   */
  public void affiche2D() {
    affiche2D(0);
  }
  /** Affiche le contenu de l'arbre en deux dimensions (dans le plan).
   *  Le paramètre nbTabulation spécifie le nb de caractères blancs à "sauter".
   */
  private void affiche2D(int nbTabulation) {
    if (estVide()) {
      System.out.print("x");
      return ; 
    }
    else {
      nbTabulation++;
      System.out.print(racine + "--");          // affiche la racine
      sad.affiche2D(nbTabulation);              // affiche le SAD
      if (! sag.estVide()) {
        System.out.println();
        for(int i=1 ; i<nbTabulation ; i++) System.out.print("     ");
        System.out.println("\\");
        for(int i=1 ; i<nbTabulation ; i++) System.out.print("     ");
        System.out.print(" \\__");
        sag.affiche2D(nbTabulation);            // affiche le SAG
      }
    }
  }
  // AJOUTER CI-DESSOUS LES METHODES :
  //   - renvoieTaille(), renvoieNbFeuilles(), renvoieHauteur()
  //   - parcoursRGD(), parcoursGRD(), parcoursGDR(), parcoursParNiveaux()
  
  public int renvoieTaille() throws ArbreVideException {
    if ( this.estVide() ) {
      return 0;
    }
    else {
      return ( 1 + this.renvoieSAG().renvoieTaille() + this.renvoieSAD().renvoieTaille() );
    }
  }
  
  public int renvoieNbFeuilles() throws ArbreVideException {
    if ( this.estVide() ) {
      return 0;
    }
    else {
      if ( this.renvoieSAG().estVide() && this.renvoieSAD().estVide() ) {
        return 1;
      }
      else {
        return ( this.renvoieSAG().renvoieNbFeuilles() + this.renvoieSAD().renvoieNbFeuilles() );
      }
    }
  }
  
  public int renvoieHauteur() throws ArbreVideException {
    if (this.estVide()) {
      return 0;
    } else {
      int tailleG = this.renvoieSAG().renvoieHauteur();
      int tailleD = this.renvoieSAD().renvoieHauteur();
      if (tailleG > tailleD) {
        return 1 + tailleG;
      } else {
        return 1 + tailleD;
      }
    }
  }
  
  // On crée une fonction auxiliaire pour parcours RGD
  public void parcoursRGD () throws ArbreVideException {
    if (this.estVide()) {
      return;
    }
    else {
      System.out.print(" " + this.renvoieRacine().renvoieValeur() + " ");
      this.renvoieSAG().parcoursRGD();
      this.renvoieSAD().parcoursRGD();
    }
  }
  
  public void parcoursGRD () throws ArbreVideException {
    if (this.estVide()) {
      return;
    }
    else {
      this.renvoieSAG().parcoursGRD();
      System.out.print(" " + this.renvoieRacine().renvoieValeur() + " ");
      this.renvoieSAD().parcoursGRD();
    }
  }
  
  public void parcoursGDR () throws ArbreVideException {
    if (this.estVide()) {
      return;
    }
    else {
      this.renvoieSAG().parcoursGDR();;
      this.renvoieSAD().parcoursGDR();
      System.out.print(" " + this.renvoieRacine().renvoieValeur() + " ");
    }
  }
  
  public void parcoursParNiveaux () {
    
  }

}  // Fin de la classe Arbre.
//############################################################################

//############################################################################
/** La classe ArbreVideException correspond aux erreurs liées à
 *  l'utilisation du type Arbre, à savoir les tentatives d'accès
 *  au contenu (ou sous-arbres) d'un arbre vide.
 */
@SuppressWarnings("serial")
class ArbreVideException extends Exception {
  ArbreVideException(String s) {
    super("Erreur -> arbre vide lors d'un : " + s);
  }
}  // Fin de la classe ArbreVideException.
//############################################################################

//############################################################################
/** La classe TestArbre comporte de quoi mettre au point l'implantation de
 *  la classe Arbre (avec une fonction main permettant de tester chacune des
 *  méthodes du type Arbre.)
 *  NOTA-BENE : normalement vous n'aurez PAS BESOIN DE MODIFIER CETTE CLASSE,
 *              par contre sa lecture vous montrera un exemple d'utilisation
 *              de la "reflexivité" (ou "introspection").
 */
public class TestArbre {
  /** Programme principal qui teste les méthodes de la classe Arbre sur
   *  un arbre binaire de recherche comportant 7 entiers.
   */
  public static void main (String[] args) {
    Arbre a1 = creerArbreInitial();
    try {
      testerLaClasseArbre(a1);
    }
    catch (ArbreVideException e) {
      System.out.println(e);  // Remarquer qu'on peut faire println(e)
    }
  }

  /** Crée et retourne un arbre binaire a utiliser pour les tests.
   *  L'arbre généré est un arbre binaire de recherche qui contient: 
   *   <tt><pre>
   *                      100
   *                    /     \
   *                   40     120
   *                  /         \
   *                 38         150
   *                /  \
   *               12   39
   *  </pre></tt> 
   */
  public static Arbre creerArbreInitial () {
    return new Arbre(new Noeud(100),
                     new Arbre(new Noeud(40),
                               new Arbre(new Noeud(38),
                                         new Arbre(new Noeud(12)),
                                         new Arbre(new Noeud(39)) ),
                               new Arbre() ),
                     new Arbre(new Noeud(120),
                               new Arbre(),
                               new Arbre(new Noeud(150)) ) );
  }
  /** Propose à l'utilisateur de tester chacune des méthodes publiques
      et sans argument implantées dans la classe Arbre.
   */
  public static void testerLaClasseArbre(Arbre a) throws ArbreVideException  {
    Scanner sc = new Scanner(System.in);  // pour les saisies
    int reponse;
    System.out.println("## Test des opérations disponibles sur le type Arbre");
    System.out.println("## (l'arbre a été initialisé avec 7 entiers)");

    // On utilise les possibilités d'introspection de Java pour récupèrer sous
    // forme de tableau la liste des méthodes déclarées dans la classe Arbre :
    Method[] methodes = a.getClass().getDeclaredMethods();
    // Crée une liste avec les seules méthodes publiques ne prenant pas d'argument :
    ArrayList<Method> methodesATester = new ArrayList<Method>();
    for(Method m : methodes) {
      if(Modifier.isPublic(m.getModifiers()) && m.getParameterTypes().length==0) {
        methodesATester.add(m);
      }
    } 

    // Propose de tester une par une les différentes méthodes publiques :
    try {
      do {
        System.out.println();
        System.out.println("## Merci de choisir la méthode à tester parmi :");
        for(int j=0 ; j<methodesATester.size() ; j++) {
          System.out.printf("    %d..%s\n", j,  methodesATester.get(j).getName());
        }
        System.out.println("   -1...POUR SORTIR DU PROGRAMME");
        System.out.print("  VOTRE CHOIX : ");
        reponse = sc.nextInt();
        if (reponse<-1 || reponse >= methodesATester.size()) {
          System.out.println("## ERREUR : choix incorrect.");
          continue;
        }
        if (reponse>=0 && reponse < methodesATester.size()) {
          System.out.println("## Test de la méthode " +
              methodesATester.get(reponse).getName());
          Object resultat = methodesATester.get(reponse).invoke(a, (Object[])null);
          if (resultat != null) {
            System.out.print("===> RESULTAT : " + resultat);
          }
          System.out.println();
        }
      } while (reponse != -1);
    }
    catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    }
    finally {
      sc.close();
    }

  }
}  // Fin de la classe TestArbre.
//############################################################################