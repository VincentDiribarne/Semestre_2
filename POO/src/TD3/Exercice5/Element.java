package TD3.Exercice5;

public abstract class Element {
    private String nom;
    private Dossier parent;

    public Element(String nom) {
        super();
        this.nom=nom;
    }

    public Dossier getParent() {
        return parent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
