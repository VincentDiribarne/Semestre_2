package TP1;

import java.util.ArrayList;

public class Ripoux extends Sherif implements HorsLaLoi{

    private String look;
    private int recompense = 100;
    private boolean prison;
    private int nbDameCapturee = 0;

    private ArrayList<Dame> dameEnlevees;

    public Ripoux(String nom) {
        super(nom);
        dameEnlevees = new ArrayList<Dame>();
    }

    @Override
    public int kidnapper(Dame dame) {
        if (dame.isLibre() == false) {
            parler("Ah ah, vous etes mienne " +dame.tonNom());
            dame.estKidnappeePar(this);
            dameEnlevees.add(dame);
            nbDameCapturee++;
            parler("Je vaut desormais " +recompense(nbDameCapturee)+ " pesos \n");
        } else {
            parler("Je l'ai deja capturee, ou est l'utilite ?");
        }
        return nbDameCapturee;
    }

    @Override
    public int recompense(int nbDameCapturee) {
        recompense = (nbDameCapturee * 100);
        return recompense;
    }

    @Override
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
    public void sePresenter() {
        parler("Hey, je suis " + tonNom() + " et j'aime " + quelEstTaBoissonFavorite());
        parler("Mettez les mains en l'air, je vous arrête");
        parler("C'est faux, vasi tire toi, plus vite que ça, je suis dans ton camp");
    }
}
