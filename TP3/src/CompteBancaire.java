// ------------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// ------------------------------------------------
//   Ecriture et utilisation d'une classe 
// ------------------------------------------------


public class CompteBancaire {
  static double decouvertMaxiParDefaut = 500.0;
  static int identifiantCourant = 0;
  
  // -----------------------------------------------------------------
  // LES ATTRIBUTS
  // -----------------------------------------------------------------

  private String nomTitulaire;
  private double solde;
  private double plafond;
  private final int identifiant;

  // ------------------------------------------------------------------
  // LES CONSTRUCTEURS
  // ------------------------------------------------------------------

  // Le constructeur « principal » :
  public CompteBancaire(String nom, double versementInitial) {
    nomTitulaire = new String(nom);
    solde = versementInitial;
    plafond = decouvertMaxiParDefaut;
    identifiant = identifiantCourant;
    identifiantCourant++;
  }
  
  // Un 2-ème constructeur pour ouvrir un cpte sans versement initial :
  public CompteBancaire(String nom) {
    this(nom, 0);  // appel du constructeur principal
  }

  // ------------------------------------------------------------------
  // LES METHODES "ORDINAIRES"
  // ------------------------------------------------------------------

  public double renvoyerSolde() {
    return solde;
  }
  public String renvoyerTitulaire() {
    return new String(nomTitulaire);
  }

  public void afficher() {
    if (solde<0) {
      System.out.println("Le solde de " + nomTitulaire + " est de !!!" + solde + "!!! Identifiant : " + identifiant);
    }
    else {
      System.out.println("Le solde de " + nomTitulaire + " est de " + solde + ". Identifiant : " + identifiant);
    }
  }

  // METHODES DE RETRAIT, DEPOT, VIREMENT
  // ######################################
  
  public void deposer (int montant) {
    if (montant < 0) {
      System.out.println("Erreur : Le montant à déposer est négatif");
    }
    else {
      solde = solde + montant;
    }
  }
  
  public void retirer (int montant) {
    if (montant>solde) {
      System.out.println("Solde insuffisant pour retrait");
    }
    else {
      solde = solde - montant;
    }
  }
  
  public void virementVers (int montant, CompteBancaire destinataire) {
    if (montant > solde) {
      System.out.println("Solde insuffisant pour virement");
    }
    else {
      solde = solde - montant;
      destinataire.solde = destinataire.solde + montant;
    }
  }
  // ----------------------------------------------------------------
  // LE PROGRAMME PRINCIPAL (se contente ici de tester les methodes)
  // ----------------------------------------------------------------
  
  public static void main(String[] args) {
    CompteBancaire c1 = new CompteBancaire("Dupond");
    CompteBancaire c2 = new CompteBancaire("Martin", 500);
    System.out.println("Juste après création :");
    c1.afficher();
    c2.afficher();

    c1.deposer(1000);
    c1.deposer(-100);
    c2.retirer(300);
    c1.virementVers(400,c2);
    c2.retirer(1000);
    System.out.println("Après qqs opérations :");
    c1.afficher();
    c2.afficher();
    
    

  } // fin de la fonction main()
  
} // fin de la classe CompteBancaire