package TP3.Exercice2;

public class Mendiant extends Humain {
    private String name;

    public void Mendiant(String name) {
        this.name=name;
    }

    public String toString() {
        return("Je suis " +name);
    }
}
