package Class;

//import static Class.Deplacements.deplacer;
import static Class.Deplacements.*;
import static Class.Destructions.*;
import static Class.GestionErreurs.verificationBouger;
import static Class.GestionErreurs.verificationEntier;
import static Class.Interface.menu;

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

        ArrayList<Joueur> enJeu = new ArrayList<>();
        for (int i = 1; i <= nbJoueurs; i++) {
            System.out.println("Création du joueur " + i);
            Joueur joueur = new Joueur();
            enJeu.add(joueur);
        }
        caseDeDepart(enJeu);

        for (Joueur joueur : enJeu ){
            placer(joueur, plateau);
        }

        System.out.println("Lancement de la partie en cours...");

        /**
         * Lancement des fonctions pour le déroulement de la partie
         */
        int index = -1; // Permet de gérer le tour de chaque joueurs
        Joueur J; // Variable qui stock le joueur qui joue
        ArrayList<Joueur> joueurElimine = new ArrayList<>(); // List qui stock les joueurs éliminés

        while ( enJeu.toArray().length > 1 ) {

            for (Joueur elimine : joueurElimine) {
                System.out.println(elimine.nom + " est éliminé(e)");
                enJeu.remove(elimine);
            }

            if (enJeu.toArray().length == 1) {
                System.out.println("FIN DE LA PARTIE");
                break;
            }

            if ( index < enJeu.toArray().length-1) { // Incrémenté pour faire jouer chaque joueur
                index++;
            } else if ( index == enJeu.toArray().length-1 ) {
                index = 0;
            }

            J = enJeu.get(index); // Le joueur a qui c'est le tour

            plateau.afficher();

            deplacement(J, plateau);
            placer(J, plateau);

            plateau.afficher();
            detruire(plateau);

            for (int i = 0; i < enJeu.toArray().length; i++) {
                if (!verificationBouger(enJeu.get(i), plateau)) {
                    System.out.println(enJeu.get(i).nom + " est éliminé(e)");
                    enJeu.get(i).peutBouger = false;
                    joueurElimine.add(enJeu.get(i));
                }
            }
        }

            Joueur gagnant = enJeu.get(0); // Le dernier joueur restant est le gagnant
            gagnant.score += 5; // Ajouter 5 points au score du gagnant
            System.out.println(gagnant.nom + " a gagné la partie et reçoit 5 points. Son score est maintenant de " + gagnant.getScore() + " points.");
            System.out.println("Les autres perdrent 2 points");

            for (Joueur perdant : joueurElimine) {
                perdant.score -= 2;
                System.out.println(perdant.nom + " : " + perdant.score + " points");
            }
            System.out.println("\n Retour au menu...");
            menu(1);
    }
}



