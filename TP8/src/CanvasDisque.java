import java.awt.*;
import java.awt.event.*;

public class CanvasDisque extends Canvas {
  
  // ATTRIBUTS
  AppliDisqueAvecCanvas appli;
  
  // CONSTRUCTEURS
  public CanvasDisque(AppliDisqueAvecCanvas appli) {
    super();
    this.appli = appli;
  }
  
  // METHODES
  public void paint (Graphics g) {
    // récupération des dimensions de l'application :
    int w = getSize().width; 
    int h = getSize().height;
    // ### A COMPLETER : 3 ###
    g.setColor(appli.couleurCarre);
    g.fillRect(w/2-appli.rayon, h/2-appli.rayon, 2*appli.rayon, 2*appli.rayon);
    // dessin du disque :
    g.setColor(appli.couleurCercle);
    g.fillOval(w/2-appli.rayon, h/2-appli.rayon, 2*appli.rayon, 2*appli.rayon);
  }
  
}