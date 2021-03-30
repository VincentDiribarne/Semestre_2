package TD1.Exercice1;

public class Surcharge {
    static String Default_Text="Ceci est un texte par defaut";

    public void affiche() {
        affiche(Default_Text);
    }

    public void affiche(String message) {
        System.out.println(message);
    }

    public void affiche(int nb, String message) {
        for (int i=0; i < nb; i++) {
            affiche(message);
        }
    }
}
