package TP1;

import java.util.ArrayList;

public class Brigand extends Humain{

    private String look;
    private int recompense = 100;
    private boolean prison;
    private int nbDameCapturee = 0;

    private ArrayList<Dame> dameEnlevees;

    public static String BOISSON_PAR_DEFAUT = "le tord-boyaux";
    public static String LOOK_PAR_DEFAUT = "mechant";

    public Brigand(String nom) {
        this(nom, BOISSON_PAR_DEFAUT, LOOK_PAR_DEFAUT);
    }

    public Brigand(String nom, String boisson, String look) {
        super(nom, boisson);
        this.look=look;
        this.recompense=recompense;
        dameEnlevees = new ArrayList<Dame>();
    }

    public int kidnapper(Dame dame) {
        if (dame.isLibre() == false) {
            parler("Ah ah, vous etes mienne " +dame.tonNom());
            dame.estKidnappeePar(Brigand.this);
            dameEnlevees.add(dame);
            nbDameCapturee++;
            parler("Je vaut desormais " +recompense(nbDameCapturee)+ " pesos \n");
        } else {
            parler("Je l'ai deja capturee, ou est l'utilite ?");
        }
        return nbDameCapturee;
    }

    public int recompense(int nbDameCapturee) {
        recompense = (nbDameCapturee * 100);
        return recompense;
    }

    public void estEmprisonnePar(CowBoy cowBoy) {
        if (!prison) {
            parler("Damned, je suis fait par " + cowBoy.tonNom() + ", tu m'as eu !\n");
            for (Dame dame : dameEnlevees) {
                cowBoy.liberer(dame);
            }
            prison=true;
        } else {
            parler("Je suis deja en prison");
        }
    }

    public boolean enPrison() {
        return prison;
    }

    public int getRecompense() {
        return recompense;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public String tonNom() {
        return super.tonNom()+ " le " +look;
    }

    @Override
    public void sePresenter() {
        parler("Hey, je suis " + tonNom() + " et j'aime " + quelEstTaBoissonFavorite());
        parler("J'ai l'air " +look+ " et j'ai deja capture " +nbDameCapturee+ " dames, AHAHAH");
        parler("Ma tete est mise a prix pour " +getRecompense()+ " pesos \n");
    }
}
