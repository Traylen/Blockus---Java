package Class;

import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class sauvegarde {

    public static void sauvegarderScores(List<Joueur> joueurs, String scoreSauvegarde) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(scoreSauvegarde, true))) {
            for (Joueur joueur : joueurs) {
                bw.write(joueur.nom + " : " + joueur.score);
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            System.out.println("Erreur lors de l'écriture dans le fichier : " + e.getMessage());
        }
    }
}
