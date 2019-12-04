// ----------------------------------------------
//    Algorithmique et programmation en Java
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année
// ----------------------------------------------
//     Exercice sur les structures récursives
// ----------------------------------------------

public class Maillon {
  
  // ATTRIBUTS ////////////////////////////////////////////////

  private double valeur;
  private Maillon suivant;

  // CONSTRUCTEURS ////////////////////////////////////////////

  // Constructeur permettant de créer un Maillon isolé
  public Maillon(double x) {
    valeur = x;
    // Quand on le crée, le Maillon est isolé, donc il n'a pas de "suivant".
    suivant = null; 
  }
  
  // Constructeur par recopie
  public Maillon(Maillon m) {
    valeur = m.renvoyerValeur();
    if (m.renvoyerSuivant() != null) {
      
      suivant = new Maillon(m.renvoyerSuivant());
    }
    else {
      suivant = null;
    }
    
  }
  
  // METHODES /////////////////////////////////////////////////
  
  // Retourne la valeur contenue dans le maillon.  
  // REMARQUE : c'est la seule méthode, avec le constructeur, qui dépend  
  //            du type des éléments stockés contenu des maillons.
  public double renvoyerValeur() {
    return valeur;
  }
   
  // Retourne une référence vers le Maillon suivant de la chaîne.
  public Maillon renvoyerSuivant() {
    return suivant;
  }
  
  // "Chaîne" le Maillon en stockant la référence vers le Maillon suivant
  public void lierAvecSuivant(Maillon leSuivant) {
    suivant = leSuivant;
  }
  
}
