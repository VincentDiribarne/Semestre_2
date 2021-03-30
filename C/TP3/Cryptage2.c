#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int sensMain;
    char msgMain[200];
    char resul[200];
    sensMain = sensFonction();
    msgMain[200] = message();
    if (sensMain == 1){
        printf("\nBienvenue dans le Cryptage");
        printf("%s", &msgMain[200]);
        resul = Cryptage(msgMain);
        printf("%s", &resul);
    }
    else if (sensMain == 2){
        printf("\nBienvenue dans le Décryptage");
        resul = Cryptage(msgMain);
        } else {
        printf("\nVous vous etes trompe de nombre");
    }
    return 0;
}

char message() {
    char msg[200];
    printf("Entrez un message : ");
    fgets(msg, 200, stdin);
    msg[strlen(msg)- 1] = '\0';
    printf("\nChaine lue : %s, longueur : %ld\n", msg, strlen(msg));
    return msg;
}

int cle() {
    int cle;
    printf("Votre clé de Cryptage ?");
    scanf("&d", &cle);
    return cle;
}

int sensFonction() {
    int sens;
    printf("Quel sens voulez-vous ? \n");
    printf("1 --> Cryptage, 2 --> Decryptage\n");
    scanf("%d", &sens);
    return sens;
}

char Cryptage(char msg) {
    printf("Test");
    return "ok";
}