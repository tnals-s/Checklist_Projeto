
// LISTA DE TAREFAS

let tarefas = JSON.parse(localStorage.getItem("tarefas")) || [];

let filtroAtual = "todas";

// DATA ATUAL
const data = new Date();

document.getElementById("dataAtual").textContent =
    data.toLocaleDateString("pt-BR", {
        weekday: "long",
        day: "numeric",
        month: "long",
        year: "numeric"
    });

// SALVAR TAREFAS
function salvarTarefas() {
    localStorage.setItem("tarefas", JSON.stringify(tarefas));
}

// CADASTRAR TAREFA
document.getElementById("formTarefa").addEventListener("submit", function(event) {

    event.preventDefault();

    const campo = document.getElementById("descricaoTarefa");
    const descricao = campo.value.trim();

    if (descricao === "") return;

    const novaTarefa = {
        codigo: tarefas.length > 0
            ? Math.max(...tarefas.map(t => t.codigo)) + 1
            : 1,
        descricao: descricao,
        concluida: false
    };

    tarefas.push(novaTarefa);

    salvarTarefas();

    campo.value = "";

    atualizarPagina();
});

// LISTAR TAREFAS
function listarTarefas() {

    const lista = document.getElementById("listaTarefas");

    lista.innerHTML = "";

    const filtradas = tarefas.filter(tarefa => {

        if (filtroAtual === "pendentes") {
            return !tarefa.concluida;
        }

        if (filtroAtual === "concluidas") {
            return tarefa.concluida;
        }

        return true;
    });

    if (filtradas.length === 0) {
        lista.innerHTML = `
            <div class="empty-state">
                <span>✦</span>
                <h3>Nenhuma tarefa encontrada</h3>
                <p>Adicione ou selecione outra categoria.</p>
            </div>
        `;
        return;
    }

    filtradas.forEach(tarefa => {

        const item = document.createElement("div");

        item.className = tarefa.concluida
            ? "task-item completed"
            : "task-item";

        const checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        checkbox.checked = tarefa.concluida;

        checkbox.addEventListener("change", function() {
            alterarStatus(tarefa.codigo);
        });

        const descricao = document.createElement("span");
        descricao.className = "task-description";
        descricao.textContent = tarefa.descricao;

        const excluir = document.createElement("button");
        excluir.className = "delete-button";
        excluir.textContent = "✕";
        excluir.title = "Excluir tarefa";

        excluir.addEventListener("click", function() {
            excluirTarefa(tarefa.codigo);
        });

        item.appendChild(checkbox);
        item.appendChild(descricao);
        item.appendChild(excluir);

        lista.appendChild(item);
    });
}

// ALTERAR STATUS
function alterarStatus(codigo) {

    const tarefa = tarefas.find(t => t.codigo === codigo);

    if (tarefa) {
        tarefa.concluida = !tarefa.concluida;
        salvarTarefas();
        atualizarPagina();
    }
}

// EXCLUIR TAREFA
function excluirTarefa(codigo) {

    tarefas = tarefas.filter(t => t.codigo !== codigo);

    salvarTarefas();

    atualizarPagina();
}

// ATUALIZAR INDICADORES
function atualizarResumo() {

    const total = tarefas.length;

    const concluidas = tarefas.filter(t => t.concluida).length;

    const pendentes = total - concluidas;

    const porcentagem = total > 0
        ? Math.round((concluidas / total) * 100)
        : 0;

    document.getElementById("totalTarefas").textContent = total;

    document.getElementById("totalPendentes").textContent = pendentes;

    document.getElementById("totalConcluidas").textContent = concluidas;

    document.getElementById("porcentagem").textContent = porcentagem + "%";

    document.getElementById("barraProgresso").style.width =
        porcentagem + "%";
}

// FILTROS
document.querySelectorAll(".tab").forEach(botao => {

    botao.addEventListener("click", function() {

        filtroAtual = this.dataset.filter;

        document.querySelectorAll(".tab").forEach(tab => {
            tab.classList.remove("active");
        });

        this.classList.add("active");

        listarTarefas();
    });
});

// MENU LATERAL
document.querySelectorAll(".menu-item").forEach(botao => {

    botao.addEventListener("click", function(event) {

        event.preventDefault();

        document.querySelectorAll(".menu-item").forEach(item => {
            item.classList.remove("active");
        });

        this.classList.add("active");

        const pagina = this.dataset.page;

        if (pagina === "pendentes") {
            filtroAtual = "pendentes";
        } else if (pagina === "concluidas") {
            filtroAtual = "concluidas";
        } else {
            filtroAtual = "todas";
        }

        document.querySelectorAll(".tab").forEach(tab => {
            tab.classList.toggle(
                "active",
                tab.dataset.filter === filtroAtual
            );
        });

        listarTarefas();
    });
});

// ATUALIZAR A PAGINA
function atualizarPagina() {
    atualizarResumo();
    listarTarefas();
}

// INICIALIZAR
atualizarPagina();
