package TD3.Exercice1;

public class Livre {

    //attribut de CLASSE
    private static int numLivres = 0;
    private static final String EDITEUR_NON_RENSEIGNE = "Non Connu";
    private static final int NB_PAGES_NON_RENSEIGNE = -1;

    //attribut d'objet
    private String titre;
    private String auteur;
    private String editeur;
    private int nbPages;
    private int numero;

    //constructeurs

    public Livre(String titre, String auteur) {
        this (titre, auteur, EDITEUR_NON_RENSEIGNE, NB_PAGES_NON_RENSEIGNE);
    }

    public Livre(String titre, String auteur, String editeur, int nbPages) {
        this.titre = titre;
        this.auteur = auteur;
        this.editeur = editeur;
        this.nbPages = nbPages;
        numero = ++numLivres;
    }

    //getters / setters
    public int getNumLivres() {
        return numLivres;
    }

    // public void setNumLivres(int numLivres) {
    // 	this.numLivres = numLivres;
    // }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getEditeur() {
        return editeur;
    }

    public void setEditeur(String editeur) {
        this.editeur = editeur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public void setNbPages(int nbPages) {
        this.nbPages = nbPages;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Livre : Titre = " + titre + ", Auteur = " + auteur + ", Editeur = " + editeur
                + ", Nombre de pages = [" + nbPages + "], Numero = [" + numero + "]";
    }
}
