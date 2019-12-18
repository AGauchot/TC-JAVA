// -------------------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// -------------------------------------------------------
//  Utilisation de classes prédéfinies (Listes, Collections),
//           Heritage, implantation d'interfaces
// -------------------------------------------------------

class Produit {
  
  // ATTRIBUTS //////////////////////////////////////////////////
  private String reference;  // code alphanumérique du produit
  private String nom;        // nom du produit
  private float prix;        // prix hors taxe du produit

  // CONSTRUCTEURS //////////////////////////////////////////////
  public Produit(String reference, String nom, float prix) {
    this.reference = new String(reference);
    this.nom = new String(nom);
    this.prix = prix;
  }
  
  // METHODES ///////////////////////////////////////////////////
  
  public String toString() {
    return ( this.renvoyerNom() + " à " + this.renvoyerPrix() + " euros, de réf " + this.renvoyerReference() );
  }
  // ACCESSEURS (accès public aux 3 attributs privés) :
  public String renvoyerReference() {
    return reference;
  }
  public String renvoyerNom() {
    return nom;
  }
  public float renvoyerPrix() {
    return prix;
  }

  // METHODE D'AFFICHAGE
  public void afficher() {
    System.out.println(this) ;
  }
 
  // ADAPTATION DE LA METHODE : public String toString()
  // Retourne une chaîne avec les informations relatives au produit :
  //############ A COMPLETER #############################
  
  // PROGRAMME PRINCIPAL (test de la classe) :
  public static void main(String [] args) {
  	Produit p1 = new Produit("LEV51", "Pantalon LEVI'S 51", 53.0f);
  	Produit p2 = new Produit("TSB", "Tee Shirt 'Brice'", 13.50f);
  	Produit p3 = new Produit("NKT1", "Chaussures Sport Nike Air Tennis", 80.0f);
  	Produit p4 = new Produit("CHBA", "Blouson cuir Chevignon", 324.0f);
  	System.out.println(p1);
  	System.out.println(p2);
  	System.out.println(p3);
  	System.out.println(p4);
  }  

}  // FIN DE LA CLASSE PRODUIT