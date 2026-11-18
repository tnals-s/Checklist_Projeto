# Checklist_Projeto - Taskflow

Projeto acadêmico desenvolvido para a disciplina de **Estrutura de Dados**, com o objetivo de aplicar na prática Tipos Abstratos de Dados (TADs), algoritmos de busca e ordenação em uma aplicação desktop desenvolvida em **Java Swing**.

---

## Sobre o Projeto

O **TaskFlow** é um sistema de checklist e gerenciamento de tarefas projetado para organizar o fluxo de trabalho diário utilizando três estruturas de dados fundamentais:
* **Lista:** Catálogo geral de todas as tarefas cadastradas no sistema.
* **Fila (FIFO):** Esteira de foco diário, organizando a ordem de execução das tarefas.
* **Pilha (LIFO):** Histórico de ações realizadas, permitindo a funcionalidade de **Desfazer (Undo)**.

---

## Estrutura de Pastas e Divisão da Equipe

O código-fonte está organizado dentro de `src/` separando cada módulo por responsabilidade para facilitar o desenvolvimento colaborativo:
```text
src/
├── algoritmos/   # Implementação de busca e ordenação por prioridade/prazo
├── fila/         # Estrutura de Fila (FIFO) e painel de foco diário
├── lista/        # Estrutura de Lista e tela de cadastro/listagem geral
├── pilha/        # Estrutura de Pilha (LIFO) e painel de histórico/Undo
└── main/         # Classe principal (MenuPrincipal.java) e integração da interface Swing
```

## Tecnologias Utilizadas
Linguagem: Java

Interface Gráfica: Java Swing (javax.swing)

IDE: IntelliJ IDEA

Versionamento: Git & GitHub

## Como executar

1. Clone este repositório para a sua máquina:
git clone [https://github.com/tnals-s/checklist_projeto.git](https://github.com/tnals-s/checklist_projeto.git)
2. Abra a pasta checklist_projeto no IntelliJ IDEA.
3. Aguarde a indexação do projeto e execute o método main localizado em src/main/Main.java.

## Fluxo de Contribuição (Git)

Para manter a integridade do código principal (main):
1. Crie uma **branch exclusiva** para a sua tarefa/módulo antes de começar a codificar.
2. Trabalhe apenas dentro do pacote (package) designado à sua parte.
3. Realize commits descritivos e abra um **Pull Request** quando a funcionalidade estiver testada.
