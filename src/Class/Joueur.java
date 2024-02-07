package Class;

import java.util.Scanner;

public class Joueur {

    //Les booléens permettant de determiner les actions que le joueur peut faire sur son tour
    boolean peutBouger = false;
    boolean peutDetruire = false;
    //Valeurs qui serviront a differancier les differents joueurs
    static String nom = "";
    String numeroJoueur = "";

    public int positionX;
    public int positionY;

    public Joueur(String nom){
        this.nom = nom;
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

