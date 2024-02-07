package Class;

import java.util.Scanner;

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

    public static String ecrirePseudo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre pseudo : ");
        String pseudo;
        pseudo = scanner.nextLine();

        return pseudo;
    }
    public static char ecrireTag(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez votre Tag! (Le tag sera utilisé pour vous représenté sur le plateau, il contient seulement 1 lettre : ");
        char Tag;
        Tag = scanner.next().charAt(0);
        return Tag;
    }
}

