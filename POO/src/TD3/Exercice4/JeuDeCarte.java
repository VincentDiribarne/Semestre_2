package TD3.Exercice4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JeuDeCarte {

    private int nbrCarte = 52;
    private List<Carte> cartes;

    public JeuDeCarte(){
        cartes = new ArrayList<>();
        for (Couleur couleur: Couleur.values()) {
            for (Valeur valeur: Valeur.values()){
                cartes.add(new Carte(couleur,valeur));
            }
        }
    }

    @Override
    public String toString() {
        String message = "Voici les "+ cartes.size() + " cartes contenues dans le jeu : \n";
        for (Carte carte: cartes) {
            message += carte + "\n";
        }
        return message;
    }

    public void brasser(){
        Collections.shuffle(cartes);
    }

    public Carte distribuer() throws IndexOutOfBoundsException{
        return cartes.remove(--nbrCarte);
    }
}
