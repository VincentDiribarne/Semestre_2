package TD3.Exercice2;

public class Canard extends AnimalAvecPattes{
    private static final int NB_PATTES_DEFAUT = 2;

    public Canard(String race, double poids) {
        super(race, poids, NB_PATTES_DEFAUT);
    }

    @Override
    public void cri() {
        System.out.println("Coin, Coin");
    }
}
