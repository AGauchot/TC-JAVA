// ----------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// ----------------------------------------------
//                Exercice sur les piles
// Simulation d'une calculette en notation polonaise inverse
// ----------------------------------------------

import java.util.Scanner; // pour les saisies

public class CalcPile {
  
  public static int factorielle (int n) {
    if (n>0) {
      return (n*factorielle(n-1));
    }
    else if (n==0) {
      return(1);
    }
    else {
      throw new ArithmeticException("Un entier positif est attendu");
    }
  }
  
  public static void effectuerOperation(Pile calc, String op) throws PileVideException {
    double y = calc.renvoyerSommet();
    double x;
    calc.depiler();

    double res = 0.;
    switch (op) {
    case "+":
      x = calc.renvoyerSommet();
      calc.depiler();
      res = x + y;
      break;
    case "-":
      x = calc.renvoyerSommet();
      calc.depiler();
      res = x - y;
      break;
    case "*":
      x = calc.renvoyerSommet();
      calc.depiler();
      res = x * y;
      break;
    case "/":
      x = calc.renvoyerSommet();
      calc.depiler();
      res = x / y;
      break;
    case "exp":
      res = Math.exp(y);
      break;
    case "cos":
      res = Math.cos(y);
      break;
    case "sin":
      res = Math.sin(y);
      break;
    case "log":
      res = Math.log(y);
      break;
    case "sqrt":
      res = Math.sqrt(y);
      break;
    case "!":
      res = factorielle( (int)y); // si l'utilisatuer rentre un flottant, on prend sa partie entière
      break;
    default:
      System.out.println("Erreur : Opérateur inconnu...");
      // On rempile les opérandes avant de sortir de la fonction :
      calc.empiler(y);
      return;
    }
    // On empile le résultat et on affiche
    calc.empiler(res);
  }

  public static void main(String[] args) throws PileVideException {
    Pile calcul = new Pile();
    boolean finExpression = false;
    boolean sortieProgramme = false;
    Scanner sc = new Scanner(System.in);
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("   Calculette en notation polonaise inverse");
    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println(" On peut saisir toute une expression, ou bin taper");
    System.out.println("   nombres et opérateurs au fur et à mesure.");
    System.out.println(" L'expression doit se terminer par =");
    System.out.println(" Pour sortir, il suffit de taper Q.");
    do {
      System.out.print("\n----------------------------> ");
      do {
        // On saisit des nombres, des opérateurs, ou '=' ou 'Q'...
        if (sc.hasNextDouble()) { // un nombre a été saisi
          calcul.empiler(sc.nextDouble()); // on lit ce nombre et on l'empile
        } else {
          // Si ce n'est PAS un nombre, cela doit normalement être un opérateur
          // connu, ou bien '=' ou 'Q'
          String s = sc.next();   // lecture du "mot" suivant
          switch (s) {
          case "+":
          case "-":
          case "*":
          case "/":

            // On vérifie que la pile contient bien 2 opérandes...
            if (calcul.renvoyerHauteur() < 2) {
              System.out.print(" ##### J'ATTENDS UN NOMBRE (ou bien ");
              System.out.print("= pour afficher le resultat, ");
              System.out.println(" ou encore Q pour arreter) !!");
            } else {
              // ... si oui, on effectue l'opération
              effectuerOperation(calcul, s);
            }
            break;
            
          // Opérateurs unaires
          case "exp":
          case "sqrt":
          case "cos":
          case "sin":
          case "log":
          case "!":
            // On vérifie que la pile contient bien 1 opérande...
            if (calcul.renvoyerHauteur() < 1) {
              System.out.print(" ##### J'ATTENDS UN NOMBRE (ou bien ");
              System.out.print("= pour afficher le resultat, ");
              System.out.println(" ou encore Q pour arreter) !!");
            } else {
              // ... si oui, on effectue l'opération
              effectuerOperation(calcul, s);
            }
            break;
          case "Q":
          case "q":
            sortieProgramme = true;
          case "=":
            finExpression = true;
            break;
          
          case "pi":
          case "PI":
            calcul.empiler(3.14159);
            break;
          case "e":
          case "E":
            calcul.empiler(2.7);
            break;
          default:
            System.out.printf("Erreur : opérateur %s inconnu !", s);
          } // Fin du switch sur le (premier) caractère du mot
        } // Fin du cas où réponse n'est pas un nombre
      } while (! finExpression);

      // Après fin de saisie
      if (! sortieProgramme) {
        // On a juste terminé de saisir une expression (avec = à la fin)
        // Vérification qu'il ne reste bien qu'un nombre sur la pile
        if (calcul.renvoyerHauteur() == 1) {
          System.out.println("### RESULTAT = " + calcul.renvoyerSommet());
        } else {
          // Il y a eu problème...
          System.out.println("### VOTRE EXPRESSION EST ERRONNEE !!");
          System.out.print("Etat de la pile au moment du '=' : ");
          calcul.afficher();
        }
        // Ré-initialiser pour pouvoir saisir une nouvelle expression
        finExpression = false;
        // Vider la pile pour essayer une nouvelle expression
        // (pour le cas de plusieurs calculs successifs)
        calcul.vider();
      } // Fin de traitement d'un expression
      else {
        // L'utilisteur veut sortir du programme !
        sc.close();
        System.out.println("### VOUS AVEZ DEMANDE L'ARRET DU PROGRAMME");
        System.out.println("### A BIENTOT !! ");
      }
    } while (! sortieProgramme);
  }

}
