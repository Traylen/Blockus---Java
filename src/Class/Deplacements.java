package Class;

import java.util.ArrayList;

import static Class.GestionErreurs.verificationCase;
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

    public static String choisirDirection(Joueur J) {
        String direction = "O";
        System.out.println("Au tour de " + J.nom);
        while ( direction == "O" ){
            //System.out.println("\nZ : ↑ | Q : ← | S : ↓ | D : →");
            //System.out.println("Z  |  Q  |  S  |  D");
            //System.out.println("↑  |  ←  |  ↓  |  →");
            //
            //System.out.println("    ↑");
            //System.out.println("    Z");
            //System.out.println("←   ↓   →");
            //System.out.println("Q   S   D");
            //
            System.out.println("    Z           ↑");
            System.out.println("Q   S   D   ←   ↓   →");
            direction = verificationChaine().toUpperCase(); // Récupère une chaîne de caractère
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
            String direction = choisirDirection(J);
            P.plateau[J.ligne][J.colonne] = '□'; // Retire le tag de la case précédente
            switch (direction){
                case "Z": // Se déplace vers le Haut
                    caseVide = verificationCase(P.plateau, J.ligne-1, J.colonne);
                    if (caseVide){
                        J.ligne -= 1;
                    }
                    break;
                case "S": // Se déplace vers le Bas
                    caseVide = verificationCase(P.plateau, J.ligne+1, J.colonne);
                    if (caseVide){
                        J.ligne += 1;
                    }
                    break;
                case "Q": // Se déplace vers la gauche
                    caseVide = verificationCase(P.plateau, J.ligne, J.colonne-1);
                    if (caseVide){
                        J.colonne -= 1;
                    }
                    break;
                case "D": // Se déplace vers la droite
                    caseVide = verificationCase(P.plateau, J.ligne, J.colonne+1);
                    if (caseVide){
                        J.colonne += 1;
                    }
                    break;
                default: // Exeptions
                    System.out.println("Problème");
                    break;
            }
        }

    }


}
