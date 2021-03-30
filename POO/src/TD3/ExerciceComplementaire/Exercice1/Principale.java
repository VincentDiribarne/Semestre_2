package TD3.ExerciceComplementaire.Exercice1;

public class Principale {

    public static void main(String[] args) throws DateException {




        try {
            Date uneDate = new Date(29, 2, 2021);
            System.out.println(uneDate);
        }
        catch (DateException e) {
            System.err.println(e.getMessage());
        }


        try {
            Date uneDateKO = new Date(29, 2, 2020);
            System.out.println(uneDateKO);
        }
        catch (DateException e) {
            System.err.println(e.getMessage());
        }

        //uneDate.demain();
    }
}
