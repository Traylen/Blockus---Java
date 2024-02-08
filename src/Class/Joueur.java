package Class;

import java.util.Scanner;


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

    /**
     * affichage du pseudo en jeu
     */
    public static String ecrirePseudo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre pseudo : ");
        String pseudo;
        pseudo = scanner.nextLine(); // Donne a pseudo le texte entré precedemment
        return pseudo;
    }

    /**
     * Inègre le tag qui servira à reconnaitre le joueur en jeu
     */
    public static char ecrireTag(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre Tag! (Le tag sera utilisé pour vous représenté sur le plateau, il contient seulement 1 lettre : ");
        char Tag;
        Tag = scanner.next().charAt(0);
        return Tag;
    }
}

