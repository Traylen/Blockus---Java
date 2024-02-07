package Class;

import java.util.Scanner;

import static Class.GestionErreurs.verificationChaine;

public class Joueur {

    //Les booléens permettant de determiner les actions que le joueur peut faire sur son tour
    boolean peutBouger = true;
    boolean peutDetruire = false;
    //Valeurs qui serviront a differancier les differents joueurs
    public String nom;
    public char tag;
    String numeroJoueur = "";

    public int positionX;
    public int positionY;

    public Joueur(){
        this.nom = ecrirePseudo();
        this.tag = ecrireTag();
    }

    public void seDeplacer() { // Permet au Joueur de déplacer dans les cases adjacentes
        String direction = "O";
        System.out.println("au tour de " + nom);
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

