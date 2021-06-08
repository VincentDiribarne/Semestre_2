package games;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) {
        MysteryNumber game = new MysteryNumber();
        BestScores scores = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
        int nombre = game.play();
        if (scores.is_scoring(nombre)) {
            System.out.println("Votre nom ?");
            scores.add_score(nombre, Play.Lire());
        }
    }

    public static String Lire() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
