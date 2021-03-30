package TD3.Exercice2;

public class Serpent extends AnimalSansPattes {

    private boolean venimeux;

    public Serpent(String race, double poids, double longueur, boolean venimeux) {
        super(race, poids, longueur);
        this.venimeux=venimeux;
    }

    public boolean isVenimeux() {
        return venimeux;
    }

    @Override
    public void cri() {
        System.out.println("tsss, tsss");
    }

    @Override
    public String toString() {
        String venimeux = isVenimeux() ? "Venimeux" : "Non venimeux";
        return (super.toString() + ", " +venimeux);
    }
}
