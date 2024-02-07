package Class;

import static Class.GestionErreurs.verificationEntier;

public class Interface {

    public static void menu(int i){
        System.out.println(" \nBienvenue dans le Menu");
        System.out.println("\n1 - Lire les règles");
        System.out.println("2 - Jouer au jeu");
        System.out.println("3 - Quitter");
        System.out.println("\nChoisissez une option : ");

        int choix = 0;

        while ( choix == 0 ) {
            choix = verificationEntier();

            switch (choix) {
                case 1:
                    if (i == 10) {
                        System.out.println("ça fait 10 fois que tu lis les règles c'est bon là non ?");
                    }
                    if (i == 100) {
                        System.out.println("Deconnexion en cour, trop de mémoire utilisée, va exploser et tue humains");
                        System.exit(0);
                    }
                    System.out.println("Voici les règles");
                    menu(++i);
                    break;

                case 2:
                    System.out.println("Lancement jeu");
                    break;

                case 3:
                    System.out.println("\n Deconnexion en cours");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ba clément c'est pas un des choix proposés ça");
                    choix = 0;
                    break;
            }
        }
    }
}
