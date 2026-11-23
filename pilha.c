
#include <stdio.h>
#include "pilha.h"

// Inicializar a pilha
void inicializarPilha(Pilha *p) {
    p->topo = -1;
}

// Verificar se a pilha esta vazia
int pilhaVazia(Pilha *p) {
    return p->topo == -1;
}

// Verificar se a pilha esta cheia
int pilhaCheia(Pilha *p) {
    return p->topo == MAX - 1;
}

// PUSH: inserir uma operacao na pilha
void push(Pilha *p, Operacao operacao) {

    if (pilhaCheia(p)) {
        printf("Erro: pilha cheia!\n");
        return;
    }

    p->topo++;

    p->itens[p->topo] = operacao;

    printf("Operacao registrada no historico!\n");
}

// POP: retirar a ultima operacao da pilha
int pop(Pilha *p, Operacao *operacao) {

    if (pilhaVazia(p)) {
        printf("Nao existem operacoes para desfazer!\n");
        return 0;
    }

    *operacao = p->itens[p->topo];

    p->topo--;

    return 1;
}
