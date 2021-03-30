package TD3.Exercice4;

import java.util.ArrayList;
import java.util.List;

public class Principale {
    public static void main(String args[]){
        JeuDeCarte jeuDeCarte = new JeuDeCarte();
        System.out.println(jeuDeCarte);
        jeuDeCarte.brasser();

        List<Carte> joueur1 = new ArrayList<>();
        List<Carte> joueur2 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            try {
                joueur1.add(jeuDeCarte.distribuer());
                joueur2.add(jeuDeCarte.distribuer());
            }
            catch (IndexOutOfBoundsException e){
                System.out.println("Le paquet est vide.");
            }
        }
        System.out.println("Carte du joueur : " + joueur1);
        System.out.println("Carte du joueur : " + joueur2);

        MainJoueur mainJoueur1 = new MainJoueur("Vincent");
        System.out.println(mainJoueur1+ " contient au moins une paire de : " +mainJoueur1.getValeurPremierePairePresente());

        MainJoueur mainJoueur2 = new MainJoueur("Baptiste");
        System.out.println(mainJoueur2+ " contient au moins une paire de : " +mainJoueur2.getValeurPremierePairePresente());
    }
}
