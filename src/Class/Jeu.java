package Class;

public class Jeu {

    public int[][] plateau = new int[12][13]; //

    public Jeu() { // Constructeur
        this.plateau = creerPlateau();
    }

    public int[][] creerPlateau() { // Fonction pour créer le tableau
        int[][] plateau = new int[12][13];
        int lignes = plateau.length;
        int colonnes = plateau[0].length;

        for(int i = 0; i < lignes; i++) { // Boucle pour parcourir les lignes du tableau
            for(int j = 0; j < colonnes; j++) { // Boucle pour parcourir les colonnes du tableau
                if(i == 0 || i == lignes - 1 || j == 0 || j == colonnes - 1) { // Condition pour vérifier si on est sur un bord
                    plateau[i][j] = 1;
                } else {
                    plateau[i][j] = 0;
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

    // Fonction principale pour tester la fonction creerTableau
    public static void main(String[] args) {
        Jeu plateau = new Jeu();

        // Afficher le tableau
        plateau.afficher();
    }
}

