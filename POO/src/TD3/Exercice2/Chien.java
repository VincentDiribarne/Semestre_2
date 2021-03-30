package TD3.Exercice2;

public class Chien extends AnimalAvecPattes {
    private static final int NB_PATTES_DEFAUT = 4;
    private int categorie;

    public Chien(String race, double poids, int categorie) {
        super(race, poids, NB_PATTES_DEFAUT);
        this.categorie = categorie;
    }

    public int getCategorie() {
        return categorie;
    }

    public void cri(){
        System.out.println("Ouaf, Ouaf");
    }

    @Override
    public String toString() {
        return (super.toString() + ", Catégorie : " + categorie);
    }
}
