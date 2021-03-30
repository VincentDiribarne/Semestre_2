package TP1;

public class Histoire {

    public static void main(String[] args) {
        //Humain unautreHumain = new Humain("Baptiste", "la vodka");
        Dame uneDame = new Dame("Clement", "une binouze", "rose");
        Brigand unBrigand = new Brigand("Martin");
        CowBoy unCowBoy = new CowBoy("Vincent");
        Barman unBarman = new Barman("Trystan");
        Sherif unSherif = new Sherif("Maxime");
        CowBoy sacha = new Sherif("Sacha");

        //unautreHumain.sePresenter();
        unBrigand.sePresenter();
        uneDame.sePresenter();
        unCowBoy.sePresenter();
        unBarman.sePresenter();
        unSherif.sePresenter();

        unSherif.rechercher(unBrigand);
        unSherif.coffrer(unBrigand);
        unSherif.rechercher(unBrigand);
        sacha.sePresenter();
        /*On ne peut pas faire cette commande
        sacha.coffrer(unBrigand);*/

        //unBarman.servir(unBarman);
        //unautreHumain.boire();


        //uneDame.sePresenter();
        //uneDame.changerRobe("violette");

        //unBrigand.kidnapper(uneDame);
        //unCowBoy.liberer(uneDame);

        //unBrigand.estEmprisonnePar(unCowBoy);

    }
}
