package TP1;

public class Humain {

    private String boisson;
    private String nom;

    private static String BOISSON_PAR_DEFAUT = "l'eau";

    public Humain(String nom) {
        this(nom, BOISSON_PAR_DEFAUT);
    }

    public Humain(String nom, String boisson) {
        this.nom=nom;
        this.boisson = boisson;
    }

    public void sePresenter() {
        parler("Bonjour, je suis " + tonNom()+ " et ma boisson favorite est " +quelEstTaBoissonFavorite()+"\n");
    }

    public void parler(String texte) {
        System.out.println("("+nom+ ") - " +texte);
    }

    public void boire() {
        parler("Ah, un verre de ma boisson favorite " +quelEstTaBoissonFavorite()+ "! GLOUPS !");
    }

    public String quelEstTaBoissonFavorite() {
        return boisson;
    }

    public String tonNom() {
        return nom;
    }
}
