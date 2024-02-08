package Class;

import java.util.ArrayList;

import static Class.GestionErreurs.verificationCase;
import static Class.GestionErreurs.verificationChaine;
import static Class.Interface.menu;

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

            System.out.println("R - Règles");
            System.out.println("X - Quitter");
            direction = verificationChaine().toUpperCase(); // Récupère une chaîne de caractère

            if (!direction.equals("Z") && !direction.equals("Q") &&
                !direction.equals("S") && !direction.equals("D") &&
                !direction.equals("X") && !direction.equals("R")) {
                if (!direction.equals("X")){
                    direction = "0";
                }
                 else {
                     direction = "O";
                }
            }
        }
        return direction;
    }

    public static void deplacement(Joueur J, Plateau P){
        boolean caseVide = false;
        int i = 0;
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
                case "X":
                    /**
                     * Deconnecte le jeu
                     */
                    System.out.println("\nDeconnexion en cours");
                    System.exit(0);
                    break;
                case "R":
                    i += 1;
                    if (i == 10) {
                        /**
                         * Si lis les règles +10 fois, msg troll
                         */
                        System.out.println("ça fait 10 fois que tu lis les règles c'est bon là non ?");
                    }
                    if (i == 100) {
                        /**
                         * si lis les règles +100 fois, ferme le programme pour pas tue humains
                         */
                        System.out.println("Deconnexion en cour, trop de mémoire utilisée, va exploser et tue humains");
                        System.exit(0);
                    }
                    /**
                     * Affiche les règles et remontre le menu
                     */
                    System.out.println("Règles du jeu : \n \n 2 à 4 joueurs arrivent dans l'arène, le dernier en vie remporte la partie ! \n Les joueurs jouent chacun leur tour, lors d'un tour un joueur doit : \n • Se déplcer\n • Détruire une case\n Lorsqu'un joueur ne peut plus se déplacer, donc que toutes les cases autour de lui sont soit occupées, soit détruites, il est éliminé.");
                    break;
                default: // Exeptions
                    System.out.println("Problème");
                    break;
            }
        }

    }


}
