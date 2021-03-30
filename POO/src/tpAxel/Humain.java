package tpAxel;

public class Humain {
	//attributs
	private String nom;
	private String boisson;
	protected static final String BOISSON_DEFAUT="eau";
	private int nbEnlevement;
	private int prime;
	
	//constructeurs
	public Humain(String nom) {
		this(nom, BOISSON_DEFAUT);
	}
	public Humain(String nom, String boisson) {
		this.nom=nom;
		this.boisson=boisson;
	}
	//accesseurs
	public String tonNom() {
		return nom;
	}
	public String getBoisson() {
		return boisson;
	}
	public int getnbEnlevement() {
		return nbEnlevement;
		
	}
	//méthode
	public void parler(String texte) {
		System.out.println("("+tonNom()+")-"+texte);
	}
	
	public void sePresenter() {
		parler("hoyé! moi c'est "+tonNom()+". J'aime "+boisson+".");
		
	}
	
	public void boire() {
		parler("OH OH mais que vois-je! un bon gros verre de"+boisson+" rien que pour moi! (AVALE!)");
	}
	public int getPrime() {
		return prime;
	}
	public void setPrime(int prime) {
		this.prime = prime;
	}
}
