package games;

public class MysteryNumber {

    private int value;
    private BestScores mystery_level1_sc = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
    private BestScores mystery_level2_sc = new BestScores(BestScores.E_ORDER_BY.ASC, 5);
    private BestScores mystery_level3_sc = new BestScores(BestScores.E_ORDER_BY.ASC, 5);

    private String saveFile1 = "data/loadJsonFacile.json";
    private String saveFile2 = "data/loadJsonMoyen.json";
    private String saveFile3 = "data/loadJsonDifficile.json";

    private String saveFile1XML = "data/loadXMLFacile.xml";
    private String saveFile2XML = "data/loadXMLMoyen.xml";
    private String saveFile3XML = "data/loadXMLDifficile.xml";

    public void Difficulte() throws Exception {
        char sChoice;
        sChoice = Lire.c();
        switch (sChoice) {
            case 'q': // Choix 'q' : Fin
                System.exit(1);
                break;
            case 'f':
                value = 10;
                break;
            case 'n':
                value = 100;
                break;
            case 'd':
                value = 1000;
                break;
            case 's':
                System.out.println("\nSelectionnez un niveau : \n");
                System.out.println("1 - Niveau 1");
                System.out.println("2 - Niveau 2");
                System.out.println("3 - Niveau 3");
                int iScoreChoice = Lire.i();
                switch (iScoreChoice) {
                    case 1:
                        try {
                            mystery_level1_sc.load_json(saveFile1);
                        } catch (Exception e) {
                            System.out.println("Aucun fichier de sauvegarde existe ! ");
                        }
                        break;
                    case 2:
                        try {
                            mystery_level2_sc.load_json(saveFile2);
                        } catch (Exception e) {
                            System.out.println("Aucun fichier de sauvegarde existe ! ");
                        }
                        break;
                    case 3:
                        try {
                            mystery_level3_sc.load_json(saveFile3);
                        } catch (Exception e) {
                            System.out.println("Aucun fichier de sauvegarde existe ! ");
                        }
                        break;
                }
                Menu();
                break;
            default:
                System.out.println("Saisie incorrecte !!!");
                break;
        }
        play(value);
    }

    public void Menu() throws Exception {
        System.out.println("\nMenu :");
        System.out.println("\tf - Facile");
        System.out.println("\tn - Normal");
        System.out.println("\td - Difficile ");
        System.out.println("\ts - Score");
        System.out.println("\tq - Quitter");
        System.out.print("Votre choix : ");
        Difficulte();
    }

    public void play(int max_value) throws Exception {
        int score = 0;
        int value = 0;
        int mystery = new Double(max_value * Math.random() + 1).intValue();
        System.out.println("Trouvez le nombre mystere (entre 1 et " + max_value + ", 0 pour abandon) : ");
        while (value != mystery) {
            /* Le joueur tente sa chance */
            System.out.println("Entrez un nombre (#" + score + ") : ");
            value = Lire.i();

            if (value == 0) {
                Menu();
            }

            if (value > mystery) {
                System.out.println("Trop grand");
            }

            if (value < mystery) {
                System.out.println("Trop petit");
            }
            score++;
        }

        System.out.println("Bravo, vous avez gagne en " + score + " coups");
        int tempScore = score;
        System.out.println("Votre nom ?");
        String nom = Play.Lire();
        switch (max_value) {
            case 10:
                if (mystery_level1_sc.is_scoring(tempScore)) {
                    mystery_level1_sc.add_score(tempScore, nom);
                    mystery_level1_sc.save_xml(saveFile1XML);
                    mystery_level1_sc.save_json(saveFile1);
                }
                break;

            case 100:
                if (mystery_level2_sc.is_scoring(tempScore)) {
                    mystery_level2_sc.add_score(tempScore, nom);
                    mystery_level2_sc.save_xml(saveFile2XML);
                    mystery_level2_sc.save_json(saveFile2);
                }
                break;

            case 1000:
                if (mystery_level3_sc.is_scoring(tempScore)) {
                    mystery_level3_sc.add_score(tempScore, nom);
                    mystery_level3_sc.save_xml(saveFile3XML);
                    mystery_level3_sc.save_json(saveFile3);
                }
                break;
        }
        Menu();
    }
}
