package tpAxel;

public class Dames extends Humain implements VisagePale {

	// attributs
	private String couleur;
	private boolean libre = true;

	// constructeurs
	public Dames(String nom, String boisson) {
		this(nom, boisson, "rouge");
	}

	public Dames(String nom, String boisson, String couleur) {
		super(nom, boisson);
		this.couleur = couleur;
	}

	// m�thodes

	public void kidnapper(HorsLaLoi enlev�) {
		if (libre = true) {
			parler("A l'aide! venez au secours d'une belle dame! Je me fais enlever par" + enlev�.tonNom() + "!");
			libre = false;
		} else {
			parler("...deux enl�vements s�rieux?!?");
		}
	}

	public void liberer(Cowboy sauv�) {
		if (libre = false) {
			parler("vous m'avez sauv�, je vous en suis reconnaissante Monsieur " + sauv�.tonNom()
					+ "! (gros bisous plein d'amour)!");
			libre = true;
		} else {
			parler("Mais...je ne suis pas en dang�!");
		}
	}

	public void changer(String couleur) {
		this.couleur = couleur;
		parler("Vous avez vu ma nouvelle robe! Ahah! Elle esst trop belle cette couleur " + couleur);
	}

	@Override
	public String tonNom() {
		return "Miss " + super.tonNom();
	}

	public void scalp(Indien peuRouge) {
		parler("A�e ma t�te !");
	}
}