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

	// méthodes

	public void kidnapper(HorsLaLoi enlevé) {
		if (libre = true) {
			parler("A l'aide! venez au secours d'une belle dame! Je me fais enlever par" + enlevé.tonNom() + "!");
			libre = false;
		} else {
			parler("...deux enlèvements sérieux?!?");
		}
	}

	public void liberer(Cowboy sauvé) {
		if (libre = false) {
			parler("vous m'avez sauvé, je vous en suis reconnaissante Monsieur " + sauvé.tonNom()
					+ "! (gros bisous plein d'amour)!");
			libre = true;
		} else {
			parler("Mais...je ne suis pas en dangé!");
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
		parler("Aïe ma tête !");
	}
}