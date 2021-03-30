package TD3.Exercice2;

public abstract class Animal {

    //Attribut
    public double poids;
    public String race;

    //Constructeur
    public Animal(String race, double poids) {
        this.race=race;
        this.poids=poids;
    }

    //Accesseurs
    public String getRace() {
        return race;
    }
    public double getPoids() {
        return poids;
    }

    //Methodes
    public String toString() {
        return ("Race : " +race+ ", Poids : " +poids+ " kilogrammes");
    }
    public abstract void cri();
}
