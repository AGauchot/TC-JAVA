// ----------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// ----------------------------------------------
//   Ecriture et utilisation d'une classe
//              Tableau d'objets
// ----------------------------------------------

import java.util.Scanner;     // pour les saisies


public class Banque {

  // -----------------------------------------------------------------
  // LES ATTRIBUTS STATIQUES
  // (attributs partagés par toutes les instances de la classe)
  // -----------------------------------------------------------------

  public static final int NB_MAX_CLIENT = 20; // une très petite banque !

  // -----------------------------------------------------------------
  // LES ATTRIBUTS "ORDINAIRES" (non-statiques)
  // -----------------------------------------------------------------
  
  private String nomBanque;
  private int nbClients;
  private CompteBancaire [] tabComptes;
  
  // ------------------------------------------------------------------
  // LES CONSTRUCTEURS
  // ------------------------------------------------------------------

  public Banque(String nom) {
    nomBanque = nom;
    nbClients = 0;
    tabComptes = new CompteBancaire[NB_MAX_CLIENT];
  }

  // ------------------------------------------------------------------
  // LES METHODES "ORDINAIRES"
  // ------------------------------------------------------------------
  
  // Description de la banque (son nom, son nombre de clients,
  //   et le descriptif de chaque compte)
  public void afficher() {
    System.out.println("Bonjour et bienvenue à la banque " + nomBanque + ". Nous nous occupons de " + nbClients + " clients qui sont parfaitement satisfait des services que l'on propose.\n Ci-joint le récapitulatif de nos comptes client");
    int n = tabComptes.length;
    for (int i=0; i<n; i++) {
      tabComptes[i].afficher();
    }
  }
  
  // Ajout d'un compte à la banque
  public void ajoute(CompteBancaire c) {
    tabComptes[nbClients] = c;
    nbClients++;
  }
  
  // Recherche du compte d'un client, ou null si pas trouvé
  public CompteBancaire recherche(String nom)   {
    /*int i=0;
    while (( i<NB_MAX_CLIENT ) && ( !( (tabComptes[i].renvoyerTitulaire()).equals(nom) ) )) {
      i++;
    }
    if (i == NB_MAX_CLIENT) {
      return null;
    }
    else {
      return (tabComptes[i]);
    }
    */
    for (int i=0; i<NB_MAX_CLIENT; i++) {
      
    }
  }
  
  // Dépot d'un montant sur le compte d'un client
  //   (retourne vrai si l'opération a pu être effectuée)
  public boolean depose(String nom, double montant) {
    // ######################################
    // ##########" A COMPLETER ##############
    // ######################################
    return false;
  }
  
  // Retrait d'un montant sur le compte d'un client,
  //  (retourne vrai si l'opération a pu être effectuée)
  public boolean retire(String nom, double montant)   {
    // ######################################
    // ##########" A COMPLETER ##############
    // ######################################
    return false;
  }

  // Virement entre deux clients (si possible)
  //  retourne vrai si l'opération a pu être effectuée
  public boolean vire(String debite, String credite, double montant) {
    // ######################################
    // ##########" A COMPLETER ##############
    // ######################################
    return false;
  }
  
  // ----------------------------------------------------------------
  // LE PROGRAMME PRINCIPAL (se contente ici de tester les methodes)
  // ----------------------------------------------------------------

  static public void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String nomTitulaire; // pour les saisies ci-dessous
    double montant; // pour les saisies ci-dessous

    Banque lyonnais = new Banque("Credit Lyonnais");
    
    // quelques clients de la banque
    lyonnais.ajoute(new CompteBancaire("Calvin", 100.0));
    lyonnais.ajoute(new CompteBancaire("Hobbes", -10.0));
    lyonnais.ajoute(new CompteBancaire("Suzy", 100.0));
    
    // la banque ne ferme jamais;-)
    while (true) {
      // affiche un menu minimal
      System.out.println();
      System.out.println("### GESTION DE LA BANQUE");
      System.out.print("(i)nfos (a)joute (c)onsulte (d)epose (r)etire (v)ire (q)uitte: ");      
      char choix=sc.next().charAt(0);
      sc.nextLine(); // Pour sauter le passage à la ligne tapé par l'utilisateur
                     // (important pour que les prochains nextLine() fonctionnent)

      switch ( choix ) {
      case 'q': // QUITTE l'application guichet
        System.out.println("fermeture du programme");
        return;
      case 'i': // INFOS sur la banque
        lyonnais.afficher();
        break;
      case 'a': // AJOUTE un nouveau compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        System.out.print("montant: ");
        montant = sc.nextDouble();
        // le compte est créé ici
        lyonnais.ajoute(new CompteBancaire(nomTitulaire, montant));
        break;
      case 'c': // CONSULTE un compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        CompteBancaire c = lyonnais.recherche(nomTitulaire);
        if (c==null) {
          System.out.println("Pas de compte au nom de " + nomTitulaire);
        }
        else {
          System.out.print("compte: ");
          c.afficher();
        }
        break;
      case 'd': // DÉPOSE sur un compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        System.out.print("montant: ");
        montant = sc.nextDouble();
        System.out.println("depot: " + lyonnais.depose(nomTitulaire, montant));
        break;
      case 'r': // RETRAIT d'un compte
        System.out.print("nom: ");
        nomTitulaire = sc.nextLine();
        System.out.print("montant: ");
        montant = sc.nextDouble();
        System.out.println("retrait: " + lyonnais.retire(nomTitulaire, montant));
        break;
      case 'v': // VIRE entre deux comptes
        // ######################################
        // ##########" A COMPLETER ##############
        // ######################################
        break;

        // FERMETURE DE COMPTE
        // ######################################
        // ##########" A COMPLETER ##############
        // ######################################

        // EN-COURS TOTAL
        // ######################################
        // ##########" A COMPLETER ##############
        // ######################################
      
      default:
        System.err.println("action inconnue...");
      }
    }
  } // fin de la fonction main()
  
} // fin de la classe Banque
