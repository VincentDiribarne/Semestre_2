package tpAxel;

public class Sherif extends Cowboy{
	private int nbBrigand;
	private boolean arr�t=false;
	public Sherif(String nom) {
		super(nom);
		
	}
	public void arrete(Brigand Chacal) {
		parler("Au nom de la loi, je vous arr�te mis�rable !");
		arr�t=true;
		if (arr�t==true) {
			nbBrigand=nbBrigand++;
		}
	}
	
	public void rechercher(HorsLaLoi Chacal) {
		parler("OYEZ OYEZ BRAVE GENS !! "+Chacal.r�compense()+"$ � qui arr�tera "+Chacal.tonNom()+" mort ou vif !!");
	}
	
	public void sePresenter() {
		parler("Moi c'est "+tonNom()+" J'ai � mon actif " +nbBrigand+" brigand(s) arr�t�!");
	}
	@Override
	public String tonNom(){
		return "Sh�rif "+super.tonNom();
		
	}
}
