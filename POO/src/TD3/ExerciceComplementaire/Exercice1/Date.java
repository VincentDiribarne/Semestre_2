package TD3.ExerciceComplementaire.Exercice1;

public class Date {

    private static final int ANNEE_MIN = 1582;
    private static final String[] nomMois = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Décembre" };

    private int jour;
    private int mois;
    private int annee;
    private int tab[] = new int [10];


    public Date(int jour, int mois, int annee) throws DateException {

        if (annee < ANNEE_MIN) {
            throw new DateException("Annee Incorrect");
        }
        this.annee=annee;

        if (mois > 12 || mois < 1) {
            throw new DateException("Mois Incorrect");
        }
        this.mois = mois;

        int max = maxJourParMois(mois);
        if (jour < 1 || jour > max) {
            throw new DateException("Jour Incorrect");
        }
        this.jour = jour;
    }

    public void demain() {
        if (++jour > maxJourParMois(this.mois)) {
            this.jour=1;
            if (++mois > 12) {
                this.mois=1;
                annee++;
            }
        }
        System.out.println(jour+ "/" +mois+ "/" +annee);
    }

    public int maxJourParMois(int mois){
        int [] tab = new int [] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (Bissextile()) {
            tab[1] = 29;
        }
        return tab[mois - 1];
    }

    public boolean Bissextile() {
        return ((annee % 4 == 0 && (annee % 100 != 0)) || (annee % 400 == 0));
    }

    public String toString() {
        return (jour+ " " +nomMois[mois-1]+ " " +annee);
    }

    public int getAnnee() {
        return annee;
    }

    public int getJour() {
        return jour;
    }

    public int getMois() {
        return mois;
    }
}