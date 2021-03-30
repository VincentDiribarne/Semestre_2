package TP1;

public class Dame extends Humain {

    private String couleurRobe;
    private boolean libre;

    private static String BOISSON_PAR_DEFAUT = "lait";

    public Dame(String nom, String couleurRobe) {
        this(nom, BOISSON_PAR_DEFAUT, couleurRobe);

    }

    public Dame(String nom, String boisson, String couleurRobe) {
        super(nom, boisson);
        this.couleurRobe=couleurRobe;


    }

    public boolean estKidnappeePar(Brigand nom) {
        if (!libre) {
            parler("AHHHH, j'ai ete capturee par " +nom.tonNom());
            libre = true;
        } else {
            parler("J'ai deja ete capturee, voyons !");
        }
        return libre;
    }

    public boolean estLiberePar(CowBoy nom) {
        if (libre) {
            parler("Oh merci, mon sauveur " +nom.tonNom()+ ", je parlerai de vous a mes copines ! \n");
            libre = false;
        } else {
            parler("Je ne suis pas capturee");
        }
       return libre;
    }

    public String changerRobe(String couleurRobe) {
        this.couleurRobe=couleurRobe;
        parler("Regarder ma nouvelle robe, elle est de couleur " +couleurRobe);
        System.out.println("");
        return couleurRobe;
    }

    public boolean isLibre() {
        return libre;
    }

    public String transformation(boolean libre) {
        String libre2;
        if (libre) {
            libre2 = "libre";
        } else {
            libre2 = "emprisonnee";
        }
        return libre2;
    }

    @Override
    public String tonNom() {
        return "Miss " + super.tonNom();
    }

    @Override
    public void sePresenter() {
        parler("Coucou, c'est moi " + tonNom()+ ", ma boisson favorite est " +quelEstTaBoissonFavorite()+ " et j'adore ma robe, enfin surtout sa couleur, le " +getCouleurRobe()+"\n");
    }

    public String getCouleurRobe() {
        return couleurRobe;
    }

}
