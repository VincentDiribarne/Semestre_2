#include <stdio.h>

void menu();
void score(int);
void init();
void malplaces();
void regles();

void menu() {
        printf("\n");
        printf("\t+-------------+\n"); 
        printf("\t| Mastermind  |\n");
        printf("\t+-------------+\n");
        printf("\t| 1 - Lancer  |\n");
        printf("\t| 2 - Règles  |\n" );
        printf("\t| 3 - Quitter |\n" );
        printf("\t+-------------+\n" );
}

void lancement() {
    printf("Vous venez de lancer le jeu, l'ordinateur choisi les couleurs");
    alpha = rand()%100;
    

}

void regles() {
    printf("\nVoici les règles du Mastermind :");
    printf("\n");
    printf("Vous avez 12 coups pour trouver la solution. \nVous devez trouver une suite de 5 couleurs, dans le bon ordre. \nA chaque fois, on vous indiquera à combien de coup vous êtes et si vous avez les bonnes couleurs ou la bonne suite.");
    printf("\nBonne chance !\n");
    main();
}

int main() {
    int reponse;
    menu();
    printf("Votre choix ? ");
    scanf("%d", &reponse);
    switch (reponse) {
    case 1:
        lancement();
        break;
    case 2 :
        regles();
        break;
    case 3 :
        printf("Vous quittez le programme");
        break;
    default:
        break;
    }
    return 0; 
}