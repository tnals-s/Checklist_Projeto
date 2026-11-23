
#ifndef PILHA_H
#define PILHA_H

#include "tarefas.h"

// Registro de uma operacao
typedef struct {
    int codigoTarefa;
    int estadoAnterior;
} Operacao;

// Estrutura da pilha
typedef struct {
    Operacao itens[MAX];
    int topo;
} Pilha;

// Declaracao das funcoes
void inicializarPilha(Pilha *p);
int pilhaVazia(Pilha *p);
int pilhaCheia(Pilha *p);
void push(Pilha *p, Operacao operacao);
int pop(Pilha *p, Operacao *operacao);

#endif
