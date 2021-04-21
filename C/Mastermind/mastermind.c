#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <math.h>


int coucouCestMoileMenu(int *redondance);

void menu(int redondance) {
	if (redondance == 1) {
		printf("\n");
        printf("\t+-----------------+\n"); 
        printf("\t|    Mastermind   |\n");
        printf("\t+-----------------+\n");
        printf("\t| 1 - Lancer      |\n");
        printf("\t| 2 - Regles      |\n");
		printf("\t| 3 - Redondance  |\n");
        printf("\t| 4 - Quitter     |\n");
        printf("\t+-----------------+\n");
		printf("\n\nRedondance activee\n");
	} else {
		printf("\n");
        printf("\t+-----------------+\n"); 
        printf("\t|    Mastermind   |\n");
        printf("\t+-----------------+\n");
        printf("\t| 1 - Lancer      |\n");
        printf("\t| 2 - Regles      |\n");
		printf("\t| 3 - Redondance  |\n");
        printf("\t| 4 - Quitter     |\n");
        printf("\t+-----------------+\n");
		printf("\n\nRedondance desactivee\n");
	}      
}

void choisirSolution(int t[5], int redondance) {
	srand((unsigned long) time(NULL));   // Lancement
	int memory = 0;
	for (int i = 0 ; i < 5 ; i++){
		if (redondance == 1) {
			t[i] = (rand() % 9)+1; //donne un nombre aléatoire
		} else {
			t[i]=0;
			memory = (rand() % 9)+1;
			for(int j = 0 ; j < 5 ; j++){
				if (t[j] == memory)  {
					i--;
					memory = -1;
					break;
				}
			}
			if (memory != -1) {
				t[i] = memory;
			}
		}
	}
}

void saisirEssai(int e[5]) {
	int i;

	for (i = 0; i < 5; i++) {
		scanf("%1d", &e[i]);
	}
}

int bienPlaces(int S[5], int E[5]) {
    int n = 0;
		for (int i = 0 ; i<5 ; i++){
		 if(S[i] == E[i]){
			 n++;
		 }
	 }
    return n;
}


int malPlaces(int S[5], int E[5]) {
	int n = 0;
	int t[10];  //Ce tableau va contenir les valeurs de notre code secret
	for (int i = 0 ; i<10 ; i++){
		t[i]=0;
	}
	for (int i = 0 ; i<5 ; i++) {
		t[S[i]]++;
	}
	for (int i = 0 ; i<5 ; i++) {
	 	if (S[i] != E[i] && t[E[i]] > 0) {
			n++;
			t[E[i]]--;
	 	} else if (S[i] == E[i] && t[S[i]] > 0) {
			t[S[i]]--;
		}
	}
	return n;
}

void afficherResultat(int bp, int mp) {
	printf("Voici les biens places %d, et les mals places %d\n",bp,mp);
}

void lancement(int redondance) {
	int affCodeSecret;
    int secret[5];
	int essay[5];
	char chararr[99];
	choisirSolution(secret, redondance);

	printf("Voulez vous afficher le code secret ? (1 --> Oui, autre --> Non)\n");
	scanf("%d", &affCodeSecret);
	
	if (affCodeSecret == 1) {
		printf("\nLe code secret est : ");
		for(int i = 0 ; i < 5 ; i++) {
			printf("%d", secret[i]);
		}
	}
	
	printf("\nCode secret : XXXXX");

	printf("\n\n");
	printf("Entrez votre essai :\n");
	int index=1;
	while(index <= 12) {
		printf("  %d - ", index);
		scanf("%s", &chararr);
		for(int i = 0 ; i < 5 ; i++){
			essay[i]=(int)chararr[i] - '0';
		}
	    afficherResultat(bienPlaces(secret,essay),malPlaces(secret,essay));
		if(bienPlaces(secret,essay) == 5)break;
		index++;
	}
	
	if (index <= 12) {
		if (index <= 5) {
			printf("\n\nBravo, tu es tres fort !\n");
			printf("Tu as reussi en %d essais\n\n", index);
		} else if (index > 5 && index < 10) {
			printf("\n\nBravo, tu es OK, j'ai deja vu mieux...\n");
			printf("Tu as reussi en %d essais\n\n", index);
		} else {
			printf("\n\nPlus de 10, même un enfant de primaire ferait mieux quand même\n");
			printf("Tu as reussi en %d essais\n\n", index);
		}
		
	} else {
		printf("\nDommage, c'est perdu...\n");
		printf("Le code secret etait : ");
		for(int i = 0 ; i < 5 ; i++){
			printf("%d", secret[i]);
		} 
		printf("\n\n");
	}

	
}

int coucouCestMoileMenu(int *redondance) {
	int reponse, rejouer;
    menu(*redondance);
    printf("\nVotre choix ? ");
    scanf("%d", &reponse);
    switch (reponse) {
    case 1:
        lancement(*redondance);
		printf("Voulez vous rejouer ? (1 --> rejouer, autre nombre --> quitter)");
		scanf("%d", &rejouer);

		if (rejouer != 1) {
			reponse = 4;
		} 
        break;

    case 2 :
        printf("\nVoici les regles du Mastermind :");
    	printf("\n");
    	printf("Vous avez 12 coups pour trouver la solution. \nVous devez trouver une suite de 5 couleurs, dans le bon ordre. \nA chaque fois, on vous indiquera si vous avez les bonnes couleurs ou la bonne suite.");
    	printf("\nBonne chance !\n");
		break;
		
    case 3 :
		if (*redondance == 0) {
			*redondance = 1;
		} else {
			*redondance = 0;
		}
        break;

	case 4 :
		printf("Vous quittez le programme");
		break;
    default:
		printf("Erreur !");
		break;
        
    }
	return (reponse == 4) ? 0 : 1;
}

//Programme principal
int main() {
	int redondance = 0;
	while (coucouCestMoileMenu(&redondance));
	return 0; 
}