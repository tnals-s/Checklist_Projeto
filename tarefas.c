#include <stdio.h>
#include <string.h>
#include "tarefas.h"
#include "pilha.h"

Tarefa tarefas[MAX];
int quantidadeTarefas = 0;

void cadastrarTarefa() {

    if (quantidadeTarefas >= MAX) {
        printf("Limite de tarefas atingido!\n");
        return;
    }

    Tarefa nova;

    nova.codigo = quantidadeTarefas + 1;

    printf("Digite a descricao da tarefa: ");
    scanf(" %99[^\n]", nova.descricao);

    nova.concluida = 0;

    tarefas[quantidadeTarefas] = nova;

    quantidadeTarefas++;

    printf("Tarefa cadastrada com sucesso!\n");
}