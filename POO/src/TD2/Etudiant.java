package TD2;

public class Etudiant extends Personne {

    private int numero;

    public Etudiant(String nom, int numero) {
        super(nom);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String getNom() {
        return "(ETU) " + super.getNom();
    }
}
