package Class;

import static Class.GestionErreurs.verificationEntier;
import static Class.Jeu.Jouer;
import static Class.Scores.*;

public class Interface {

    public static void menu(int i){
        /**
         * Affiche les choix disponibles
         */
        System.out.println(" \n Bienvenue dans le Menu");
        System.out.println(" \n ╭────────────────────────╮");
        System.out.println(" │ 1 - Lire les règles    │");
        System.out.println(" │ 2 - Jouer au jeu       │");
        System.out.println(" │ 3 - Scores             │");
        System.out.println(" │ 4 - Quitter            │");
        System.out.println(" ╰────────────────────────╯");
        System.out.println("\n Choisissez une option : ");

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
                        System.out.println("Deconnexion en cours, trop de mémoire utilisée, va exploser et tuer humains");
                        System.exit(0);
                    }
                    /**
                     * Affiche les règles et remontre le menu
                     */
                    System.out.println("Règles du jeu : \n\n╭───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n│ 2 à 4 joueurs arrivent dans l'arène, le dernier en vie remporte la partie !                                                           │\n│ Les joueurs jouent chacun leur tour, lors d'un tour un joueur doit :                                                                  │\n│ • Se déplacer                                                                                                                         │\n│ • Détruire une case                                                                                                                   │\n│ Lorsqu'un joueur ne peut plus se déplacer, donc que toutes les cases autour de lui sont soit occupées, soit détruites, il est éliminé.│\n╰───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯");
                    menu(++i);
                    break;

                case 2:
                    /**
                     * Lance le jeu
                     */
                    System.out.println("Lancement jeu");
                    Jouer();
                    break;

                case 3:
                    /**
                     * Ouvre le menu des scores
                     */
                    System.out.println("\n Normalement score s'affiche");
                    afficherScores();
                    break;


                case 4:
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


}
