package Class;

public class Jeu {

    public char[][] plateau; // Modification du type à char[][]

    public Jeu() {
        this.plateau = creerPlateau();
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

    public void placerJoueur(Joueur J){

        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau[i].length; j++) {
                if (i == J.positionY && j == J.positionX) {
                    plateau[i][j] = J.tag;
                }
            }
        }
    }

    public void placerJoueur(Joueur J1, Joueur J2){

        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau[i].length; j++) {
                if (i == J1.positionY && j == J1.positionX) {
                    plateau[i][j] = 'Y';
                }
                if (i == J2.positionY && j == J2.positionX) {
                    plateau[i][j] = 'N';
                }
            }
        }
    }

    public void placerJoueur(Joueur J1, Joueur J2, Joueur J3){

        for(int i = 0; i < plateau.length; i++) {
            for(int j = 0; j < plateau[i].length; j++) {
                if (i == J1.positionY && j == J1.positionX) {
                    plateau[i][j] = 'Y';
                }
                if (i == J2.positionY && j == J2.positionX) {
                    plateau[i][j] = 'N';
                }
                if (i == J3.positionY && j == J3.positionX) {
                    plateau[i][j] = 'N';
                }
            }
        }
    }

    // Fonction principale pour tester la fonction creerTableau
    public static void main(String[] args) {
        Jeu jeu = new Jeu();

        // Afficher le tableau
        jeu.afficher();
    }
}

