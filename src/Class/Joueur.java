package Class;

public class Joueur {

    //Les booléens permettant de determiner les actions que le joueur peut faire sur son tour
    boolean peutBouger = false;
    boolean peutDetruire = false;
    //Valeurs qui serviront a differancier les differents joueurs
    String nom = "";
    String numeroJoueur = "";

    public int positionX;
    public int positionY;

    public Joueur(String nom, int x, int y){
        this.nom = nom;
        this.positionX = x;
        this.positionY = y;
    }






    //Les Getter et les Setter

    public boolean isPeutBouger(){
        return peutBouger;
    }
    public void SetPeutBouger(boolean peutBouger){
        this.peutBouger = peutBouger;
    }
    public boolean isPeutDetruire(){
        return peutDetruire;
    }
    public void SetPeutDetruire(boolean peutDetruire){
        this.peutDetruire = peutDetruire;
    }
    public String GetNom() {
        return nom;
    }
    public void SetNom(String nom) {
        this.nom = nom;
    }

    public String GetNumeroJ() {
        return numeroJoueur;
    }
    public void SetNumeroJ(String numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }
}
