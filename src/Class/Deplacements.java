package Class;

import java.util.ArrayList;

import static Class.GestionErreurs.verificationChaine;

public class Deplacements {


    public static void caseDeDepart(ArrayList<Joueur> joueurs) {
        int nombreJoueurs = joueurs.size();

        switch (nombreJoueurs) {
            case 2:
                joueurs.get(0).colonne = 6;
                joueurs.get(0).ligne = 5;
                joueurs.get(1).colonne = 6;
                joueurs.get(1).ligne = 6;
                break;
            case 3:
                joueurs.get(0).colonne = 5;
                joueurs.get(0).ligne = 5;
                joueurs.get(1).colonne = 7;
                joueurs.get(1).ligne = 5;
                joueurs.get(2).colonne = 6;
                joueurs.get(2).ligne = 6;
                break;
            case 4:
                joueurs.get(0).colonne = 5;
                joueurs.get(0).ligne = 5;
                joueurs.get(1).colonne = 7;
                joueurs.get(1).ligne = 5;
                joueurs.get(2).colonne = 5;
                joueurs.get(2).ligne = 6;
                joueurs.get(3).colonne = 7;
                joueurs.get(3).ligne = 6;
                break;
            default:
                // Gérer d'autres cas si nécessaire
                break;
        }
    }

    public static void placer(Joueur J, Plateau P) {
        int colonne = J.colonne;
        int ligne = J.ligne;

        P.plateau[ligne][colonne] = J.tag;
    }

    public static void deplacer(Joueur J) { // Permet au Joueur de déplacer dans les cases adjacentes
        String direction = "O";
        System.out.println("au tour de " + J.nom);
        while ( direction == "O" ){
            System.out.println("\nZ : ↑ | Q : ← | S : ↓ | D : →");
            direction = verificationChaine(); // Récupère une chaîne de caractère

            switch (direction){
                case "Z": // Se déplace vers le Haut
                    J.ligne -= 1;
                    break;
                case "S": // Se déplace vers le Bas
                    J.ligne += 1;
                    break;
                case "Q": // Se déplace vers la gauche
                    J.colonne -= 1;
                    break;
                case "D": // Se déplace vers la droite
                    J.colonne += 1;
                    break;
                default: // Exeptions
                    System.out.println("T'as pas bien lu j'crois");
                    direction = "O";
                    break;
            }
        }
    }



    public static void placerJoueur (Joueur J, Plateau P){
        for (int i = 0; i < P.plateau.length; i++) {
            for (int j = 0; j < P.plateau[i].length; j++) {
                if (i == J.ligne && j == J.colonne) {
                    P.plateau[i][j] = J.tag;
                }
            }
        }
    }

    public static void placerJoueur (Joueur J1, Joueur J2, Plateau P){
        /**
         * Place les joueurs s'ils sont 2
         */
        for (int i = 0; i < P.plateau.length; i++) {
            for (int j = 0; j < P.plateau[i].length; j++) {
                if (i == J1.ligne && j == J1.colonne) {
                    P.plateau[i][j] = J1.tag;
                }
                if (i == J2.ligne && j == J2.colonne) {
                    P.plateau[i][j] = J2.tag;
                }
            }
        }
    }
    public static void placerJoueur (Joueur J1, Joueur J2, Joueur J3, Plateau P){
        /**
         * Place les joueurs s'ils sont 3
         */
        for (int i = 0; i < P.plateau.length; i++) {
            for (int j = 0; j < P.plateau[i].length; j++) {
                if (i == J1.ligne && j == J1.colonne) {
                    P.plateau[i][j] = J1.tag;
                }
                if (i == J2.ligne && j == J2.colonne) {
                    P.plateau[i][j] = J2.tag;
                }
                if (i == J3.ligne && j == J3.colonne) {
                    P.plateau[i][j] = J3.tag;
                }
            }
        }
    }

    public static void placerJoueur (Joueur J1, Joueur J2, Joueur J3, Joueur J4, Plateau P){
        /**
         * Place les joueurs s'ils sont 4
         */
        for (int i = 0; i < P.plateau.length; i++) {
            for (int j = 0; j < P.plateau[i].length; j++) {
                if (i == J1.ligne && j == J1.colonne) {
                    P.plateau[i][j] = J1.tag;
                }
                if (i == J2.ligne && j == J2.colonne) {
                    P.plateau[i][j] = J2.tag;
                }
                if (i == J3.ligne && j == J3.colonne) {
                    P.plateau[i][j] = J3.tag;
                }
                if (i == J4.ligne && j == J4.colonne) {
                    P.plateau[i][j] = J4.tag;
                }
            }
        }
    }
}
