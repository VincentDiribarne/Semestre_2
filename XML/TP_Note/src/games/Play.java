package games;

import java.util.Scanner;

public class Play {

    public static void main(String[] args) throws Exception {
        MysteryNumber game = new MysteryNumber();
        BestScores scores = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
        game.Menu();
    }

    public static String Lire() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
