// ----------------------------------------------
//    Algorithmique et programmation en Java     
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année 
// ----------------------------------------------
//   interception d'exceptions avec try et catch
// ----------------------------------------------

import java.util.Scanner;  

public class Debordement {
  public static void main(String args[]) {
    final int TAILLE_TABLEAU = 15;
    // Déclaration et création du tableau :
    int[] tableau = new int[TAILLE_TABLEAU];
    // On remplit le tableau d'entiers compris entre -5 et 5 :
    for (int i=0 ; i<tableau.length ; i++) {
      tableau[i] = (int)(10*Math.random())-5;
      System.out.printf("tableau[%d] = %d\n",  i, tableau[i]);
    }
    System.out.println();
    Scanner sc = new Scanner(System.in);  // pour les saisies
    // Saisie de l'indice
    System.out.print("Donner un indice : ");
    int indice = sc.nextInt();
    
    boolean b =false; //indique si on est passé par un catch (ie si une exception a été levé)
    try {
      
      System.out.printf("Vous avez choisi : tableau[%d] = %d\n", indice, tableau[indice]);
      // On divise chaque élément du tableau par tableau[indice], et on affiche le résultat :
      System.out.println();
      int diviseur = tableau[indice];
      System.out.println("Tableau divisé par tableau[" + indice + "] = " + diviseur);
      for (int k=0 ; k<tableau.length ; k++) {
        tableau[k] /= diviseur;
        System.out.printf("tableau[%d] = %d\n", k, tableau[k]);
      }
      
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Indice non adapté");
      b=true;
    } catch (ArithmeticException e) {
      System.out.println("Div par 0");
      b=true;
      
    } finally {
      if (b) {    //s'il y a eu une exception, on redonne alors à l'utilisateur une chance de donbner un indice valable
        System.out.println("Veuillez entrer un indice correct cette fois-ci svp");
        
        //on remet le même programme que dessus
        System.out.print("Donner un indice : ");
        int indice2 = sc.nextInt();
        System.out.printf("Vous avez choisi : tableau[%d] = %d\n", indice2, tableau[indice2]);
        // On divise chaque élément du tableau par tableau[indice], et on affiche le résultat :
        System.out.println();
        int diviseur = tableau[indice2];
        System.out.println("Tableau divisé par tableau[" + indice2 + "] = " + diviseur);
        for (int k=0 ; k<tableau.length ; k++) {
          tableau[k] /= diviseur;
          System.out.printf("tableau[%d] = %d\n", k, tableau[k]);
        }
      }
    }
  }
}

