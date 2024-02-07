package Class;

import java.util.Scanner;

public class Jeu {

    public char[][] plateau; // Modification du type à char[][]

    public Jeu() {
        this.plateau = creerPlateau();
    }
    public static void detruire(char[][] tableau) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez l'indice de la ligne :");
        int ligne = scanner.nextInt()-1;

        System.out.println("Entrez l'indice de la colonne :");
        int colonne = scanner.nextInt()-1;

        if (ligne < 0 || ligne >= tableau.length || colonne < 0 || colonne >= tableau[ligne].length) {
            System.out.println("Indices de ligne ou de colonne hors limites.");
            return;
        }

        tableau[ligne][colonne] = 'X';
    }

    public char[][] creerPlateau() { // Fonction pour créer le tableau
        char[][] plateau = new char[12][13];
        int lignes = plateau.length;
        int colonnes = plateau[0].length;

        for(int i = 0; i < lignes; i++) { // Boucle pour parcourir les lignes du tableau
            for(int j = 0; j < colonnes; j++) { // Boucle pour parcourir les colonnes du tableau
                if(i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) { // Condition pour vérifier si on est sur un bord
                    plateau[i][j] = '1';
                } else {
                    plateau[i][j] = '/';
                }
            }
        }
        return plateau;
    }

    public void afficher(){ // Affiche le tableau
        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau[i].length; j++) {
                System.out.print(plateau[i][j] + "  ");
            }
            System.out.println();
        }
    }


    // Fonction principale pour tester la classe
    public static void main(String[] args) {
        Jeu jeu = new Jeu();

        // Afficher le tableau
        jeu.afficher();
    }
}
