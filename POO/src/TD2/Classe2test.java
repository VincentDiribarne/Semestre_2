package TD2;

public class Classe2test {

    public static void main(String[] args) {

        //Q1
        Personne unePersonne = new Personne("Anonyme");
        //Q9
        Etudiant unEtudiant = new Etudiant("Anonyme", 42);
        unEtudiant.setNumero(7);
        System.out.println(unEtudiant);

        Etudiant unautreEtudiant = new Etudiant("Didier", 35);
        System.out.println(unautreEtudiant);
    }

}
