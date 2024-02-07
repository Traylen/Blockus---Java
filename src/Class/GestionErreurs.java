package Class;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionErreurs {

    public static int verificationEntier(){

        /**
         * Cette fonction permet à l'utilisateur d'entrer un entier
         *  Elle permet de gérer les cas ou la valeur entrer ne correspond pas à un entier
         **/

        int valeur = 0;

        while (valeur == 0) {
            try {
                Scanner scanner = new Scanner(System.in);
                valeur = scanner.nextInt();
                if (valeur == 0){
                    System.out.println("Pas 0 chef !");
                }

            } catch (InputMismatchException e) { // Si la valeur n'est pas un entier
                System.out.println("Veuillez entrer un chiffre (Qu'est ce que tu dis de ça Clément)");
            } catch (Exception e) { // Si il y a une autre erreur quelconque
                System.out.println("Veuillez entrer un chiffre (Pas à moi Clément)");
            }
        }

        return valeur;

    }

    public static String verificationChaine(){

        /**
         * Cette fonction permet à l'utilisateur d'entrer une chaîne de charactère
         *  Elle permet de gérer les cas ou la valeur entrer ne correspond pas à une chaîne de caractère
         **/

        String valeur = "O";

        while (valeur == "O") {
            try {
                Scanner scanner = new Scanner(System.in);
                valeur = scanner.nextLine();

            } catch (InputMismatchException e) { // Si la valeur n'est pas un entier
                System.out.println("Veuillez entrer une chaîne de charactère (Oui Clément, on a tout prévu)");
            } catch (Exception e) { // Si il y a une autre erreur quelconque
                System.out.println("Veuillez entrer une chaîne de charactère (Bien essayé )");
            }
        }

        return valeur;

    }
}
