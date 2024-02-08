package Class;

import java.util.Scanner;
import static Class.GestionErreurs.verificationChaine;
import static Class.GestionErreurs.verificationChar;


public class Joueur {


    /**
     * Bool qui determinent les actions que le joueur peut faire
     */
    boolean peutBouger = true;
    boolean peutDetruire = false;
    /**
     * Sert à diff les joueurs
     */
    public String nom;
    public char tag;
    String numeroJoueur = "";

    public int colonne;
    public int ligne;
    private int score;


    public Joueur(){
        this.nom = ecrirePseudo();
        this.tag = ecrireTag();
    }



    /**
     * Setter
     * Getter
     */

    public boolean isPeutBouger(){
        return peutBouger;
    }
    public void SetPeutBouger(boolean peutBouger){
        this.peutBouger = peutBouger;
    }
    public boolean isPeutDetruire(){
        return peutDetruire;
    }
    public void SetPeutDetruire(boolean peutDetruire){
        this.peutDetruire = peutDetruire;
    }
    public String GetNom() {
        return nom;
    }

    public String GetNumeroJ() {
        return numeroJoueur;
    }
    public void SetNumeroJ(String numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }


    // Permet d'entrer un pseudo qui s'affichera en jeu
    public static String ecrirePseudo() {

        Scanner scanner = new Scanner(System.in);
        String pseudo;
        do {
            System.out.println("Entrez votre pseudo : ");
            pseudo = scanner.nextLine();
            if (pseudo.length() < 2 || pseudo.length() > 10) {
                System.out.println("Votre pseudo doit comporter entre 2 et 10 caractères.");
                pseudo = "0"; // Affectation temporaire pour continuer la boucle
            }
        } while (pseudo.equals("0"));
        return pseudo;
    }

    // Sers a integrer un tag qui permettera de representer le joueur sur le tableau

    public static char ecrireTag(){
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre Tag! (Le tag sera utilisé pour vous représenté sur le plateau, il contient seulement 1 lettre : ");

        char Tag = 'X';
        //Tag = scanner.next().charAt(0); //sers a donner a Tag la lettre entrée precedemment
        while ( Tag == 'X' ) {
            Tag = verificationChar(); 
            if ( Tag >= 'a' && Tag <= 'z' || Tag >= 'A' && Tag <= 'Z' && Tag != 'X'){
                System.out.println("Ton tag est carré");
            } else {
                System.out.println("Ecris une lettre de l'alphabet et arrête de faire l'ancien");
                Tag = 'X';
            }
        }
        return Tag;
    }

    public void ajouterScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return this.score;
    }
}

