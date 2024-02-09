package Class;

import java.util.ArrayList;
import java.util.Scanner;

import static Class.GestionErreurs.*;
import static Class.Jeu.tousLesJoueurs;


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
    public int score;


    public Joueur(){
        this.nom = ecrirePseudo(tousLesJoueurs);
        this.tag = ecrireTag(tousLesJoueurs);
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
    public static String ecrirePseudo(ArrayList<Joueur> listeJ) { // Fonction pour entrer le pseudo du joueur


        String pseudo = "0"; // valeur initiale
        do {
            System.out.print("Pseudo : ");
            pseudo = verificationChaine(); // Gestion de l'erreur si l'entrée est un string conforme
            if (pseudo.length() < 2 || pseudo.length() > 10) { // Le pseudo doit contenir entre 2 et 10 charactères
                System.out.println("Votre pseudo doit comporter entre 2 et 10 caractères.");
                pseudo = "0"; // Affectation temporaire pour continuer la boucle
            } else if (verificationPseudo(listeJ, pseudo)) {
                System.out.println("Un joueur possède déjà ce pseudo \n");
                pseudo = "0";
            }
        } while (pseudo.equals("0"));
        return pseudo;
    }

    public static boolean garderJoueur(){ // Début de fonction pour demandé au joueur si il veut utilisé un Joueur déjà créer
        String choix = "O";
        boolean garder = false;
        while ( choix.equals("O")) {
            switch ( choix ) {
                case "O": // Il veut le récupérer le joueur déjà créer
                    garder = true;
                    break;
                case "N": // Il veut créer un nouveau joueur
                    garder = false;
                    break;
                default:
                    System.out.println("Entrez O pour Oui et N pour Non");
                    choix = "O";
            }
        }
        return garder;
    }

    // Sers a integrer un tag qui permettera de representer le joueur sur le tableau

    public static char ecrireTag(ArrayList<Joueur> listeJ){ // Fonction pour entrer le tag du joueur
        char Tag = 'X';
        while ( Tag == 'X' ) { // X ne peux est un tag, X représente les case détruite
            System.out.print("Tag (en 1 lettre) : ");
            Tag = verificationChar(); // Gestion des erreurs lors de l'entrée du tag
            if ( Tag >= 'a' && Tag <= 'z' || Tag >= 'A' && Tag <= 'Z' && Tag != 'X'){ // Le tag doit être une lettre de l'alphabet et différent de X
                if ( verificationTag(listeJ, Tag) ){ // Vérifier un joueur occupe déjà le tag
                    System.out.println("Ce tag est déjà pris\n");
                    Tag = 'X';
                }
            } else { // Gestion erreurs si le tag n'est pas une lettre de l'alphabet
                System.out.println("Ecris une lettre de l'alphabet, sauf le X, et arrête de faire l'andouille");
                Tag = 'X';
            }
        }
        return Tag;
    }



    public int getScore() {
        return this.score;
    }
}

