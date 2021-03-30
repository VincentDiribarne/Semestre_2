package Bastien;

public class Person {

    private String nom;

    public Person(String nom) {
        this.nom=nom;
    }

    public void prayforBastien() {
        parler("Je prie pour le retour de Bastien");
        parler("COuou");
    }

    public void parler(String texte) {
        System.out.println("("+nom+ ") - " +texte);
    }

    public String getName() {
        return nom;
    }
}
