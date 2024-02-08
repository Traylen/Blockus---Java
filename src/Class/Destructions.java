package Class;

import java.util.Scanner;

import static Class.GestionErreurs.verificationCase;
import static Class.GestionErreurs.verificationEntier;

public class Destructions {

    public static void detruire(Plateau P) {
        System.out.println("Choisissez une case à détruire");

        boolean caseVide = false;
        int ligne = 0;
        int colonne = 0;

        while ( !caseVide ){

            ligne = choixCase(P, "ligne"); // Fonction qui récupére la ligne de la case à détruire

            colonne = choixCase(P, "colonne"); // Fonction qui récupére la colonne de la case à détruire

            caseVide = verificationCase(P.plateau, ligne, colonne);

        }

        P.plateau[ligne][colonne] = 'X';//mettre X au bonne coordonnées
    }

    public static int choixCase(Plateau P, String axe){
        int choix = 0;
        int nbLignes = P.plateau.length-2;
        int nbColonnes = P.plateau[0].length-2;

        while ( choix < 1 ) {
            System.out.println("Entrez l'indice de la " + axe + " : ");
            choix = verificationEntier();
            switch (axe){
                case "ligne":
                    if (choix > nbLignes) {
                        System.out.println("Frero y'a que " + nbLignes + " lignes");
                        choix = 0;
                    }
                    break;
                case "colonne":
                    if (choix > nbColonnes) {
                        System.out.println("Frero y'a que " + nbColonnes + " colonnes");
                        choix = 0;
                    }
                    break;
            }
        }
        return choix;
    }
}
