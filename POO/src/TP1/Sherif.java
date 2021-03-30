package TP1;

public class Sherif extends CowBoy {

    private int nbMechantCoffres;

    public Sherif(String nom) {
        super(nom);
    }

    public Sherif(String nom, String adjectif, String look) {
        super(nom, adjectif, look);
    }

    public void coffrer(Brigand brigand) {
        parler("Au nom de la loi, je vous arrete");
        brigand.estEmprisonnePar(Sherif.this);
    }

    public void rechercher(Brigand brigand) {
        System.out.println("Une pancarte est placardee en ville par le " + tonNom()+ " pour apprehender " +brigand.tonNom());
        if (!brigand.enPrison()) {
            parler("Oyez, Oyez, vile populace, je lance un avis de recherche pour " +brigand.tonNom()+ " " +brigand.getRecompense()+100+ " pour celui qui l'arretera, mort ou vif \n");
        } else {
            parler("Mais, il est en prison, l'utilite de mon action ? Je vais aller me pendre \n");
        }
    }

    @Override
    public void sePresenter() {
        super.sePresenter();
        parler("J'ai capture " +nbMechantCoffres+ " bandits, ces vils gredins \n");
    }

    @Override
    public String tonNom() {
        return "Sherif " +super.tonNom();
    }

    @Override
    public void parler(String texte) {
        System.out.println("("+ tonNom()+ ") - " +texte);
    }
}
