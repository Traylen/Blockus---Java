import java.util.InputMismatchException;
import java.util.Scanner;

public class menu {
    public static int verificationEntier(){

        /** Cette fonction permet à l'utilisateur d'entrer un entier
         *  Elle permet de gérer les cas ou la valeur entrer ne correspond
         *  pas à un entier
         **/
        boolean valeurValide = false;
        int valeur = 0;

        while (!valeurValide || valeur == 0) {
            try {
                Scanner scanner = new Scanner(System.in);
                valeur = scanner.nextInt();

                if (valeur != 0) {
                    valeurValide = true;
                }

                // Ajoutez ici la logique pour vérifier si 'valeur' est valide
                // et affectez true à 'valeurValide' si c'est le cas

            } catch (InputMismatchException e) { // Si la valeur n'est pas un entier
                System.out.println("Veuillez entrer un chiffre (Qu'est ce que tu dis de ça Clément)");
            } catch (Exception e) { // Si il y a une autre erreur quelconque
                System.out.println("Veuillez entrer un chiffre (Pas à moi Clément)");
            }
        }

        return valeur;

    }

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
    public static void main(String[] args) {
        int i = 0;
        menu(i);
    }
}
