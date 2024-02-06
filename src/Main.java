import java.util.Scanner;
public class Main {

    public static void menu(){
        System.out.println(" \nBienvenue dans le menu");
        System.out.println("\n1 - Lire les règles");
        System.out.println("2 - Jouer au jeu");
        System.out.println("3 - Quitter");
        Scanner choixOption = new Scanner(System.in);
        System.out.println("\nChoisissez une option : ");
        int choix = choixOption.nextInt();
        if (choix == 1) {
            System.out.println("Voici les règles");
            menu();
        }
        if (choix == 2) {
            System.out.println("Lancement jeu");
        }
        if (choix == 3) {
            System.out.println("\n Deconnexion en cours");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        menu();
    }
}