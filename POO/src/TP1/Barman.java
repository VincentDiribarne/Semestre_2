package TP1;

public class Barman extends Humain {

    private String nomBar;

    private static String BOISSON_PAR_DEFAUT = "vin";


    public Barman(String nom) {
        super(nom, BOISSON_PAR_DEFAUT);
        this.nomBar="Chez " +nom;
    }

    public Barman(String nom, String nomBar) {
        super(nom, BOISSON_PAR_DEFAUT);
        this.nomBar=nomBar;
    }

    public void servir(Humain humain) {
        parler("Voici votre boisson, une verre de " +humain.quelEstTaBoissonFavorite()+ ".");
        humain.boire();
    }

    @Override
    public void parler(String texte) {
        super.parler(texte+ " Coco");
    }

    @Override
    public void sePresenter() {
        parler("Yo moi c'est " + tonNom()+ ", ma boisson favorite, c'est le " +quelEstTaBoissonFavorite()+ " et je possede un bar nomme '" +nomBar+ "'.");
        System.out.println("C'est un test");        
        System.out.println("");
    }
}
