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

    public void afficher() { // Affiche le tableau de manière présentable, claire et beau
        System.out.println(""); // Saut de ligne au début

        System.out.println("╭────────────────────────────────────────╮"); // Bordure supérieure

        for (int i = 0; i < plateau.length; i++) { // Itération sur toute les lignes du plateau
            if ( i == 1) {
                System.out.print("\n│      " + "――――――――――――――――――――――――――――――――― │" ); // Ajout de la barre qui sépare le plateau et la les indices des colonnes
            }
            if (i > 0 && i < plateau.length - 1){ // Si i correspond à une ligne du tableau
                if (i >= 10) {
                    System.out.print("\n│ " + i + " │  "); //Ajout de l'indice de la ligne et la barre qui les sépare du plateau
                } else {
                    System.out.print("\n│ " + i + "  │  "); // //Ajout de l'indice de la ligne et la barre qui les sépare du plateau
                    // Ajout d'un espace pour équilibré avec les indice à 2 chiffres
                }
            }

            for (int j = 0; j < plateau[i].length; j++) {  // Itération sur toute les colonnes du plateau
                if ( i == 0) { // Afficher uniquement sur la première ligne
                    if ( j > 0 && j < plateau[i].length-1)
                        if ( j == 1 ) {
                            System.out.print("│       " + j + " "); // Ajout de l'indice de la 1ère colone
                        } else if ( j == 10) {
                            System.out.print(" " + j ); // Ajout de l'indice des colonnes à un chiffre
                        } else if ( j == 11) {
                            System.out.print(" " + j + " " ); // Ajout de l'indice des colonnes à un chiffre
                        } else {
                            System.out.print(" " + j + " "); // Ajout de l'indice des colonnes à deux chiffres
                        }
                }
                if (plateau[i][j] != '/') { // Cacher les bordures du plateau
                    System.out.print(plateau[i][j] + "  "); // Affichage des cases séparé par des espaces
                }
            }
            System.out.print("│");
        }

        System.out.println("\n╰────────────────────────────────────────╯"); // Bordure inférieure
        System.out.println(""); // Saut de ligne à la fin
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

