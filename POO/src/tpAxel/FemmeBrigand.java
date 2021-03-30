package tpAxel;

public class FemmeBrigand extends Dames implements HorsLaLoi{

	private int nbEnlevement = 0;
	private boolean prison = false;
	
	public FemmeBrigand(String nom, String boisson) {
		super(nom, boisson);
		
	}

	@Override
	public int récompense() {
		
		return getPrime();
	}

	@Override
	public void kidnapper(Dames dameKidnappe) {
		parler("hehehe belle prise! je t es kidnappé " + dameKidnappe.tonNom()
		+ " tu es à moi allons nous amuser ailleurs!");
		dameKidnappe.kidnapper((HorsLaLoi) this);
		nbEnlevement++;
		
	}

	@Override
	public void directionPrison(Cowboy hommeVaillant) {
		prison = true;
		parler("Dammed, tu m'as eu pour cette fois chacal! Je taurais " + hommeVaillant + "!");
		
	}
}
