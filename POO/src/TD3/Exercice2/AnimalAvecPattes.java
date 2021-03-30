package TD3.Exercice2;

public abstract class AnimalAvecPattes extends Animal {

    private int nbPatte;

    public AnimalAvecPattes(String race, double poids, int nbPatte) {
        super(race, poids);
        this.nbPatte=nbPatte;
    }

    public int getNbPatte() {
        return nbPatte;
    }

    public void setNbPatte(int nbPatte) {
        this.nbPatte=nbPatte;
    }

    public String toString() {
        return (super.toString()+", Nombre de patte : " +nbPatte+ " pattes");
    }
}
