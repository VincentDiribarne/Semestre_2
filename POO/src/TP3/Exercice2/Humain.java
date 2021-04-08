package TP3.Exercice2;

public class Humain {
    private String name;

    public String parler(String texte){
        return "("+name+") - " +texte;
    }

    public String getName() {
        return name;
    }
}
