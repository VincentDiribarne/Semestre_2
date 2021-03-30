package TD2;

public class Personne {

    //attribut d'objet

    protected String nom;

    //constructeur

    public Personne(String nom) {
        super();
        this.nom = nom;
    }

    //getters/setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return getNom();
    }
}
