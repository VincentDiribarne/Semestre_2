package TD1.Exercice2;

public class Etudiant {

    private String numero;
    private String nom;
    private String prenom;
    private String departement;
    private int nbAbsence;
    static int cptEtud = 0;
    //private int Annee = 2017;

    public Etudiant() {
        this(" ", " ", " ");
        nbAbsence = 0;
    }

    public Etudiant(String numero, String nom, String prenom) {
        this(numero, nom, prenom, " ");
    }

    public Etudiant(String numero, String nom, String prenom, String departement) {
        super();
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.departement = departement;
    }

    public void afficherinfo() {
        System.out.println("Numero : " +numero+ ", Nom : " +nom+ ", Prenom : " +prenom+ ", Departement : " +departement+ " et Nombre d'absences : " +nbAbsence);
    }

    public void modifNom(String nouveauNom) {
        nom = nouveauNom;
    }

    public void ajoutAbs() {
        nbAbsence++;
    }

    public void delAbs() {
        nbAbsence--;
    }

    public String toString() {
        return "Numero : "+ numero +", Nom : " +nom+ ", Prenom : " +prenom+ ", Departement : " +departement+ " et Nombre d'absences : " +nbAbsence;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public int getNbAbsence() {
        return nbAbsence;
    }

    public void setNbAbsence(int nbAbsence) {
        this.nbAbsence = nbAbsence;
    }
}
