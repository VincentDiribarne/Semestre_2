package games;

public class MysteryNumber {

	public static final int ABORT_VALUE = Integer.MAX_VALUE ;
	private int value;

	public int Difficulte() {
		char sChoice;
		// Nombre mystère - jeux et meilleurs scores
		BestScores scores = new BestScores();

		Menu();
		// Récupération saisie utilisateur
		sChoice = Lire.c();
		// Analyse saisie utilisateur
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
				scores.affichageScore();
				Difficulte();
				break;
			default:
				System.out.println("Saisie incorrecte !!!");
				break;
		}
		return value;
	}

	public void Menu() {
		System.out.println("\nMenu :");
		System.out.println("\tf - Facile");
		System.out.println("\tn - Normal");
		System.out.println("\td - Difficile ");
		System.out.println("\ts - Score");
		System.out.println("\tq - Quitter");
		System.out.print("Votre choix : ");
	}

	public int play() {
		int max_value = Difficulte();
	    int score=0;
	    int value=0;
	    int mystery = new Double(max_value * Math.random() +1).intValue();
	    System.out.println("Trouvez le nombre mystere (entre 1 et " + max_value + ", 0 pour abandon) : ");
	    while (value != mystery) {
		    /* Le joueur tente sa chance */
		    System.out.println("Entrez un nombre (#" + score + ") : ");
		    value=Lire.i();
		    /* abandon ? */
		    if (value == 0)
		    	return MysteryNumber.ABORT_VALUE;
		    /* valide son essai, ou oriente sa recherche */
		    else if (value > mystery)
		    	  System.out.println("Trop grand");
		    else if (value < mystery)
		    	  System.out.println("Trop petit");
		    score++;
	    }
	    
	    /* Get it ! */
	    System.out.println("Bravo, vous avez gagné en " + score + " coups");
	    return score;
	}
}
