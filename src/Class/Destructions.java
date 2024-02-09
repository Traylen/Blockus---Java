package Class;

import java.util.Scanner;

import static Class.GestionErreurs.verificationCase;
import static Class.GestionErreurs.verificationEntier;

public class Destructions {

    public static void detruire(Plateau P) {
        System.out.println("Choisissez une case à détruire");

        boolean caseVide = false;
        int ligne = 0;
        int colonne = 0;

        while ( !caseVide ){
            /**
             * récupération de la ligne et colonne entrée par le joueur
             */
            ligne = choixCase(P, "ligne");

            colonne = choixCase(P, "colonne");

            caseVide = verificationCase(P.plateau, ligne, colonne);

        }
        /**
         * Mettre un "X" sur la case détruite
         */
        P.plateau[ligne][colonne] = 'X';
    }

    public static int choixCase(Plateau P, String axe){
        int choix = 0;
        int nbLignes = P.plateau.length-2;
        int nbColonnes = P.plateau[0].length-2;

        while ( choix < 1 ) {
            /**
             * Gestion des erreurs, si le joueur essaie de détruire une case out of range, lignes puis colonnes
             */
            System.out.println("Entrez l'indice de la " + axe + " : ");
            choix = verificationEntier();
            switch (axe){
                case "ligne":
                    if (choix > nbLignes) {
                        System.out.println("Frero y'a que " + nbLignes + " lignes");
                        choix = 0;
                    }
                    break;
                case "colonne":
                    if (choix > nbColonnes) {
                        System.out.println("Frero y'a que " + nbColonnes + " colonnes");
                        choix = 0;
                    }
                    break;
            }
        }
        return choix;
    }
}
