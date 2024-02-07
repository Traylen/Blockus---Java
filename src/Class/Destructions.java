package Class;

import java.util.Scanner;

public class Destructions {

    public static void detruire(Plateau P) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez l'indice de la ligne :");
        int ligne = scanner.nextInt()-1;//indice de la ligne - 1

        System.out.println("Entrez l'indice de la colonne :");
        int colonne = scanner.nextInt()-1;//indice de la colonne -1

        if (ligne < 0 || ligne >= P.plateau.length || colonne < 0 || colonne >= P.plateau[ligne].length) {//vérifie que les indices des colonnes et des lignes sont dans le tableau
            System.out.println("Indices de ligne ou de colonne hors limites.");
            return;
        }

        P.plateau[ligne][colonne] = 'X';//mettre X au bonne coordonnées
    }
}
