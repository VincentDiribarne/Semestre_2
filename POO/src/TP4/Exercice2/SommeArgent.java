package TP4.Exercice2;

public class SommeArgent {
    private int quantite;
    private String unite;

    public SommeArgent(int amount, String currency) {
        quantite=amount;
        unite=currency;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getUnite() {
        return unite;
    }

    public SommeArgent add(SommeArgent m) {
        return new SommeArgent(getQuantite()+m.getQuantite(), getUnite());
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof SommeArgent)) {
            return false;
        }

        SommeArgent c = (SommeArgent) o;

        return unite==c.unite && quantite== c.quantite;
    }
}
