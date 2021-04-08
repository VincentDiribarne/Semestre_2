package TP3.Exercice2;

public class Humain {
    private String name;

    public Humain(String name) {
        this.name=name;
    }

    public String parler(String texte){
        return "("+name+") - " +texte;
    }

    public String getName() {
        return name;
    }
}
