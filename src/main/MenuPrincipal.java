package main;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    // gerenciador de telas ("Baralho de Cartas")
    private CardLayout cardLayout;
    private JPanel painelPrincipal;

    public MenuPrincipal() {
        // configurações básicas da janela (JFrame)
        setTitle("Taskflow - Checklist");
        setSize(1080, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // inicializando o CardLayout
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        // criando 4 telas básicas do fluxo
        criarTela1Lista();
        criarTela2Fila();
        criarTela3Pilha();
        criarTela4Ordenacao();

        // adiciona o painel principal na janela
        add(painelPrincipal);
    }

    public static void main(String[] args) {
        // força o Java 2D a renderizar tudo em escala 1:1 (100%), ignorando a escala do Windows
        System.setProperty("sun.java2d.uiScale", "1.0");

        // roda a interface gráfica na thread correta do Swing (segurança de threads)
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }
}