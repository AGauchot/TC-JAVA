
// ----------------------------------------------
//    Algorithmique et programmation en Java     
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année 
// ----------------------------------------------
//                    Exceptions
// ----------------------------------------------

/*
 * Ce code génère une exception si les indices sont inversés (IllegalArgumentException)
 * ou si un des indices est en dehors des limites (ArrayIndexOutOfBoundsException)
 */
import java.util.Arrays;
import java.util.Scanner;

class MonExceptionIndiceNegatif extends Exception {
  //Constructeur
  MonExceptionIndiceNegatif (String s) {
    super(s);
  }
}

class MonExceptionIndiceTropGrand extends Exception {
  //Constructeur
  MonExceptionIndiceTropGrand (String s) {
    super(s);
  }
}

class MonExceptionIndicesInverses extends Exception {
  //Constructeur
  MonExceptionIndicesInverses (String s) {
    super(s);
  }
}



public class TestException3 {

  public static void main(String[] args) {

    final int TAILLE_TABLEAU = 10;
    int tab[] = new int[TAILLE_TABLEAU];
    Scanner sc = new Scanner(System.in); // pour les saisies
    Arrays.fill(tab, 1); // initialisation arbitraire de toutes les cases à 1
    System.out.print("remise à zéro entre (taper 2 indices) : ");
    int a = sc.nextInt();
    int b = sc.nextInt();

    raz(tab, a, b);
    System.out.println("Le tableau contient maintenant :");
    for (int x : tab) {
      System.out.print(x + "    ");
    }

  }
  
  
  
  
  
  
  
  // Remise à zéro des cases de tab dont les indices sont dans [a..b] :
  public static void raz(int tab[], int a, int b) {
    try {
      
      if (b<0) {
        throw new MonExceptionIndiceNegatif("Indice négatif");
      }
      else if (a>=tab.length) {
        throw new MonExceptionIndiceTropGrand("Indice trop grand");
      }
      else if (a>b) {
        throw new MonExceptionIndicesInverses("Indices inversés");
      }
      else {
        Arrays.fill(tab, a, b, 0);
        System.out.println("remise à zéro entre " + a + " et " + b + " effectuée");
      }
    } catch (MonExceptionIndiceNegatif e) {
      System.out.println(e.getMessage());
      
    } catch (MonExceptionIndiceTropGrand e) {
      System.out.println(e.getMessage());
      
    }catch (MonExceptionIndicesInverses e) {
      System.out.println(e.getMessage());
    }
  }
}
