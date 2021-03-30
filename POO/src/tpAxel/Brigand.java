package tpAxel;

public class Brigand extends Humain implements VisagePale {
	// attributs
	private String look = "méchant";
	private int nbEnlevement;
	private int prime = 100;
	private boolean prison = false;

	// constructeurs

	public Brigand(String nom) {
		super(nom);
	}

	public Brigand(String nom, String boisson) {
		super(nom, boisson);
	}

	// méthodes

	public void kidnapper(Dames DameKidnappé) {
		parler("hehehe belle prise! je t es kidnappé " + DameKidnappé.tonNom()
				+ " tu es à moi allons nous amuser ailleurs!");
		DameKidnappé.kidnapper((HorsLaLoi) this);
		nbEnlevement++;

	}

	public void directionPrison(Cowboy hommeVaillant) {
		prison = true;
		parler("Dammed, tu m'as eu pour cette fois chacal! Je taurais " + hommeVaillant + "!");
	}

	public int récompense() {
		return prime;
	}

	@Override
	public String tonNom() {
		return super.tonNom() + " le " + look;
	}

	@Override
	public void sePresenter() {
		parler("Hoyé ! Je suis " + tonNom() + ". Et j'aime vous découper en morceaux!");
		parler("J'ai l'air " + look + " et j'ai kidnapper " + nbEnlevement + " dame(s)!");
		parler("Ma tête est mise à prix :" + prime + "$");
	}

	public void scalp(Indien peuRouge) {
		parler("Aïe ma tête !");
	}
}
