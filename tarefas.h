#ifndef TAREFAS_H
#define TAREFAS_H

#define MAX 100

typedef struct {
    int codigo;
    char descricao[100];
    int concluida;
} Tarefa;

// Funcoes de gerenciamento
void cadastrarTarefa();
void listarTarefas();
void concluirTarefa();

#endif
