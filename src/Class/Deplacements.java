package Class;

import java.util.ArrayList;

import static Class.GestionErreurs.verificationCase;
import static Class.GestionErreurs.verificationChaine;

public class Deplacements {


    public static void caseDeDepart(ArrayList<Joueur> joueurs) {
        int nombreJoueurs = joueurs.size();
        /**
         * Placement de base pour 2, 3 ou 4 joueurs.
         */
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
                break;
        }
    }

    public static void placer(Joueur J, Plateau P) {
        /**
         * Place les joueurs après avoir récupéré leur position
         */
        int colonne = J.colonne;
        int ligne = J.ligne;

        P.plateau[ligne][colonne] = J.tag;
    }

    public static String choisirDirection(Joueur J) {
        String direction = "O";
        System.out.println("Au tour de " + J.nom);
        while ( direction == "O" ){

            System.out.println("\n    Z      |      ↑");
            System.out.println("Q   S   D  |  ←   ↓   →");
            direction = verificationChaine().toUpperCase();
            /**
             * Récupère une chaine de caractères, tant que non valable recommence
             */
            if (!direction.equals("Z") && !direction.equals("Q") &&
                !direction.equals("S") && !direction.equals("D")) {
                System.out.println("Pas la bonne direction");
                direction = "O";
            }
        }
        return direction;
    }

    public static void deplacement(Joueur J, Plateau P){
        boolean caseVide = false;

        while (!caseVide) {
            /**
             * Retire le tag de case précèdente, et déplace le joueur, "ZQSD" ou "zqsd"
             */
            String direction = choisirDirection(J);
            P.plateau[J.ligne][J.colonne] = '□';
            switch (direction){
                case "Z": //
                    caseVide = verificationCase(P.plateau, J.ligne-1, J.colonne);
                    if (caseVide){
                        J.ligne -= 1;
                    }
                    break;
                case "S": //
                    caseVide = verificationCase(P.plateau, J.ligne+1, J.colonne);
                    if (caseVide){
                        J.ligne += 1;
                    }
                    break;
                case "Q": //
                    caseVide = verificationCase(P.plateau, J.ligne, J.colonne-1);
                    if (caseVide){
                        J.colonne -= 1;
                    }
                    break;
                case "D": //
                    caseVide = verificationCase(P.plateau, J.ligne, J.colonne+1);
                    if (caseVide){
                        J.colonne += 1;
                    }
                    break;
                default:
                    /**
                     * Gestion des exeptions
                     */
                    System.out.println("Problème");
                    break;
            }
        }

    }


}
