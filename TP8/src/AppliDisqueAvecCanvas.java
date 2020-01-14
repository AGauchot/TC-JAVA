import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class AppliDisqueAvecCanvas extends Frame implements ActionListener, ItemListener {
  
  // DECLARATION DES ATTRIBUTS :
  int rayon;
  Color couleurCercle;
  private int compteur;
  private Button augmenterRayon;
  private Label affichageCompteur;
  // ## A COMPLETER : 2 ##
  private Button diminuerRayon;

  // #### A COMPLETER : 4 ####
  Color couleurCarre;
  List lstCouleurCarre;

  // ##### A COMPLETER : 5 #####
  private Choice choixCouleurFond;
  
  // CANVAS
  private CanvasDisque canvas;

  // CONSTRUCTEUR :
  public AppliDisqueAvecCanvas() {   
    // invocation du constructeur de la classe mère :
    super("AppliDisque");   // paramètre = titre de la fenêtre
    // initialisation des attributs :
    rayon = 15;
    couleurCercle = Color.green;
    compteur = 0;
    // #### A COMPLETER : 4 ####

    // creation des composants (boutons, labels, ...) :
    augmenterRayon = new Button("Augmenter rayon");
    affichageCompteur = new Label("Compteur=     ");
    // ## A COMPLETER : 2 ##
    diminuerRayon = new Button("Diminuer Rayon");
    // #### A COMPLETER : 4 ####
    couleurCarre = Color.black;
    lstCouleurCarre = new List();
    lstCouleurCarre.add(" Noir ");
    lstCouleurCarre.add(" Jaune ");
    lstCouleurCarre.add(" Cyan ");
    lstCouleurCarre.add(" Magenta ");

    // ##### A COMPLETER : 5 #####
    choixCouleurFond = new Choice();
    choixCouleurFond.add("Blanc");
    choixCouleurFond.add("Rose");
    choixCouleurFond.add("Gris");

    // CANVAS
    canvas = new CanvasDisque(this);
    canvas.setSize(500,300);
    // choix du gestionnaire de présentation "Flow" pour la Frame
    //    (par défaut, le gestionnaire pour une Frame est "BorderLayout") :
    setLayout(new FlowLayout());   
    // ajout des composants dans l'application :
    add(augmenterRayon);
    add(affichageCompteur);
    // ## A COMPLETER : 2 ##
    add(diminuerRayon);
    // #### A COMPLETER : 4 ####
    add(lstCouleurCarre);
    // ##### A COMPLETER : 5 #####
    add(choixCouleurFond);
    add(canvas);
    canvas.setVisible(true);

    // enregistrement de l'application elle-meme comme ecouteur des événements de type Action :
    augmenterRayon.addActionListener(this);
    // ## A COMPLETER : 2 ##
    diminuerRayon.addActionListener(this);
    // #### A COMPLETER : 4 ####
    lstCouleurCarre.addActionListener(this);
    // ##### A COMPLETER : 5 #####
    choixCouleurFond.addItemListener(this);
    
    // écoute des evts de type "fenetre" via une classe dédiée (pour quitter en cas de fermeture) :
    addWindowListener(new EcouteurPourFermetureFenetre());  
  }
      
  // RAPPEL : la méthode paint() est appelée :
  //   a) AUTOMATIQUEMENT, chaque fois que Java estime nécessaire de dessiner ou redessiner 
  //      le contenu du composant graphique (ici la Frame de l'application) ;
  //   b) ou bien quand un "repaint()" a été explicitement demandé par le programmeur.
  // C'est donc ici qu'il faut mettre les opérations graphiques permettant de dessiner (et redessiner
  // à nouveau éventuellement) le composant via des opérations de type drawXXXX() ou fillXXXX().
  public void paint(Graphics g)  {
    // récupération des dimensions de l'application :
    int w = getSize().width; 
    int h = getSize().height;
    // ### A COMPLETER : 3 ###
    g.setColor(couleurCarre);
    g.fillRect(w/2-rayon, h/2-rayon, 2*rayon, 2*rayon);
    // dessin du disque :
    g.setColor(couleurCercle);
    g.fillOval(w/2-rayon, h/2-rayon, 2*rayon, 2*rayon);
  }

  // Méthode invoquée pour les événements de type "action" : 
  public void actionPerformed(ActionEvent evt) {
    if (evt.getSource()==augmenterRayon) {
      rayon += 2;  // modification du rayon
      compteur++;  // comptage du nb. de clics sur le bouton
      // modification du label correspondant :
      affichageCompteur.setText("Compteur=" + compteur);
      // # A COMPLETER : 1 #
      if (rayon > 40) {
        couleurCercle = Color.red;
      }
      else if (rayon>20) {
        couleurCercle = Color.blue;
      }
    }
    
    // ## A COMPLETER : 2 ##
    else if (evt.getSource()==diminuerRayon) {
      rayon -= 2;  // modification du rayon
      compteur--;  // comptage du nb. de clics sur le bouton
      // modification du label correspondant :
      affichageCompteur.setText("Compteur=" + compteur);
      if (rayon <= 20) {
        couleurCercle = Color.green;
      }
      else if (rayon<=40) {
        couleurCercle = Color.blue;
      }
    }
    
    // #### A COMPLETER : 4 ####
    else if (evt.getSource()==lstCouleurCarre) {
      switch (lstCouleurCarre.getSelectedItem()) {
      case (" Noir "):
        couleurCarre = Color.black;
      break;
      case (" Jaune "):
        couleurCarre = Color.yellow;
      break;
      case (" Cyan "):
        couleurCarre = Color.cyan;
      break;
      case (" Magenta "):
        couleurCarre = Color.magenta;
      break;
      }
    }
    
    // demande une mise a jour de l'affichage dans tous les cas :
    canvas.repaint();
    this.repaint();
  }

  // ##### A COMPLETER :  5 #####
  public void itemStateChanged (ItemEvent evt) {
    if (evt.getSource()==choixCouleurFond) {
      switch (choixCouleurFond.getSelectedItem()) {
      case ("Blanc"):
        this.setBackground(Color.white);
      break;
      case ("Rose"):
        this.setBackground(Color.pink);
      break;
      case ("Gris"):
        this.setBackground(Color.gray);
      break;
      }
    }
    repaint();
  }
  
  // MAIN :
  public static void main(String[] args) {
    AppliDisqueAvecCanvas appli = new AppliDisqueAvecCanvas();
    appli.setLocation(100, 100);
    appli.setSize(600, 450);
    appli.setVisible(true);
  }

}