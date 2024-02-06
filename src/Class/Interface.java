package Class;

import static Class.GestionErreurs.verificationEntier;

public class Interface {

    public static void menu(int i){
        System.out.println(" \nBienvenue dans le menu");
        System.out.println("\n1 - Lire les règles");
        System.out.println("2 - Jouer au jeu");
        System.out.println("3 - Quitter");
        System.out.println("\nChoisissez une option : ");
        int choix = verificationEntier();
        if (choix<1 || choix>3) {
            System.out.println("Ba clément c'est pas un des choix proposés ça");
            choix = verificationEntier();
        }
        if (choix == 1) {
            if (i == 10) {
                System.out.println("ça fait 10 fois que tu lis les règles c'est bon là non ?");
            }
            System.out.println("Voici les règles");
            menu(++i);
        }
        else if (choix == 2) {
            System.out.println("Lancement jeu");
        }
        else if (choix == 3) {
            System.out.println("\n Deconnexion en cours");
            System.exit(0);
        }
    }
}
