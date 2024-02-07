import java.lang.invoke.TypeDescriptor;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Class.Interface.menu;
import static Class.Jeu.*;



public class Main {

    public static void main(String[] args) {

        Jeu plateau = new Jeu();

        //plateau.afficher();

        Joueur Younes = new Joueur("Younes", 6, 5);
        Joueur Nicolas = new Joueur("Nicolas", 6, 6);

        plateau.placerJoueur(Younes, Nicolas);

        plateau.afficher();









    }
}