package Class;

import static Class.GestionErreurs.verificationEntier;

public class Interface {

    public static void menu(int i){
        /**
         * Affiche les choix disponibles
         */
        System.out.println(" \nBienvenue dans le Menu");
        System.out.println("\n1 - Lire les règles");
        System.out.println("2 - Jouer au jeu");
        System.out.println("3 - Quitter");
        System.out.println("\nChoisissez une option : ");

        int choix = 0;

        while ( choix == 0 ) {
            choix = verificationEntier();
            /**
             * Tant que le choix n'est pas valide, redemander un nombre
             */

            switch (choix) {
                case 1:
                    if (i == 10) {
                        /**
                         * Si lis les règles +10 fois, msg troll
                         */
                        System.out.println("ça fait 10 fois que tu lis les règles c'est bon là non ?");
                    }
                    if (i == 100) {
                        /**
                         * si lis les règles +100 fois, ferme le programme pour pas tue humains
                         */
                        System.out.println("Deconnexion en cour, trop de mémoire utilisée, va exploser et tue humains");
                        System.exit(0);
                    }
                    /**
                     * Affiche les règles et remontre le menu
                     */
                    System.out.println("Règles du jeu : \n \n 2 à 4 joueurs arrivent dans l'arène, le dernier en vie remporte la partie ! \n Les joueurs jouent chacun leur tour, lors d'un tour un joueur doit : \n • Se déplcer\n • Détruire une case\n Lorsqu'un joueur ne peut plus se déplacer, donc que toutes les cases autour de lui sont soit occupées, soit détruites, il est éliminé.");
                    menu(++i);
                    break;

                case 2:
                    /**
                     * Lance le jeu
                     */
                    System.out.println("Lancement jeu");
                    Jeu plateau = new Jeu();
                    plateau.afficher();
                    break;

                case 3:
                    /**
                     * Deconnecte le jeu
                     */
                    System.out.println("\n Deconnexion en cours");
                    System.exit(0);
                    break;

                default:
                    /**
                     * Si autre que 1, 2 ou 3, redemande
                     */
                    System.out.println("Ba clément c'est pas un des choix proposés ça");
                    choix = 0;
                    break;
            }
        }
    }

    public static void Jouer() {
        Jeu plateau = new Jeu();

        plateau.nbJoueurs = 0;

        while (plateau.nbJoueurs == 0 ) {
            System.out.println("Combien de joueurs ?");
            plateau.nbJoueurs = verificationEntier();

            if (plateau.nbJoueurs == 1) {
                System.out.println("Chef, t'as pas d'amis ou quoi ?");
                plateau.nbJoueurs = 0;
            }
            else if (plateau.nbJoueurs < 2 || plateau.nbJoueurs > 4) {
                System.out.println("Chef c'est des parties à 2, 3 ou 4 joueurs");
                plateau.nbJoueurs = 0;
            }
        }

        System.out.println("Lancement d'une partie à " + plateau.nbJoueurs + " joueurs");

        Joueur J1 = null;
        Joueur J2 = null;
        Joueur J3 = null;
        Joueur J4 = null;

        if (plateau.nbJoueurs == 2) {
            J1 = new Joueur();
            J2 = new Joueur();
            plateau.positionDeDepart(J1, J2);
            plateau.placerJoueur(J1, J2);
        } else if (plateau.nbJoueurs == 3) {
            J1 = new Joueur();
            J2 = new Joueur();
            J3 = new Joueur();
            plateau.positionDeDepart(J1, J2, J3);
            plateau.placerJoueur(J1, J2, J3);
        } else if (plateau.nbJoueurs == 4) {
            J1 = new Joueur();
            J2 = new Joueur();
            J3 = new Joueur();
            J4 = new Joueur();
            plateau.positionDeDepart(J1, J2, J3, J4);
            plateau.placerJoueur(J1, J2, J3, J4);
        } else {
            System.out.println("Erreur lors du chargement. Ça arrive. Retour au menu");
        }

        System.out.println("QUE LA PARTIE COMMENCE");

        plateau.afficher();

        while ( plateau.nbJoueurs > 1 ){
            if (J1.peutBouger){
                J1.seDeplacer();
                plateau.placerJoueur(J1);
                plateau.afficher();
                plateau.detruire();
                plateau.afficher();
            }
            if (J2.peutBouger){
                J2.seDeplacer();
                plateau.placerJoueur(J2);
                plateau.afficher();
                plateau.detruire();
                plateau.afficher();
            }
            if (J3 != null ){
                if (J3.peutBouger){
                    J3.seDeplacer();
                    plateau.placerJoueur(J3);
                    plateau.afficher();
                    plateau.detruire();
                    plateau.afficher();
                }
            }
            if (J4 != null ){
                if (J4.peutBouger){
                    J4.seDeplacer();
                    plateau.placerJoueur(J4);
                    plateau.afficher();
                    plateau.detruire();
                    plateau.afficher();
                }
            }


        }


    }
}
