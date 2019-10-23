class Bateau {
  
  // -----------------------------------------------------------------
  // LES ATTRIBUTS
  // -----------------------------------------------------------------

  private int taille;
  private int[][] coordonnees;   //contient la liste des coordonnées des différentes cases et de leur état (0=touché, 1=intact)
                                //exemple : [ [2,3,0], [3,3,1] ]
  
  //  ----------------------------------------------------------------
  //  CONSTRUCTEURS
  //  ----------------------------------------------------------------
  
  public Bateau (int taille, int taille_grille_x, int taille_grille_y) {
    this.taille = taille;
    
    int[][] c = new int[taille][3];
    double rx = Math.random();    //on choisit de façon aléatoire la position d'un bout du bateau
    double ry = Math.random();
    int x =(int) (rx * taille_grille_x);    //coordonnées du bout du bateau
    int y = (int) (ry * taille_grille_y);
    c[0][0] = x;
    c[0][1] = y;
    
    double r = Math.random();   //on détermine ici la direction du bateau pour le construire à partir du bout déjà placé
    int direction =  (int) r*4;
    
    boolean bool = true;   //indique quand on a trouvé une direction qui convient (il vaut alors false)
    while (bool) {
      if ( (direction == 0) && (x+taille <= taille_grille_x) ) {    //direction = 0 ==> vers la droite && il y la place pour que le bateau rentre
        bool=false;
        for (int i=1; i<taille; i++) {
          c[i][0] = x+i;
          c[i][1] = y;
        }
      }
      else if (direction == 0) {
        direction = 1;
      }
      
      else if ( (direction == 1) && (y+taille <= taille_grille_y) ) {   //direction = 1 ==> vers la haut && il y la place pour que le bateau rentre
        bool=false;
        for (int i=1; i<taille; i++) {
          c[i][0] = x;
          c[i][1] = y+i;
        }
      }
      else if (direction == 1) {
        direction = 2;
      }
      
      if ( (direction == 2) && (x-taille+1 >= 0) ) {    //direction = 2 ==> vers la gauche && il y la place pour que le bateau rentre
        bool=false;
        for (int i=1; i<taille; i++) {
          c[i][0] = x-i;
          c[i][1] = y;
        }
      }
      else if (direction == 2) {
        direction = 3;
      }
    
      else if ( (direction == 3) && (y-taille+1 >= 0) ) {   //direction = 3 ==> vers le bas && il y la place pour que le bateau rentre
        bool=false;
        for (int i=1; i<taille; i++) {
          c[i][0] = x;
          c[i][1] = y-i;
        }
      }
      else if (direction == 3) {
        direction = 0;
      }

    
    
    for (int i=0; i<taille; i++) {
      c[i][2] = 1;    //on initialise tous les segments du bateau à intact
    }
  }
    
  this.coordonnees = c;
  
 }  //fin du constructeur bateau

  // -----------------------------------------------------------------
  // LES METHODES
  // -----------------------------------------------------------------


  public char receptionTir (int x, int y) {   //renvoie 'T' si le bateau a été touché, 'C' si coulé, '*'
    
    boolean estTouche = false;
    int compteurTouche = 0;
    
    for (int i=0; i<taille; i++) {
      int a = coordonnees [i][0]; int b = coordonnees [i][1];
      
      if ((a==x) && (b==y)) {   //ie si le tir touche le bateau (reste à déterminer si c'est touché ou coulé)
        estTouche = true;
      }
      else {
        if (coordonnees [i][2] == 1) {
          compteurTouche ++;
        }
      } 
    }
    if ( estTouche && (compteurTouche == (taille-1)) ) {
      return 'C';
    }
    else if (estTouche) {
      return 'T';
    }
    else {
      return '*';
    }
  }   //fin de la méthode receptionTir
  
  public boolean chevauchement (Bateau b) {   //renvoie un booléen qui indique si 2 bateaux se chevauchent (true si c'est le cas)
    
  }   //fin de la méthode chevauchement 
}   //fin de la classe bateau