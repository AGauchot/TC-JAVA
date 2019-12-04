public class Pile {
  
  // ATTRIBUTS ////////////////////////////////////////////////

  Maillon m;
  int hauteur;
  
  // CONSTRUCTEURS ////////////////////////////////////////////

  public Pile() {
    this.m = null;
    hauteur = 0;
  }
  
  public Pile(Maillon m) {
    if (m==null) {
      this.m = null;
      hauteur = 0;
    }
    else {
      this.m = m;
      int h = 1;
      Maillon m1 = m.renvoyerSuivant();
      while (m1 != null) {
        h++;
        m1 = m1.renvoyerSuivant();
      }
      hauteur = h;
    }
  }
  
  // Constructeur par recopie
  public Pile(Pile p) {
    hauteur = p.renvoyerHauteur();
    m = new Maillon(p.m);
  }
  
  // METHODES /////////////////////////////////////////////////

  public void empiler(double x) {
    Maillon nvMaillon = new Maillon(x);
    nvMaillon.lierAvecSuivant(m);
    m=nvMaillon;
    hauteur ++;
  }
  
  public double depiler() throws PileVideException {
    if ( !(this.estVide()) ) {
      Maillon nvMaillon = m.renvoyerSuivant();
      double x = m.renvoyerValeur();
      m = nvMaillon;
      hauteur = hauteur - 1;
      return x;
    } else {
      throw new PileVideException("Attention ! La pile est vide");
    }
  }

  public double renvoyerSommet() throws PileVideException {
    if ( !(this.estVide()) ) {
      double x = m.renvoyerValeur();
      return x;
    } else {
      throw new PileVideException("Attention ! La pile est vide");
    }

  }
  
  public boolean estVide () {
    return (hauteur == 0);
  }
  
  public void afficher() {
    if (hauteur == 0) {
      System.out.println("FIN \n");
    }
    else {
      System.out.println(m.renvoyerValeur());
      Maillon m1 = m.renvoyerSuivant();
      Pile p = new Pile(m1);
      p.afficher();
    }
  }
  
  public int renvoyerHauteur()  {   
    return hauteur;
  }
  
  public void vider() throws PileVideException { //dans la pratique, cette méthode ne lève jamais d'exception
    while (hauteur > 0) {
      this.depiler();
    }
      
  }
  
  // MAIN ////////////////////////////////////////////////////
  
  public static void main(String[] args) throws PileVideException {
    
    // Test des différentes méthodes de l'exercice 1
    
    /*Pile p = new Pile();
    p.afficher();
    p.empiler(1.0);
    p.afficher();
    p.empiler(2.0);
    p.afficher();
    System.out.println("Sommet : " + p.renvoyerSommet());
    p.vider();
    p.afficher();
    p.depiler();*/
    
    // Test des différentes méthodes de l'exercice 2
    
    Pile p1 = new Pile();
    p1.empiler(1);
    p1.empiler(2);;
    
    Pile p2 = new Pile(p1);
    System.out.println("p2 avant qu'on dépile p1 :");
    p2.afficher();
    
    p1.depiler();
    
    System.out.println("p2 après qu'on ait dépilé p1 :");
    p2.afficher();
    System.out.println("p1 :");
    p1.afficher();
    
  }
}