// ----------------------------------------------
//    Algorithmique et programmation en Java     
// Ecole Nationale Supérieure des Mines de PARIS
//      Cours d'informatique -  1ère année 
// ----------------------------------------------
// Ecriture de fichiers "en clair" (ASCII) ou binaire
// ----------------------------------------------
 
import java.io.*;  // Pour les entrées-sorties (flux, fichiers, etc.)
import java.util.Scanner;     // pour les saisies

public class FichierTexteEtBinaire {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);  // pour les saisies
    System.out.println("Longueur du tableau (par exemple 1000) ?");
    int n = sc.nextInt();
    int [] tab = new int[n];     // CREATION D'UN TABLEAU DE n ENTIERS
    for (int i=0 ; i<tab.length ; i++) {
      tab[i] = 1000000000+i*10000+i;
    }
      
    // SAUVEGARDE SUR FICHIERS SOUS 3 FORMATS DIFFERENTS
    PrintWriter textOut = null;
    DataOutputStream binOut = null;
    ObjectOutputStream objOut = null;
    try {
      // Ouverture du fichier tableau.txt en mode écriture de caractères 
      textOut = new PrintWriter(new FileWriter("tableau.txt"));
      // Ecriture de la dimension
      textOut.println(tab.length);
      // Ecriture du tableau en mode texte (un élément par ligne) 
      for (int x : tab) {
        textOut.println(x);
      }

      // Ouverture du fichier tableau.dat1 en mode écriture d'octets, 
      //  puis création et branchement dessus d'un flux de données 
      binOut = new DataOutputStream(new FileOutputStream("tableau.dat1"));
      
      // Ecriture de la longueur, puis des éléments du tableau
      binOut.writeInt(tab.length);
      for (int x : tab) {
        binOut.writeInt(x);
      }
        
      // Ouverture du fichier tableau.dat2 en mode écriture d'octets,
      //  puis création et branchement dessus d'un flux d'objets 
      objOut = new ObjectOutputStream(new FileOutputStream("tableau.dat2"));
      // Ecriture du tableau
      objOut.writeObject(tab);
    }
    // GESTION DES ANOMALIES
    catch(IOException e) {
      // Typiquement, on n'a pas pu ouvrir le fichier choisi par l'utilisateur
      System.err.println("### MESSAGE D'ERREUR : " + e.getMessage());
      System.err.println("### AFFICHAGE DE LA PILE D'APPEL : ");
      e.printStackTrace();
    }
    
    // DANS TOUS LES CAS, PENSER A FERMER LES FICHIERS, S'ILS SONT OUVERTS 
    try {
      if (textOut!=null) textOut.close();
      if (binOut!=null) binOut.close();
      if (objOut!=null) objOut.close();
    }
    catch(IOException e) {
      System.err.println("Problème à la fermeture :" + e);
    }
    
    try {
      int[] tableau = lireTableau();  // !!! RENVOIE N'IMPORTE QUOI !!!
      affichage(tableau);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    
  } //fin du main
  
  
  public static int[] lireTableau () throws IOException {    //renvoie le tableau lu dans tableau.txt
    int[] tab;
    FileReader textIn = new FileReader ("tableau.txt");
    int val;  //doit prendre successivemnt les valeurs des entiers du fichier tableau.txt
    int taille = textIn.read(); //taille du tableau
    tab = new int[taille];
    int index=0;
    while ( index<taille ) {
      val = textIn.read();
      tab[index]=val;
      index++;
    }
    textIn.close();
    return tab;
  }
  
  public static void affichage (int[] tab) { //affiche les valeurs d'un tableau
    System.out.println("AFFICHAGE DU TABLEAU");
    for (int i=0; i<tab.length; i++) {
      System.out.println(tab[i]);
    }
  }
  
}