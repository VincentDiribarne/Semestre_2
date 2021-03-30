package TD3.Exercice5;

public class Fichier extends Element {

    private int taille;

    public Fichier(String nom, int taille) {
        super(nom);
        this.taille=taille;
    }

    public int getTaille() {
        return taille;
    }

    @Override
    public String toString() {
        return "(F) - " +super.toString();
    }
}
