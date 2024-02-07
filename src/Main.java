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

        Joueur Younes = new Joueur("Younes");
        Joueur Nicolas = new Joueur("Nicolas");
        Joueur Dede = new Joueur("Dede");
        Joueur Alpha = new Joueur("Alpha");
        plateau.positionDeDepart(Younes, Nicolas, Dede, Alpha);
        plateau.placerJoueur(Younes, Nicolas, Dede, Alpha);

        plateau.afficher();









    }
}