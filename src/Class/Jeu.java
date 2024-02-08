package Class;

//import static Class.Deplacements.deplacer;
import static Class.Deplacements.*;
import static Class.Destructions.*;
import static Class.GestionErreurs.verificationBouger;
import static Class.GestionErreurs.verificationEntier;
import Class.Deplacements.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


    public class Jeu {
        int score;

    public static int nbJoueurs = 0;
        public int getScore() {
            return this.score;
        }

    public static void Jouer() {
        Plateau plateau = new Plateau();

        /**
         * Lancement des fonctions pour l'initialisation de la partie
         */
        while (nbJoueurs == 0 ) {
            System.out.println("Combien de joueurs ?");
            nbJoueurs = verificationEntier();

            if (nbJoueurs == 1) {
                System.out.println("Chef, t'as pas d'amis ou quoi ?");
                nbJoueurs = 0;
            }

            else if (nbJoueurs < 2 || nbJoueurs > 4) {
                System.out.println("Chef ce sont des parties à 2, 3 ou 4 joueurs");
                nbJoueurs = 0;
            }
        }

        System.out.println("Lancement d'une partie à " + nbJoueurs + " joueurs");

        ArrayList<Joueur> Joueurs = new ArrayList<>();
        for (int i = 1; i <= nbJoueurs; i++) {
            System.out.println("Création du joueur " + i);
            Joueur joueur = new Joueur();
            Joueurs.add(joueur);
        }
        caseDeDepart(Joueurs);

        for (Joueur joueur : Joueurs ){
            placer(joueur, plateau);
        }

        System.out.println("QUE LA PARTIE COMMENCE");

        /**
         * Lancement des fonctions pour le déroulement de la partie
         */
        int index = -1; // Permet de gérer le tour de chaque joueurs
        Joueur J; // Variable qui stock le joueur qui joue
        ArrayList<Joueur> joueurElimine = new ArrayList<>();

        while ( Joueurs.toArray().length > 1 ) {
            System.out.println("Début boucle");


            for (Joueur elimine : joueurElimine) {
                System.out.println(elimine.nom + " est éliminé(e)");
                Joueurs.remove(elimine);
            }

            if (Joueurs.toArray().length == 1) {
                System.out.println("FIN DE LA PARTIE");
                break;
            }

            if ( index < Joueurs.toArray().length-1) { // Incrémenté pour faire jouer chaque joueur
                index++;
            } else if ( index == Joueurs.toArray().length-1 ) {
                index = 0;
            }

            J = Joueurs.get(index); // Le joueur a qui c'est le tour

            plateau.afficher();

            deplacement(J, plateau);
            placer(J, plateau);

            for (int i = 0; i < Joueurs.toArray().length; i++) {
                if (!verificationBouger(Joueurs.get(i), plateau)) {
                    System.out.println(Joueurs.get(i).nom + " est éliminé(e)");
                    Joueurs.get(i).peutBouger = false;
                    joueurElimine.add(Joueurs.get(i));
                }
            }

            plateau.afficher();
            detruire(plateau);

            for (int i = 0; i < Joueurs.toArray().length; i++) {
                if (!verificationBouger(Joueurs.get(i), plateau)) {
                    System.out.println(Joueurs.get(i).nom + " est éliminé(e)");
                    Joueurs.get(i).peutBouger = false;
                    joueurElimine.add(Joueurs.get(i));
                }
            }

        }
        //private static void scores(List<Joueur> Joueurs) {
           // if (Joueurs.size() == 1) {
           //     Joueur joueurEnVie = Joueurs.get(0);
           //     joueurEnVie.ajouterScore(5); // cette méthode ajoute le score au joueur
            //    System.out.println("Le joueur " + joueurEnVie.nom + " gagne 5 points et a maintenant un score de " + joueurEnVie.getScore());
          //  }
    //    }


    }
}



