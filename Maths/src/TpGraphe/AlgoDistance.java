package TpGraphe;

/** La classe <code>AlgoDistance</code> contient deux m&eacute;thodes statiques
 * permettant d'effectuer des caculs de distances et de plus courts chemins sur un graphe
 * valu&eacute;. Les r&eacute;sultats (distances et tableaux des p&egrave;res) sont 
 * affich&eacute;s dans la console.  
 */
public class AlgoDistance {

	static int Lambda[];
	static Integer PI[];
	static boolean marque[];

	/** Calcule les distances dans un graphe valu&eacute; en utilisant l'algorithme
	 * de Dijkstra. Les r&eacute;sultats (distances et tableaux des p&egrave;res) sont 
	 * affich&eacute;s dans la console.  
	 * 
	 * @param g le graphe valu&eacute;
	 * @param sommet le sommet du graphe &agrave; partir duquel on calcule les distances
	 *
	 * @throws IllegalArgumentException si le graphe comporte des arcs de valuation n&eacute;gative.
	 */

	public static void initialisation(GrapheValue g, Integer sommet) {
		Lambda = new int[g.nbSommets()];
		PI = new Integer[g.nbSommets()];

		for (int i = 0; i < g.nbSommets(); i++) {
			Lambda[i] = GrapheValue.INFINI;
			PI[i] = null;
		}
		Lambda[sommet - 1] = 0;
	}
	public static void relacher(GrapheValue g, Integer i, Integer j) {
		if (Lambda[j] > (Lambda[i] + g.valuationArc(i + 1,j + 1))) {
			Lambda[j] = Lambda[i] + g.valuationArc(i + 1,j + 1);
			PI[j] = i + 1;
		}
	}

	public static void dijkstra(GrapheValue g, Integer sommet) { //Probleme avec Dijkstra
		initialisation(g, sommet);
		marque = new boolean[g.nbSommets()];

		for (int i = 0; i < g.nbSommets(); i++) {
			marque[i] = false;
		}

		System.out.println(tousSommetMarque(marque));
		while (tousSommetMarque(marque) != true) {
				for (int successeur : g.successeurs(sommet)) {
					if (marque[successeur] == false && Lambda[successeur - 1] > (Lambda[sommet - 1] + g.valuationArc(sommet,successeur))) {
						Lambda[successeur - 1] = Lambda[sommet - 1] + g.valuationArc(sommet,successeur);
						PI[successeur - 1] = sommet;
					}
				}

				int miniDistance = GrapheValue.INFINI;
				for (int m = 0; m < g.nbSommets(); m++) {
					if (marque[m] == false && Lambda[m] < miniDistance) {
						miniDistance = Lambda[m];
						sommet = m + 1;
					}
				}
				marque[sommet - 1] = true;

		}
		affiche(Lambda, PI);
	}

	public static boolean tousSommetMarque(boolean[] marque) {
		for (int i = 0; i < marque.length; i++) {
			if (marque[i] == false) {
				return false;
			}
		}
		return true;
	}

	/** Calcule les distances dans un graphe valu&eacute; en utilisant l'algorithme
	 * de Bellman-Ford. Les r&eacute;sultats (distances et tableaux des p&egrave;res) sont 
	 * affich&eacute;s dans la console.  
	 * 
	 * @param g le graphe valu&eacute;
	 * @param sommet le sommet du graphe &agrave; partir duquel on calcule les distances
	 *
	 * @throws IllegalArgumentException si le graphe comporte des circuits absorbants.
	 */	
	public static void bellmanFord(GrapheValue g, Integer sommet) {
		int[][] gTest = g.matriceValuation();
		initialisation(g, sommet);

		for (int k = 1; k < g.nbSommets(); k++) {
			for (int i = 0; i < g.nbSommets(); i++) {
				for (int j = 0; j < g.nbSommets(); j++) {
					if (gTest[i][j] != GrapheValue.INFINI && Lambda[i] != GrapheValue.INFINI) {
						relacher(g, i, j);
					}
				}
			}
		}
		affiche(Lambda, PI);
	}
	
	/** Affiche dans la console, sous forme d'un tableau, le contenu des deux arguments.
	 */
	private static void affiche(int[] distance, Integer[] peres) 
	{
		int n = distance.length;
		//recherche du plus long element
		int tailleMax = String.valueOf(n).length();
		for (int i=0; i<n; i++)
		{
			if (distance[i]!=GrapheValue.INFINI && 
					tailleMax < String.valueOf(distance[i]).length())
				tailleMax = String.valueOf(distance[i]).length();
			if (peres[i]!=null && 
					tailleMax < String.valueOf(peres[i]).length())	
				tailleMax = String.valueOf(peres[i]).length();
		}			
			
		//affichage
		String ligne = "sommets  ";
		for (int i=0; i<n; i++)
			ligne+=blanc(tailleMax+1-String.valueOf(i+1).length())+(i+1);
		System.out.println(ligne);
		ligne = "peres    ";
		for (int i=0; i<n; i++)
			if (peres[i]==null)
				ligne+=blanc(tailleMax)+"-";
			else
				ligne+=blanc(tailleMax+1-String.valueOf(peres[i]).length())+peres[i];
		System.out.println(ligne);
		ligne = "distances";
		for (int i=0; i<n; i++)
			if (distance[i]==GrapheValue.INFINI)
				ligne+=blanc(tailleMax)+"-";
			else
				ligne+=blanc(tailleMax+1-String.valueOf(distance[i]).length())+distance[i];
		System.out.println(ligne);
		
		System.out.println("");
	}
		
	/**construit une chaine comportant nb espaces*/
	private static String blanc(int nb)
	{
		String res="";
		for (int i=0; i<nb; i++)
			res+=" ";
		return res; 
	}

}
