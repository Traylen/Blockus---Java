package Class;

class Plateau {

    // Fonction pour créer le tableau
    public static int[][] creerTableau() {
        int lignes = 12; // Nombre de lignes
        int colonnes = 13; // Nombre de colonnes
        int[][] tableau = new int[lignes][colonnes];

        // Boucle pour parcourir les lignes du tableau
        for(int i = 0; i < lignes; i++) {
            // Boucle pour parcourir les colonnes du tableau
            for(int j = 0; j < colonnes; j++) {
                // Condition pour vérifier si on est sur un bord
                if(i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) {
                    tableau[i][j] = 1;
                } else {
                    tableau[i][j] = 0;
                }
            }
        }

        return tableau;
    }

    // Fonction principale pour tester la fonction creerTableau
    public static void main(String[] args) {
        int[][] tableau = creerTableau();

        // Afficher le tableau
        for(int i = 0; i < tableau.length; i++) {
            for(int j = 0; j < tableau[i].length; j++) {
                System.out.print(tableau[i][j] + " ");
            }
            System.out.println();
        }
    }
}
