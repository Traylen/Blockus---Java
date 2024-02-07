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

            } catch (InputMismatchException e) { // Si la valeur n'est pas un entier
                System.out.println("Veuillez entrer un chiffre (Qu'est ce que tu dis de ça Clément)");
            } catch (Exception e) { // Si il y a une autre erreur quelconque
                System.out.println("Veuillez entrer un chiffre (Pas à moi Clément)");
            }
        }

        return valeur;

    }
}
