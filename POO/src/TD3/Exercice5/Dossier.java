package TD3.Exercice5;

import java.util.ArrayList;
import java.util.List;

public class Dossier extends Element{

    private final List<Element> lesElements;
    private Dossier parent;

    public Dossier(String nom){
        super(nom);
        lesElements = new ArrayList<>();
        parent = this;
    }

    public Dossier(String nom, Dossier parent) {
        this(nom);
        this.parent=parent;
        parent.ajouterElement(this);
    }

    public void ajouterElement(Element element) {
        lesElements.add(element);
    }

    public void afficheContenu() {
        System.out.println("Contenu du dossier '" +getNom()+ "' (dossier parent) '" +parent.getNom()+ "'");
        for(Element element : lesElements) {
            System.out.println(element);
        }
    }

    public void afficheTaille() {
        System.out.println("\nTaille du dossier " + getNom() + " : " + calculTaille());
    }

    public int calculTaille() {
        int tailleTotale = 0;
        for(Element element : lesElements) {
            if (element instanceof Dossier){
                tailleTotale += ((Dossier) element).calculTaille();
            } else {
                tailleTotale += ((Fichier) element).getTaille();
            }
        }
        return tailleTotale;
    }

    public void afficheFichier(int tailleMin) {
        System.out.println("\nFichier(s) dont la taille est sup a " +tailleMin+ " :");

        for (Element e : lesElements) {
            if (e instanceof Fichier && ((Fichier) e).getTaille() > tailleMin) {
                System.out.println(e + " - " +((Fichier) e).getTaille());
            }
        }
    }


    public String toString() {
        return "(D) - " +super.toString();
    }
}