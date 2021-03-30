package TD3.Exercice4;

public class Carte {

    private Couleur couleur;
    private Valeur valeur;

    public Carte(Couleur couleur, Valeur valeur){

        this.couleur = couleur;
        this.valeur = valeur;
    }

    @Override
    public String toString()
    {
        return ""+ valeur + " de " + couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Valeur getValeur() {
        return valeur;
    }


}
