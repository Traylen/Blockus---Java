package Class;

import static Class.Joueur.*;
import static Class.Jeu.*;

public class Scores {
    public static void afficherScores(){
        System.out.println();
    }

    private static void scores(List<Joueur> Joueurs) {
        if (Joueurs.size() == 1) {
            Joueur joueurEnVie = Joueurs.get(0);
            joueurEnVie.ajouterScore(5); // cette méthode ajoute le score au joueur
            System.out.println("Le joueur " + joueurEnVie.nom + " gagne 5 points et a maintenant un score de " + joueurEnVie.getScore());
        }
    }
}

