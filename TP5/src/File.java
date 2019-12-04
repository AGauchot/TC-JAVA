public class File {
  
  // ATTRIBUTS ////////////////////////////////////////////////

  Maillon maillonTete;
  Maillon maillonQueue;
  int longueur;
  
  // CONSTRUCTEURS ////////////////////////////////////////////

  public File() {
    this.maillonTete = null;
    this.maillonQueue = null;
    longueur = 0;
  }
  
  // Constructeur par recopie
  public File(File p) {
    longueur = p.renvoyerLongueur();
    maillonTete = new Maillon(p.maillonTete);
    maillonQueue = new Maillon(p.maillonQueue);
  }
  
  // METHODES /////////////////////////////////////////////////

  public void ajouter(double x) {
    Maillon nvMaillon = new Maillon(x);
    maillonQueue.lierAvecSuivant(nvMaillon);
    maillonQueue=nvMaillon;
    longueur ++;
  }
  
  public void enlever() throws FileVideException {
    if ( !(this.estVide()) ) {
      Maillon nvMaillon = maillonTete.renvoyerSuivant();
      maillonTete = nvMaillon;
      longueur = longueur - 1;

    } else {
      throw new FileVideException("Attention ! La file est vide");
    }
  }

  public double renvoyerTete() throws FileVideException {
    if ( !(this.estVide()) ) {
      double x = maillonTete.renvoyerValeur();
      return x;
    } else {
      throw new FileVideException("Attention ! La file est vide");
    }

  }
  
  public boolean estVide () {
    return (longueur == 0);
  }
  
  
  public void afficher() {
    while (longueur > 0) {
      System.out.println(maillonTete.renvoyerValeur());
      maillonTete = maillonTete.renvoyerSuivant();
      longueur = longueur -1;
    }
    System.out.println("FIN \n");
  }
  
  public int renvoyerLongueur()  {   
    return longueur;
  }
  
  public void vider() throws FileVideException { //dans la pratique, cette méthode ne lève jamais d'exception
    while (longueur > 0) {
      this.enlever();
    }
      
  }
  
  // MAIN ////////////////////////////////////////////////////
  
  public static void main(String[] args) throws PileVideException {
    
    File f = new File();
    
    
    
    
    
  }
}