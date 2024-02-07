package Class;

import java.util.Scanner;

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

    public void seDeplacer() {

        String direction = "O";

        while ( direction == "O" ){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Z : ↑ | Q : ← | S : ↓ | D : →");
            direction = scanner.nextLine();

            switch (direction){
                case "Z":
                    positionY -= 1;
                    break;
                case "S":
                    positionY += 1;
                    break;
                case "Q":
                    positionX -= 1;
                    break;
                case "D":
                    positionX += 1;
                    break;
                default:
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

