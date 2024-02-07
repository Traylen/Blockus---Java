package Class;

import java.util.Scanner;

public class Jeu {

    public char[][] plateau; // Modification du type à char[][]
    public  int nbjoueur;
    boolean victoire = false;

    public Jeu() {
        this.plateau = creerPlateau();
    }
    //fonction pour detruire une case
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

        tableau[ligne][colonne] = 'X';//mettre X au bonne coordonnées
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

    // Définition d'une méthode publique qui ne retourne rien, destinée à afficher un tableau
    public void afficher() {
        // Parcourt chaque ligne du tableau 'plateau'.
        for (int i = 0; i < plateau.length; i++) {
            // Parcourt chaque colonne de la ligne courante.
            for (int j = 0; j < plateau[i].length; j++) {
                // Affiche l'élément actuel du tableau suivi de deux espaces,
                System.out.print(plateau[i][j] + "  ");
            }
            //affiche le tableau
            System.out.println();
        }
    }


    public void positionDeDepart(Joueur J1, Joueur J2) {
        J1.positionX = 6;
        J1.positionY = 5;

        J2.positionX = 6;
        J2.positionY = 6;
    }

    public void positionDeDepart(Joueur J1, Joueur J2, Joueur J3) {
        J1.positionX = 5;
        J1.positionY = 5;

        J2.positionX = 7;
        J2.positionY = 5;

        J3.positionX = 6;
        J3.positionY = 6;
    }

    public void positionDeDepart(Joueur J1, Joueur J2, Joueur J3, Joueur J4) {
        J1.positionX = 5;
        J1.positionY = 5;

        J2.positionX = 7;
        J2.positionY = 5;

        J3.positionX = 5;
        J3.positionY = 6;

        J4.positionX = 7;
        J4.positionY = 6;

    }

    // Définition d'une méthode destinée à placer un objet Joueur sur un plateau de jeu.
    public void placerJoueur (Joueur J){
        // Parcourt chaque ligne du tableau 'plateau'.
        for (int i = 0; i < plateau.length; i++) {
            // Parcourt chaque colonne de la ligne courante.
            for (int j = 0; j < plateau[i].length; j++) {
                // Vérifie si les indices de la boucle correspondent à la position du joueur.
                if (i == J.positionY && j == J.positionX) {
                    // Si la condition est vraie, place le 'tag' du joueur à la position courante sur le plateau.
                    plateau[i][j] = J.tag;
                }
            }
        }
    }


    // Définition d'une méthode  destinée à placer deux objets Joueur, J1 et J2, sur un plateau de jeu.
    public void placerJoueur (Joueur J1, Joueur J2){
        // Parcourt chaque ligne du tableau 'plateau'.
        for (int i = 0; i < plateau.length; i++) {
            // Parcourt chaque colonne de la ligne courante.
            for (int j = 0; j < plateau[i].length; j++) {
                // Vérifie si les indices de la boucle correspondent à la position du premier joueur, J1.
                if (i == J1.positionY && j == J1.positionX) {
                    // Si la condition est vraie, marque la position de J1 sur le plateau avec 'Y'.
                    plateau[i][j] = 'Y';
                }
                // Vérifie si les indices de la boucle correspondent à la position du deuxième joueur, J2.
                if (i == J2.positionY && j == J2.positionX) {
                    // Si la condition est vraie, marque la position de J2 sur le plateau avec 'N'.
                    plateau[i][j] = 'N';
                }
            }
        }
    }
        //Pareil que avant mais pour 3 joueurs
    public void placerJoueur (Joueur J1, Joueur J2, Joueur J3){

            for (int i = 0; i < plateau.length; i++) {
                for (int j = 0; j < plateau[i].length; j++) {
                    if (i == J1.positionY && j == J1.positionX) {
                        plateau[i][j] = 'Y';
                    }
                    if (i == J2.positionY && j == J2.positionX) {
                        plateau[i][j] = 'N';
                    }
                    if (i == J3.positionY && j == J3.positionX) {
                        plateau[i][j] = 'D';
                    }
                }
            }
        }
    //Pareil que avant mais pour 4 joueurs

    public void placerJoueur (Joueur J1, Joueur J2, Joueur J3, Joueur J4){

            for (int i = 0; i < plateau.length; i++) {
                for (int j = 0; j < plateau[i].length; j++) {
                    if (i == J1.positionY && j == J1.positionX) {
                        plateau[i][j] = 'Y';
                    }
                    if (i == J2.positionY && j == J2.positionX) {
                        plateau[i][j] = 'N';
                    }
                    if (i == J3.positionY && j == J3.positionX) {
                        plateau[i][j] = 'D';
                    }
                    if (i == J4.positionY && j == J4.positionX) {
                        plateau[i][j] = 'A';
                    }
                }
            }
        }
        //création d'une fonction de victoire
    public boolean victoire() {
        if (nbjoueur == 1) {//conditions de victoire
            return true;
        } else {
            return false;
        }
    }


    // Fonction principale pour tester la fonction creerTableau
        public static void main (String[] args){
            Jeu jeu = new Jeu();

            // Afficher le tableau
            jeu.afficher();
        }
}

