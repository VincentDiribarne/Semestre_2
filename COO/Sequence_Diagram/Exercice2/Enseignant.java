package Sequence_Diagram.Exercice2;

public class Enseignant {
    public boolean recevoirCheque(Cheque cheque) {
        int montant= cheque.getMontant();
        return (montant>100);
    }
    
    public void demanderAide() {
    
    }
}


