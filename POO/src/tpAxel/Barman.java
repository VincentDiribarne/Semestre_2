package tpAxel;

public class Barman extends Humain {
	// attributs
	private String Coco = "Coco";
	private String nomBar = "Chez Momo";
	private String nom = "Momo";
	// constructeurs

	public Barman(String nom) {
		super(nom);
		nomBar = "chez" + nom;
	}

	public Barman(String nom, String boisson) {
		super(nom, boisson);
	}

	// méthodes

	public void servir() {
		parler("comme d'hab petit?");
		System.out.println("le barman sert lui sert un verre " + getBoisson());
	}

	public void sePresenter() {
		parler("Je suis le patron de " + nomBar + ". Je m'appelle " + nom
				+ ". J'ai 54 ans mais j peux toujours te mettre une bonne raclé " + Coco);
	}
}
