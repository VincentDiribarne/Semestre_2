package TD3.Exercice4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainJoueur {
    private String nom;
    private Set<Carte> lesCartes;

    public MainJoueur(String nom) {
        this.nom = nom;
        this.lesCartes = new HashSet<>();
    }

    public void recevoirCarte(Carte c) {
        lesCartes.add(c);
    }

    public void paire(){
        for (Carte carte: lesCartes) {
            for (Carte carte1: lesCartes){
                if (carte != carte1 && carte.getValeur() == carte1.getValeur()){
                    System.out.println("Une paire : \n \t - " + carte+"\n \t -"+carte1);
                }
            }
        }
    }
    public void brelan(){
        for (Carte carte: lesCartes) {
            for (Carte carte1: lesCartes){
                for (Carte carte2 : lesCartes){
                    if (carte != carte1 && carte != carte2 && carte1 != carte2 && carte.getValeur() == carte1.getValeur() && carte.getValeur() == carte2.getValeur()){
                        System.out.println("Un brelan : \n \t - " + carte+"\n \t -"+carte1+"\n \t -"+carte2);

                    }
                }

            }
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("Cartes dans la main de " +nom);

        for (Carte c: lesCartes) {
            res.append("\t -"+c+"\n");

        }
        return res.toString();
    }

    public Valeur getValeurPremierePairePresente() {
        for (Carte carte : lesCartes) {
            for (Carte carte1 : lesCartes) {
                if (carte != carte1 && carte.getValeur() == carte1.getValeur()) {
                return carte.getValeur();
                }
            }
        }
        return null;
    }
}
