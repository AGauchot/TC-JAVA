class Bateau {
  
  // -----------------------------------------------------------------
  // LES ATTRIBUTS
  // -----------------------------------------------------------------

  private int taille;
  private int[][] coordonnes;   //contient la liste des coordonnées des différentes cases et de leur état (0=touché, 1=safe)
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
    
    double r = Math.random();   //on détermine ici la direction du bateau à partir du bout déjà placé
    int direction =  (int) r*4;
    if ( (direction == 0) && (x+taille < taille_grille_x) ) {    //direction = 0 ==> vers la droite && il y la place pour que le bateau rentre
      for (int i=1; i<taille; i++) {
        c[i][0] = x+i;
        c[i][0] = y;
      }
    }
    else if ( (direction == 1) && (y+taille < taille_grille_y) ) {   //direction = 1 ==> vers la haut && il y la place pour que le bateau rentre

        
      }

    
    
    for (int i=0; i<taille; i++) {
      c[i][2] = 1;    //on initialise tous les segments du bateau à safe
    }
  }
  
}   //fin de la classe bateau