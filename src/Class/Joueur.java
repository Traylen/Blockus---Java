package Class;

import java.util.Scanner;

import static Class.GestionErreurs.verificationChaine;

public class Joueur {

    //Les booléens permettant de determiner les actions que le joueur peut faire sur son tour
    boolean peutBouger = false;
    boolean peutDetruire = false;
    //Valeurs qui serviront a differancier les differents joueurs
    static String nom;
    public char tag;
    String numeroJoueur = "";

    public int positionX;
    public int positionY;

    public Joueur(String nom){
        this.nom = nom;
    }

    public void seDeplacer() { // Permet au Joueur de déplacer dans les cases adjacentes
        String direction = "O";

        while ( direction == "O" ){
            System.out.println("\nZ : ↑ | Q : ← | S : ↓ | D : →");
            direction = verificationChaine(); // Récupère une chaîne de caractère

            switch (direction){
                case "Z": // Se déplace vers le Haut
                    positionY -= 1;
                    break;
                case "S": // Se déplace vers le Bas
                    positionY += 1;
                    break;
                case "Q": // Se déplace vers la gauche
                    positionX -= 1;
                    break;
                case "D": // Se déplace vers la droite
                    positionX += 1;
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
    public void SetNom(String nom) {
        Joueur.nom = nom;
    }

    public String GetNumeroJ() {
        return numeroJoueur;
    }
    public void SetNumeroJ(String numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre pseudo : ");
        String pseudo;
        pseudo = scanner.nextLine();
        Joueur.nom = pseudo;
    }
}

