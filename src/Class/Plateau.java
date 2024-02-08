package Class;

import java.util.Scanner;

import static Class.GestionErreurs.verificationEntier;

public class Plateau {
    public char[][] plateau;

    public Plateau() {
        this.plateau = creerPlateau();
    }



    public char[][] creerPlateau() {
        /**
         * Création du plateau en 12/13
         */
        char[][] plateau = new char[12][13];
        int lignes = plateau.length;
        int colonnes = plateau[0].length;


        for (int i = 0; i < lignes; i++) {
            /**
             * Boucle parcourant les lignes du tableau
             */
            for (int j = 0; j < colonnes; j++) {
                /**
                 * Boucle parcourant les colonnes du tableau
                 */
                if (i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) {
                    /**
                     * Condition vérifiant si on arrive au bord
                     */
                    plateau[i][j] = '/';
                } else {
                    plateau[i][j] = '□';
                }
            }
        }
        return plateau;
    }


    public void afficher() {
        /**
         * Affichage du tableau, parcourant ligne puis colonnes
         */
        System.out.println("");
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (plateau[i][j] != '/') {
                System.out.print(plateau[i][j] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("");
    }

    public int nombreJoueurs() {
        /**
         * Demande le nombre de joueurs et le stock dans une variable 'nbJoueurs'
         * erreur dans le cas où c'est < 2 ou > 4
         */
        System.out.println("Nombre de joueurs : ");
        int nbJoueurs = verificationEntier();
        while (nbJoueurs < 2 || nbJoueurs > 4){
            System.out.println("Vous devez être entre 2 et 4 joueurs : ");
            nbJoueurs = verificationEntier();
        }
        return nbJoueurs;
    }



}

