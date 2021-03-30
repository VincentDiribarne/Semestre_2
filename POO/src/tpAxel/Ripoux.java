package tpAxel;


public class Ripoux extends Sherif implements HorsLaLoi{

	public Ripoux(String nom) {
		super(nom);
	}

	@Override
	public int récompense() {
		return getPrime();
	}

	@Override
	public void kidnapper() {
		// TODO Auto-generated method stub
	}

	@Override
	public void directionPrison() {
		// TODO Auto-generated method stub
	}

}
