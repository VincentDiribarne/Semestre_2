package tpAxel;



public class Cowboy extends Humain implements VisagePale {

	//attributs
	private int popularite=0;
	private String adjectif="vaillant";
		
	//constructeurs
	public Cowboy(String nom) {
		super(nom);
	}

	public Cowboy(String nom, String boisson) {
		super(nom,boisson);
	}

	//m�thodes
	public void r�putation() {
		popularite++;
	}

	public void tirer(HorsLaLoi laCible) {
		System.out.println(this.tonNom()+" tire! En plein dans le mille!");
		parler("Eh bien alors on joue avec les dames mtn?");
	}

	public void libererDame(Dames jolieDemoiselle) {
		jolieDemoiselle.liberer(this);
		parler("N'h�site pas � parler a tout le monde que c'est moi qui t es sauver;)!");
	}

	@Override
	public String tonNom() {
		return super.tonNom();
	}

	public void scalp(Indien peuRouge) {//il me semble pas qu'il y a besoin de mettre un indien en param�tre
		parler("A�e ma t�te !");
	}
}
