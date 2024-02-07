package Class;

import java.util.Scanner;

import static Class.GestionErreurs.verificationChaine;
import static Class.Jeu.plateau;

public class Joueur {


    //Les booléens permettant de determiner les actions que le joueur peut faire sur son tour
    boolean peutBouger = true;
    boolean peutDetruire = false;
    //Valeurs qui serviront a differancier les differents joueurs
    public String nom;
    public char tag;
    String numeroJoueur = "";

    public int colonne;
    public int ligne;

    public Joueur(){
        this.nom = ecrirePseudo();
        this.tag = ecrireTag();
    }

    public boolean peutBougerHaut(Jeu jeu){
        char[][] plateau = jeu.plateau;
        if (plateau[this.ligne - 1][this.colonne] != '/'){
            return false;
        } else {
            return true;
        }
    }

    public boolean peutBougerBas(Jeu jeu){
        char[][] plateau = jeu.plateau;
        if (plateau[this.ligne + 1][this.colonne] != '/'){
            return false;
        } else {
            return true;
        }
    }

    public boolean peutBougerDroite(Jeu jeu){
        char[][] plateau = jeu.plateau;
        if (plateau[this.ligne][this.colonne + 1] != '/'){
            return false;
        } else {
            return true;
        }
    }

    public boolean peutBougerGauche(Jeu jeu){
        char[][] plateau = jeu.plateau;
        if (plateau[this.ligne][this.colonne - 1] != '/'){
            return false;
        } else {
            return true;
        }
    }


    public void seDeplacer(Jeu plateau) { // Permet au Joueur de déplacer dans les cases adjacentes

        String direction = "O";
        System.out.println("au tour de " + nom);
        while ( direction == "O" ){
            System.out.println("\nZ : ↑ | Q : ← | S : ↓ | D : →");
            direction = verificationChaine(); // Récupère une chaîne de caractère

            switch (direction){
                case "Z": // Se déplace vers le Haut
                    if (peutBougerHaut(plateau)) {
                        ligne -= 1;
                    } else {
                        System.out.println("Case occupée");
                    }
                    break;
                case "S": // Se déplace vers le Bas
                    if (peutBougerBas(plateau)) {
                        ligne += 1;
                    }
                    break;
                case "Q": // Se déplace vers la gauche
                    colonne -= 1;
                    break;
                case "D": // Se déplace vers la droite
                    colonne += 1;
                    break;
                default: // Exeptions
                    System.out.println("T'as pas bien lu j'crois");
                    direction = "O";
                    break;
            }
        }
    }


    //Les Getter et les Setter

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
    public static String ecrirePseudo(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre pseudo : ");
        String pseudo;
        pseudo = scanner.nextLine(); // Donne a pseudo le texte entré precedemment
        return pseudo;
    }
    // Sers a integrer un tag qui permettera de representer le joueur sur le tableau
    public static char ecrireTag(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez votre Tag! (Le tag sera utilisé pour vous représenté sur le plateau, il contient seulement 1 lettre : ");
        char Tag;
        Tag = scanner.next().charAt(0); //sers a donner a Tag la lettre entrée precedemment
        return Tag;
    }
}

