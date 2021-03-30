package TD3.Exercice2;

import java.util.ArrayList;
import java.util.List;

public class LesAnimaux {

    private List<Animal> lesAnimaux;

    public LesAnimaux() {
        super();
        lesAnimaux = new ArrayList<>();
    }

    public void ajouter(Animal unAnimal) {
        lesAnimaux.add(unAnimal);
    }

    public void cacophonie() {
        System.out.println("Tous les animaux se mettent à crier : ");

        lesAnimaux.forEach(animal -> animal.cri());
    }

    public void AfficherParPatte(int nbPatte) {
        System.out.println("Voici les animaux avec "+ nbPatte +" pattes : ");
        for (Animal animal: lesAnimaux) {
            if (animal instanceof AnimalAvecPattes){
                AnimalAvecPattes animalAvecPattes = (AnimalAvecPattes) animal;
                if (animalAvecPattes.getNbPatte() == nbPatte) {
                    System.out.println("\t - " +animal.toString());
                }
            }
        }
    }

    @Override
    public String toString() {
        String res = "Voici les animaux de la liste : \n";

        for(Animal unAnimal: lesAnimaux) {
            res += "\t - " +unAnimal+ "\n";
        }
        return res;
    }
}
