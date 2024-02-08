package Class;

//import static Class.Deplacements.deplacer;
import static Class.Deplacements.*;
import static Class.Destructions.*;
import static Class.GestionErreurs.verificationEntier;
import Class.Deplacements.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Jeu {

    public static int nbJoueurs = 0;

    public static void Jouer() {
        Plateau plateau = new Plateau();


        while (nbJoueurs == 0 ) {
            System.out.println("Combien de joueurs ?");
            nbJoueurs = verificationEntier();

            if (nbJoueurs == 1) {
                System.out.println("Chef, t'as pas d'amis ou quoi ?");
                nbJoueurs = 0;
            }

            else if (nbJoueurs < 2 || nbJoueurs > 4) {
                System.out.println("Chef c'est des parties à 2, 3 ou 4 joueurs");
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


        while ( Joueurs.toArray().length > 1 ){

            for (Joueur joueur : Joueurs) {
                plateau.afficher();
                deplacement(joueur, plateau);
                placer(joueur, plateau);
                plateau.afficher();
                detruire(plateau);
                plateau.afficher();
            }


        }


    }


}
