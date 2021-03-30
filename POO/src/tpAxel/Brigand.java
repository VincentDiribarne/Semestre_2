package tpAxel;

public class Brigand extends Humain implements VisagePale {
	// attributs
	private String look = "m�chant";
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

	// m�thodes

	public void kidnapper(Dames DameKidnapp�) {
		parler("hehehe belle prise! je t es kidnapp� " + DameKidnapp�.tonNom()
				+ " tu es � moi allons nous amuser ailleurs!");
		DameKidnapp�.kidnapper((HorsLaLoi) this);
		nbEnlevement++;

	}

	public void directionPrison(Cowboy hommeVaillant) {
		prison = true;
		parler("Dammed, tu m'as eu pour cette fois chacal! Je taurais " + hommeVaillant + "!");
	}

	public int r�compense() {
		return prime;
	}

	@Override
	public String tonNom() {
		return super.tonNom() + " le " + look;
	}

	@Override
	public void sePresenter() {
		parler("Hoy� ! Je suis " + tonNom() + ". Et j'aime vous d�couper en morceaux!");
		parler("J'ai l'air " + look + " et j'ai kidnapper " + nbEnlevement + " dame(s)!");
		parler("Ma t�te est mise � prix :" + prime + "$");
	}

	public void scalp(Indien peuRouge) {
		parler("A�e ma t�te !");
	}
}
