import java.awt.*;
import java.awt.event.*;

public class ClavierTelephone extends Frame {
  
  // ATTRIBUTS
  private String numeroTelephone;
  private Button b0;
  private Button b1;
  private Button b2;
  private Button b3;
  private Button b4;
  private Button b5;
  private Button b6;
  private Button b7;
  private Button b8;
  private Button b9;
  private Button b_etoile;
  private Button b_diese;
  private Button composer;
  private Button effacer;

  // CONSTRUCTEUR
  public ClavierTelephone() {
    numeroTelephone = "";
    b0 = new Button("0");
    b1 = new Button("0");
    b2 = new Button("0");
    b3 = new Button("0");
    b4 = new Button("0");
    b5 = new Button("0");
    b6 = new Button("0");
    b7 = new Button("0");
    b8 = new Button("0");
    b9 = new Button("0");
    b_etoile = new Button("*");
    b_diese = new Button("#");
    composer = new Button("Composer");
    effacer = new Button("effacer");
    
    setLayout(new GridLayout());
  }
  
  // METHODES
  
  
  
  // MAIN
  public static void main(String[] args) {
    
  }
  
}