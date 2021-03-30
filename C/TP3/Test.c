#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef enum {Cryptage, Decryptage} t_sens;

int majuscule(char c) {
    return (c >= 'A') && (c <= 'Z');
}

int minuscule(char c) {
    return (c >= 'a') && (c <= 'z');
}

char lettreauDebut(char c) {
    return majuscule(c) ? 'A' : 'a';
}

int main() {
    //char *msg = NULL;
    //char *resul = NULL;
    char msg[200];
    char resul[200];
    int cle;
    size_t lgMsg = 0;
    t_sens sens;

    printf("Entrez un message : ");
    fgets(msg, 200, stdin);
    //getline(&msg, &lgMsg, stdin);
    msg[strlen(msg)- 1] = '\0';

    printf("Chaine lue : %s, longueur : %ld\n", msg, strlen(msg));
    
    if(majuscule(msg[0])){
        printf("Le premier caractère est une majuscule \n");
    }

    if (minuscule(msg[0])) {
        printf("Le premier caractère est une minuscule \n");
    }
    
    printf("Clé de chiffrement ? \n");
    scanf("%d", &cle);
 
    resul[strlen(msg)] = '\0';
    
    if (strlen(msg) > 0) {
        int positionLettre,        // position de la lettre à crypter
        valeurCle = cle % 26 + 26, // valeur de la clé
        i;

        for (i = 0; i < strlen(msg); i++) {
            if (majuscule(msg[i]) || minuscule(msg[i])) {
                positionLettre = msg[i] - lettreauDebut(msg[i]);
                resul[i] = (positionLettre + valeurCle) % 26 + lettreauDebut(msg[i]);
            }
            else {
                resul[i] = msg[i];
            } 
        }
    }
    printf("\nRésultat : %s\n", resul);
    
    return 0;
}