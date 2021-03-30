package tpAxel;


public class Indien extends Humain{
	private int nbPlume=0;
	public static final String BOISSON_DEFAUT="jus de racine";
	private String TOTEM_DEFAUT="coyote";
	private String Ugh="Ugh !";
	
	public Indien(String nom, String boisson, int nbPlume) {
		super(nom, boisson);
		this.nbPlume=nbPlume;
	}
	
	@Override
	public String tonNom() {
		return super.tonNom()+" "+nbPlume+" plume(s)";
	}
	public void scalp(VisagePale blanchounet) {
		System.out.println(blanchounet.tonNom()+" c'est fait scalper!!");
		nbPlume=nbPlume++;
		System.out.println(tonNom()+" a récuperé une plume !");
	}
	public void sePresenter() {
		parler("Je suis "+tonNom()+". Mon totem est "+TOTEM_DEFAUT+Ugh);
	}
}
