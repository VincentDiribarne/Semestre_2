package Sequence_Diagram.Exercice2;

public class Etudiant {
    public void soudoyer(Enseignant ens) {
        Cheque c = new Cheque(500);
        boolean accepte=ens.recevoirCheque(c);
        if (accepte) {
            ens.demanderAide();
        }
    }

    public static void main() {
        Etudiant chris = new Etudiant();
        Enseignant pedro=new Enseignant();
        chris.soudoyer(pedro);
    }
}