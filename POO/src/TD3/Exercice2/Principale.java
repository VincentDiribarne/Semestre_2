package TD3.Exercice2;

public class Principale {
    public static void main(String[] args) {

        LesAnimaux mesAnimaux = new LesAnimaux();

        Chien leChien = new Chien("Labrador", 40., 1);
        Canard leCanard = new Canard("Mulard", 4);
        Serpent leSerpent = new Serpent("Serpent à Sonnette", 5.0, 75, false);

        mesAnimaux.ajouter(leChien);
        leChien.setNbPatte(3);

        mesAnimaux.ajouter(leCanard);
        mesAnimaux.ajouter(leChien);
        mesAnimaux.ajouter(leSerpent);
        //System.out.println(mesAnimaux);

        //mesAnimaux.cacophonie();

        mesAnimaux.AfficherParPatte(3);
    }
}
