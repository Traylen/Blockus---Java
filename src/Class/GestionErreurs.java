package Class;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionErreurs {

    public static int verificationEntier(){

        /**
         * Cette fonction permet à l'utilisateur d'entrer un entier
         *  Elle permet de gérer les cas où la valeur entrée ne correspond pas à un entier
         **/

        int valeur = 0;

        while (valeur < 1) {
            try {
                Scanner scanner = new Scanner(System.in);
                valeur = scanner.nextInt();
                if (valeur < 1){
                    System.out.println("Pas de 0, ni de nombre négatif chef !");
                }

            } catch (InputMismatchException e) {
                /**
                 * Si la valeur n'est pas un entier
                 */
                System.out.println("Veuillez entrer un chiffre (Qu'est ce que tu dis de ça Clément)");
            } catch (Exception e) {
                /**
                 * S'il y a une autre erreur
                 */
                System.out.println("Veuillez entrer un chiffre (Pas à moi Clément)");
            }
        }
        return valeur;
    }

    public static String verificationChaine(){

        /**
         * Cette fonction permet à l'utilisateur d'entrer une chaîne de charactère
         *  Elle permet de gérer les cas où la valeur entrée ne correspond pas à une chaîne de caractère
         **/

        String valeur = "O";

        while (valeur == "O") {
            try {
                Scanner scanner = new Scanner(System.in);
                valeur = scanner.nextLine();

            } catch (InputMismatchException e) {
                /**
                 * Si la valeur n'est pas un entier
                 */
                System.out.println("Veuillez entrer une chaîne de charactère (Oui Clément, on a tout prévu)");
            } catch (Exception e) {
                /**
                 * S'il y a une autre erreur
                 */
                System.out.println("Veuillez entrer une chaîne de charactère (Bien essayé )");
            }
        }
        return valeur;
    }

    public static char verificationChar(){

        /**
         * Cette fonction permet à l'utilisateur d'entrer une chaîne de charactère
         *  Elle permet de gérer les cas ou la valeur entrée ne correspond pas à une chaîne de caractère
         **/

        char valeur = 'O';
        while (valeur == 'O') {
            try {
                Scanner scanner = new Scanner(System.in);
                valeur = scanner.next().charAt(0);
            } catch (InputMismatchException e) { // Si la valeur n'est pas un char
                System.out.println("Veuillez entrer un charactère unique (Oui Clément, on a tout prévu)");
            } catch (Exception e) { // Si il y a une autre erreur quelconque
                System.out.println("Veuillez entrer un charactère unique (Bien essayé )");
            }
        }
        return valeur;

    }
    public static boolean verificationCase(char [][] plateau, int ligne, int colonne){
        /**
         * Gestion des erreurs en jeu
         * si joueur déjà présent, si case détruite, si bord du terrain
         */
        if (plateau[ligne][colonne] == '□') {}
        switch (plateau[ligne][colonne]) {
            case '□':
                return true;
            case 'X':
                System.out.println("Mais enfin pas cette case, elle est détruire");
                return false;
            case '/':
                System.out.println("Vous voulez sortir du plateau ? Vous vous ennuyez à ce point ?");
                return false;
            default:
                System.out.println("Vous ne pouvez pas choisir cette case voyons, il y a un joueur dessus");
                break;
        }
        return false;
    }

    public static boolean verificationBouger(Joueur J, Plateau P){
        /**
         * Vérifie si le joueur peut bouger droite, gauche, haut et bas, return flase ou true
         */
        if (P.plateau[J.ligne-1][J.colonne] != '□' && P.plateau[J.ligne+1][J.colonne] != '□' && P.plateau[J.ligne][J.colonne-1] != '□' && P.plateau[J.ligne][J.colonne+1] != '□') {
            return false;
        } else {
            return true;
        }
    }

    public static boolean verificationPseudo(ArrayList<Joueur> listeJ, String nom) {
        /**
         * Vérifie si le pseudo du joueur est unique en parcourant la liste des joueurs
         */
        boolean dejaPris = false;
        for (Joueur joueur : listeJ) {
            if ( joueur.nom.equals(nom)) {
                dejaPris = true;
            }
        }
        return dejaPris;
    }

    public static boolean verificationTag(ArrayList<Joueur> listeJ, char tag) {
        /**
         * Vérifie que le tag est unique en parcourant la liste des tag
         */
        boolean dejaPris = false;
        for (Joueur joueur : listeJ) {
            if ( joueur.tag == tag ) {
                dejaPris = true;
            }
        }
        return dejaPris;
    }
}
