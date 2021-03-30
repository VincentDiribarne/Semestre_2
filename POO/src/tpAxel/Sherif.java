package tpAxel;

public class Sherif extends Cowboy{
	private int nbBrigand;
	private boolean arrêt=false;
	public Sherif(String nom) {
		super(nom);
		
	}
	public void arrete(Brigand Chacal) {
		parler("Au nom de la loi, je vous arrête misérable !");
		arrêt=true;
		if (arrêt==true) {
			nbBrigand=nbBrigand++;
		}
	}
	
	public void rechercher(HorsLaLoi Chacal) {
		parler("OYEZ OYEZ BRAVE GENS !! "+Chacal.récompense()+"$ à qui arrêtera "+Chacal.tonNom()+" mort ou vif !!");
	}
	
	public void sePresenter() {
		parler("Moi c'est "+tonNom()+" J'ai à mon actif " +nbBrigand+" brigand(s) arrêté!");
	}
	@Override
	public String tonNom(){
		return "Shérif "+super.tonNom();
		
	}
}
