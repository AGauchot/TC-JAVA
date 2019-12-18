// -------------------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// -------------------------------------------------------
//  Utilisation de classes prédéfinies (Listes, Collections),
//           Heritage, implantation d'interfaces
// -------------------------------------------------------

import java.util.*;            // pour les collections

public class Magasin {

  // ATTRIBUTS //////////////////////////////////////////////////
  //################ A COMPLETER 1a #####################                
  List<Produit> catalogue;
  
  // CONSTRUCTEURS //////////////////////////////////////////////
  //################ A COMPLETER 1b #####################                
  public Magasin() {
    catalogue  = new ArrayList<Produit>();
  }

  // METHODES ///////////////////////////////////////////////////
    
  
  // Pour faciliter les tests
  private void ajouterQuelquesProduits() {
    catalogue.add(new Produit("PEN-001", "Stylo Mines-ParisTech", 1.5f));
    catalogue.add(new Produit("MUG-001", "Mug Mines-ParisTech", 7.5f));
    catalogue.add(new Produit("TSHI-001-XL", "T-shirt logo Mines taille XL", 12.5f));
    catalogue.add(new Produit("TSHI-001-L", "T-shirt logo Mines taille L", 12f));
    catalogue.add(new Produit("TSHI-001-M", "T-shirt logo Mines taille M", 11.5f));
    catalogue.add(new Produit("HAT-001", "Casquette Mines-ParisTech", 10f));
  }
  
  // Recherche l'indice d'un Produit du catalogue à partir de sa référence
  // ou -1 si non trouvé :
  public int renvoyerIndice(String ref) {
    //################ A COMPLETER 2 #####################
    ListIterator<Produit> iter = this.catalogue.listIterator();
    while ( iter.hasNext() ) {
      if ( iter.next().renvoyerReference() == ref ) {
        return iter.previousIndex();
      }
    }
    return -1;
  }   
  
  // Affichage du menu et récupération de la réponse :
  @SuppressWarnings("resource")
  public String afficherMenu() {
    Scanner sc = new Scanner(System.in);  // pour les saisies  
    String choix="aucun";   // pour les saisies
    System.out.println();
    System.out.println("Taper :");
    System.out.println(" + ou - : ajouter ou enlever un produit au catalogue"); 
    System.out.println(" ? pour Rechercher un produit dans le catalogue");
    System.out.println(" A pour Afficher le catalogue");
    System.out.println(" R ou N ou P pour trier par reference ou nom ou prix");
    System.out.println(" Q pour Quitter");
    choix = sc.nextLine();
    return choix;
  }

  //Exécution d'une tâche en fonction du choix passé en paramètre:
  @SuppressWarnings("resource")
  private void executerTache(String choix) {
    Scanner sc = new Scanner(System.in);  // pour les saisies  
    switch(choix) {
    case "A":
      //################ A COMPLETER 3 #####################     
      System.out.println("Le catalogue contient : \n");
      ListIterator<Produit> iter = this.catalogue.listIterator();
      while ( iter.hasNext() ) {
        System.out.println(iter.next());
      }
      break;
      
    case "+":
      //################ A COMPLETER 4 #####################  
      Produit p;
      System.out.println("Nom du produit à ajouter : ");
      String nom = sc.nextLine();
      System.out.println("Réf du produit : ");
      String ref = sc.nextLine();    
      System.out.println("Prix du produit : ");
      float prix = sc.nextFloat();
      p = new Produit(ref, nom, prix);
      this.catalogue.add(p);
      break;
      
    case "-": 
      //################ A COMPLETER 5 #####################                
      System.out.println("Réf du produit à supprimer : ");
      String refSupp = sc.nextLine();
      ListIterator<Produit> iter2 = this.catalogue.listIterator();
      while ( iter2.hasNext() ) {
        if ( iter2.next().renvoyerReference() == refSupp ) {
          iter2.remove();
        }
      }     
      break;
      
    case "?": 
      //################ A COMPLETER 6 #####################                
      break;
    case "R": 
      //################ A COMPLETER 8a #####################                
      break;
    case "N": 
      //################ A COMPLETER 8b #####################                
      break;
    case "P": 
      //################ A COMPLETER 8c #####################     
      Collections.sort(this.catalogue, new ComparateurPrix());
      break;
    case "Q":
      break;
    default:
      System.out.println("Choix non proposé");
    }
  }
  
  // PROGRAMME PRINCIPAL :
  public static void main(String[] args) {
    Magasin maBoutique = new Magasin();     // création du magasin
    //################ A COMPLETER 1c #####################     
    maBoutique.ajouterQuelquesProduits();
    
    String choix;   // pour les saisies
    do {
      choix = maBoutique.afficherMenu();    // affichage du menu
      maBoutique.executerTache(choix);
    } while (! choix.equals("Q"));    
  }
  
} // FIN DE LA CLASSE CATALOGUE -------------------------------------------------


// 3 classes définissant des comparateurs de 2 produits selon leurs prix, 
// leurs noms, leurs références. Elles implémentent l'interface Comparator et
// sont paramétrées par <Produit>. 

class ComparateurPrix implements Comparator <Produit> {
  public int compare(Produit p1, Produit p2) {
    return (int)(p1.renvoyerPrix() - p2.renvoyerPrix());        
  }
}

class ComparateurNom implements Comparator <Produit> {
  public int compare(Produit p1, Produit P2) {
//################ A COMPLETER 7a #####################
    return 0;        
  }
}

class ComparateurReference implements Comparator <Produit>{
  public int compare(Produit p1, Produit P2) {
//################ A COMPLETER 7b #####################        
    return 0;        
  }
}

// FIN DES CLASSES "COMPARATEUR" --------------------------------------------