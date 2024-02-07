package Class;

import java.util.Scanner;

import static Class.GestionErreurs.verificationEntier;

public class Jeu {
    public static char[][] plateau; // Modification du type à char[][]

    public Jeu() {
        this.plateau = creerPlateau();
    }

    public static void detruire(char[][] tableau) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Entrez l'indice de la ligne :");
        int ligne = scanner.nextInt()-1;//indice de la ligne - 1

        System.out.println("Entrez l'indice de la colonne :");
        int colonne = scanner.nextInt()-1;//indice de la colonne -1

        if (ligne < 0 || ligne >= tableau.length || colonne < 0 || colonne >= tableau[ligne].length) {//vérifie que les indices des colonnes et des lignes sont dans le tableau
            System.out.println("Indices de ligne ou de colonne hors limites.");
            return;
        }

        tableau[ligne][colonne] = 'X';//mettre X aux bonnes coordonnées
    }

    public char[][] creerPlateau() { // Fonction pour créer le tableau
        char[][] plateau = new char[12][13];
        int lignes = plateau.length;
        int colonnes = plateau[0].length;

        for (int i = 0; i < lignes; i++) { // Boucle pour parcourir les lignes du tableau
            for (int j = 0; j < colonnes; j++) { // Boucle pour parcourir les colonnes du tableau
                if (i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) { // Condition pour vérifier si on est sur un bord
                    plateau[i][j] = '1';
                } else {
                    plateau[i][j] = '/';
                }
            }
        }
        return plateau;
    }

    public void afficher() { // Affiche le tableau
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                System.out.print(plateau[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public int nombreJoueurs() {
        /**
         * Demande le nombre de joueurs et le stock dans une variable 'nbJoueurs'
         * erreur dansle cas où c'est < 2 ou > 4
         */
        System.out.println("Nombre de joueurs : ");
        int nbJoueurs = verificationEntier();
        while (nbJoueurs < 2 || nbJoueurs > 4){
            System.out.println("Vous devez être entre 2 et 4 joueurs : ");
            nbJoueurs = verificationEntier();
        }
        return nbJoueurs;
    }


    public static void positionDeDepart(Joueur J1, Joueur J2) {
        /**
         * Position pour 2 joueurs
         */
        J1.colonne = 6;
        J1.ligne = 5;


        J2.colonne = 6;
        J2.ligne = 6;
    }

    public static void positionDeDepart(Joueur J1, Joueur J2, Joueur J3) {
        /**
         * Position pour 3 joueurs
         */
        J1.colonne = 5;
        J1.ligne = 5;

        J2.colonne = 7;
        J2.ligne = 5;

        J3.colonne = 6;
        J3.ligne = 6;
    }

    public static void positionDeDepart(Joueur J1, Joueur J2, Joueur J3, Joueur J4) {
        /**
         * Position pour 4 joueurs
         */
        J1.colonne = 5;
        J1.ligne = 5;

        J2.colonne = 7;
        J2.ligne = 5;

        J3.colonne = 5;
        J3.ligne = 6;

        J4.colonne = 7;
        J4.ligne = 6;

    }

    public void placerJoueur (Joueur J){
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (i == J.ligne && j == J.colonne) {
                    plateau[i][j] = J.tag;
                }
            }
        }
    }

    public void placerJoueur (Joueur J1, Joueur J2){
        /**
         * Place les joueurs s'ils sont 2
         */
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (i == J1.ligne && j == J1.colonne) {
                    plateau[i][j] = J1.tag;
                }
                if (i == J2.ligne && j == J2.colonne) {
                    plateau[i][j] = J2.tag;
                }
            }
        }
    }
    public void placerJoueur (Joueur J1, Joueur J2, Joueur J3){
        /**
         * Place les joueurs s'ils sont 3
         */
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (i == J1.ligne && j == J1.colonne) {
                    plateau[i][j] = J1.tag;
                }
                if (i == J2.ligne && j == J2.colonne) {
                    plateau[i][j] = J2.tag;
                }
                if (i == J3.ligne && j == J3.colonne) {
                    plateau[i][j] = J3.tag;
                }
            }
        }
    }

    public void placerJoueur (Joueur J1, Joueur J2, Joueur J3, Joueur J4){
        /**
         * Place les joueurs s'ils sont 4
         */
        for (int i = 0; i < plateau.length; i++) {
            for (int j = 0; j < plateau[i].length; j++) {
                if (i == J1.ligne && j == J1.colonne) {
                    plateau[i][j] = J1.tag;
                }
                if (i == J2.ligne && j == J2.colonne) {
                    plateau[i][j] = J2.tag;
                }
                if (i == J3.ligne && j == J3.colonne) {
                    plateau[i][j] = J3.tag;
                }
                if (i == J4.ligne && j == J4.colonne) {
                    plateau[i][j] = J4.tag;
                }
            }
        }
    }

    // Fonction principale pour tester la fonction creerTableau
    public static void main (String[] args){
        Jeu jeu = new Jeu();

        // Afficher le tableau
        jeu.afficher();
    }
}

