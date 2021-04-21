package TpGraphe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static TpGraphe.GrapheValue.INFINI;


public class Test2 {

	public static void main(String[] args) 
	{
		System.out.println("Creation du graphe.");
		System.out.print("Nombre de sommets du graphe ? ");
		int[][] matVal = new int[4][4];
		int nb_sommets = 4;
		matVal = new int[4][4];
		matVal[0][2] = 3;
		matVal[3][0] = 3;
		matVal[3][1] = 2;
		matVal[1][2] = 1;

		matVal[0][0] = INFINI;
		matVal[0][1] = INFINI;
		matVal[0][3] = INFINI;
		matVal[1][1] = INFINI;
		matVal[1][0] = INFINI;
		matVal[1][3] = INFINI;
		matVal[2][0] = INFINI;
		matVal[2][1] = INFINI;
		matVal[2][2] = INFINI;
		matVal[2][3] = INFINI;
		matVal[3][2] = INFINI;
		matVal[3][3] = INFINI;

		GrapheValue g = new GrapheValueMatrice(nb_sommets, matVal);
		boolean boucle = true;
		
		while (boucle)
		{
			boolean boucle1 = true;
			while(boucle1)
			{
				System.out.println("\nPour visualiser le graphe, tapez 1.");
				System.out.println("Pour ajouter ou modifier un arc, tapez 2.");
				System.out.println("Pour supprimer un arc, tapez 3.");
				System.out.println("Pour ajouter un sommet, tapez 4.");
				System.out.println("Pour supprimer un sommet, tapez 5.");
				System.out.println("Pour creer un graphe en auto, tapez 6");
				System.out.println("Pour passer a la phase suivante, tapez 0.");
				System.out.print("Votre choix ? ");
				int choix = lireNombre();
				System.out.println("");
				switch (choix)
				{
				case 0 : 
					boucle1 = false;
					break;
				case 1 :
					affiche(g.matriceValuation());
					break;
				case 2:
					System.out.print("Sommet d'origine ? ");
					int dpt = lireNombre();
					if (dpt>g.nbSommets() || dpt<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					System.out.print("\nSommet d'arrivee ? ");
					int arr= lireNombre();
					if (arr>g.nbSommets() || arr<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					int val=g.valuationArc(dpt, arr);
					if (val== INFINI)
					{
						System.out.println("Cet arc va etre cree.");
						System.out.print("Valuation de l'arc ? ");
						g.ajoutArc(dpt, arr, lireNombre());
					}
					else
					{
						System.out.println("La valuation de cet arc est actuellement "+val);
						System.out.print("Nouvelle valuation ? ");
						g.changeValuation(dpt, arr, lireNombre());
					}
					System.out.println("");
					break;
				case 3 :
					System.out.print("Sommet d'origine ? ");
					dpt = lireNombre();
					if (dpt>g.nbSommets() || dpt<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					System.out.print("Sommet d'arrivee ? ");
					arr = lireNombre();
					if (arr>g.nbSommets() || arr<=0)
					{
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
						break;
					}
					if (g.supprimeArc(dpt, arr))
						System.out.println("L'arc a ete supprime.");
					else
						System.out.print("Cet arc ne fait partie du graphe.");
					break;
				case 4 :
					g.ajoutSommet();
					System.out.println("Sommet ajoute.");
					break;
				case 5 :
					System.out.print("Sommet a supprimer ? ");
					int som = lireNombre();
					if (g.supprimeSommet(som))
						System.out.println("\nSommet supprime.");
					else
						System.out.println("\nCe sommet ne fait pas partie du graphe.");
					break; 
				case 6 :

				}	
			}

		//algo de distance
		boolean boucle2 = true;
		while(boucle2)
		{
			System.out.println("\nPour visualiser le graphe, tapez 1.");
			System.out.println("Pour modifier le graphe, tapez 2.");
			System.out.println("Pour appliquer l'algorithme de Bellman-Ford, tapez 3.");
			System.out.println("Pour appliquer l'algorithme de Dijkstra, tapez 4.");
			System.out.println("Pour quitter, tapez 0.");
			System.out.print("Votre choix ? ");
			int choix = lireNombre();
			switch(choix)
			{
			case 0 : 
				boucle = false;
				boucle2 = false;
				break;
			case 1 :
				affiche(g.matriceValuation());
				break;
			case 2 :
				boucle2 = false;
				break;
			case 3 :

				GrapheValue gTest = new GrapheValueMatrice(nb_sommets, matVal);
				System.out.print("\nSommet de depart ? ");
				int sommet = lireNombre();
				try{AlgoDistance.bellmanFord(gTest, sommet);}
				catch(IllegalArgumentException e){e.printStackTrace();}
				break;
			case 4 :
				System.out.print("\nSommet de depart ? ");
				sommet = lireNombre();
				try{AlgoDistance.dijkstra(g, sommet);}
				catch(IllegalArgumentException e){e.printStackTrace();}
				break;
			}
		}
		}
		
	}

	private static int lireNombre()
	{
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in)); 
		boolean ok=false;
		int res=-1;
		while(!ok)
			{
			try 
				{			
				res=Integer.parseInt(buff.readLine());
				ok=true;
				} 
			catch (IOException e) {e.printStackTrace();}
			catch (NumberFormatException f)
				{
				System.out.print("\nCeci n'est pas un nombre, veuillez recommencer : ");
				}
			}
		return res;
	}
	
	private static void affiche(int[][] matrice)
	{
		int n = matrice.length;
		//recherche du plus long element
		int tailleMax = String.valueOf(n).length();
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (matrice[i][j]!= INFINI &&
						tailleMax < String.valueOf(matrice[i][j]).length())
					tailleMax = String.valueOf(matrice[i][j]).length();
		
		//affichage
		String ligne = blanc(tailleMax);
		for (int i=0; i<n; i++)
			ligne+=blanc(tailleMax+1-String.valueOf(i+1).length())+(i+1);
		System.out.println(ligne);
		for (int i=0; i<n; i++)
			{
			ligne =blanc(tailleMax-String.valueOf(i+1).length())+(i+1);
			for (int j=0; j<n; j++)
				if (matrice[i][j]== INFINI)
					ligne+=blanc(tailleMax)+"-";
				else
					ligne+=blanc(tailleMax+1-String.valueOf(matrice[i][j]).length())+matrice[i][j];
			System.out.println(ligne);
			}
		System.out.println("");
	}
	
	//construit une chaine de nb espace
	private static String blanc(int nb)
	{
		String res="";
		for (int i=0; i<nb; i++)
			res+=" ";
		return res; 
	}
}
