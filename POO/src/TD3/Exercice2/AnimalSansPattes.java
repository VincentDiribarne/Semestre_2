package TD3.Exercice2;

public abstract class AnimalSansPattes extends Animal {

    private double longueur;

    public AnimalSansPattes(String race, double poids, double longueur) {
        super(race, poids);
        this.longueur=longueur;
    }

    public double getLongueur() {
        return longueur;
    }

    public String toString() {
        return (super.toString()+", Longueur : " +longueur+ " centimètres");
    }
}
