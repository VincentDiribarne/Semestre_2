package TP1;

public class CowBoy extends Humain {

    private String adjectif;
    private int popularite;

    public static String BOISSON_PAR_DEFAUT = "Whisky";
    private static String ADJECTIF_PAR_DEFAUT = "vaillant";

    public CowBoy(String nom) {
        this(nom, BOISSON_PAR_DEFAUT, ADJECTIF_PAR_DEFAUT);
    }

    public CowBoy(String nom, String boisson, String adjectif) {
        super(nom, boisson);
        this.adjectif=adjectif;
        this.popularite=popularite;
    }

    public int liberer(Dame dame) {
        if (dame.isLibre() == true) {
            parler("Vous etes libre " +dame.tonNom()+ ", j'espere que vous m'inviterez chez vous un jour ?!");
            dame.estLiberePar(CowBoy.this);
            popularite++;
        } else {
            parler("Mais elle est libre, quel utilite ?");
        }
        return popularite;
    }

    public void tirer(Brigand brigand) {
        System.out.println("Le " +adjectif+ " " + tonNom()+ " tire sur " +brigand.tonNom()+ ". PAN !");
        parler("Prend ça, rascal !");
    }

    public int getPopularite() {
        return popularite;
    }

    public String getAdjectif() {
        return adjectif;
    }

    @Override
    public void sePresenter() {
        if (getPopularite() < 5) {
            parler("Oh salut, moi c'est " + tonNom()+ ", j'adore le " +quelEstTaBoissonFavorite()+ " et les gens disent que je suis "+getAdjectif()+ " et ma popularite est de seulement " +getPopularite()+ ", mais en fait, je suis inconnu dans ce village");
        } else {
            parler("Oh salut, moi c'est " + tonNom()+ ", j'adore le " +quelEstTaBoissonFavorite()+ " et les gens disent que je suis "+getAdjectif()+ " et ma popularite est de " +getPopularite()+ ". Wow, je suis populaire en fait");
        }
    }
}
