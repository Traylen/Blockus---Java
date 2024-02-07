package Class;
import java.lang.invoke.TypeDescriptor;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Class.Interface.menu;
import static Class.Jeu.*;



public class Main {

    public static void main(String[] args) {

        Jeu plateau = new Jeu();

        //plateau.afficher();

        Joueur J1 = new Joueur();
        Joueur J2 = new Joueur();


        plateau.positionDeDepart(J1, J2);

        plateau.placerJoueur(J1, J2);

        System.out.println("Peut bouger : " + J1.peutBougerBas(plateau));
        System.out.println("Peut bouger : " + J1.peutBougerHaut(plateau));

        plateau.afficher();

        J1.seDeplacer(plateau);
        plateau.placerJoueur(J1);

        plateau.afficher();









    }
}