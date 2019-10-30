// -------------------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// -------------------------------------------------------
//  Sauvegarde et relecture d'objets sur fichier.
// -------------------------------------------------------

import java.util.Scanner;

/* Classe regroupant nom et prix d'un produit. */
class Produit  {
  /* Nom du produit. */
  private String nom;
  /* Prix du produit. */
  private float prix;
  
  /* Constructeur nécessitant le nom et le prix. */
  public Produit(String nom, float prix) {
    this.nom = new String(nom);
    this.prix = prix;
  }
  
  /* Methodes publiques pour accéder aux attributs */
  public String renvoieNom() {
    return nom;
  }
  public float renvoiePrix() {
    return prix;
  }
  
  /* Affichage du nom et du prix du produit. */
  public void afficher() {
    System.out.println(nom + " : " + prix + " EUROS");
  }
}

/* Programme gérant un catalogue de produits. */
public class Catalogue {
  static public void main(String[] args) {
    Produit [] tabProduits = null;
    Scanner sc = new Scanner(System.in);  // pour les saisies
    char action;
    do {
      System.out.println();
      System.out.println("Taper :");
      System.out.println(" C pour Créer le catalogue");
      System.out.println(" A pour l'Afficher");
      System.out.println(" S pour Sauvegarder sur fichier");
      System.out.println(" L pour Lire sur fichier");
      System.out.println(" Q pour Quitter");
      action = sc.next().charAt(0);
      try{
        switch(action) {
        case 'C':
          System.out.print("Nombre de produits ? ");
          int dim = sc.nextInt();
          tabProduits = new Produit[dim];
          for (int i=0; i<tabProduits.length; i++) {
            System.out.print("Nom du produit numero " + (i+1) + " ? ");
            String nom = sc.next();
            System.out.print(" Prix ? ");
            float prix = sc.nextFloat();
            tabProduits[i] = new Produit(nom, prix);
          }
          break;
        case 'A':
          for (Produit p : tabProduits) {
            p.afficher();
          }
          break;
        // ########################################################
        // #### A COMPLETER (en ajoutant case 'S' et case 'L') #### 
        // ########################################################
        case 'Q':
          break;
        default:
          System.out.println("Choix non proposé");
        }
      }
      catch (NullPointerException e) {
        System.out.println(e);
        System.out.println("Essayer de créer d'abord le catalogue");
      }
    } while (action != 'Q'); 
  }
}