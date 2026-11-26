package main;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.function.Consumer;

import main.components.*;
import telas.TelaCadastroPanel;
import telas.TelaFocoPanel;
import telas.TelaHistoricoPanel;

public class MenuPrincipal extends JFrame {

    // gerenciador de telas ("Baralho de Cartas")
    private final CardLayout cardLayout;
    private final JPanel painelPrincipal;

    public MenuPrincipal() {
        // configurações básicas da janela (JFrame)
        setTitle("Taskflow - Checklist");
        setSize(1080, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // inicializando o CardLayout
        cardLayout = new CardLayout();
        painelPrincipal = new JPanel(cardLayout);

        Consumer<String> navegarPara = destino -> cardLayout.show(painelPrincipal, destino);

        criarTelaInicial(navegarPara);

        painelPrincipal.add(new TelaPrincipalPadrao(navegarPara), "Ordenacao");
        painelPrincipal.add(new TelaCadastroPanel(navegarPara), "Cadastro");
        painelPrincipal.add(new TelaFocoPanel(navegarPara), "Foco");
        painelPrincipal.add(new TelaHistoricoPanel(navegarPara), "Historico");

        // adiciona o painel principal na janela
        add(painelPrincipal);
    }

    private void criarTelaInicial(Consumer<String> navegarPara) {
        JPanel telaInicio = new JPanel() {
            private final Image imagemFundo;

            {
                URL url = getClass().getResource("/image/TASKFLOW.png");
                imagemFundo = (url != null) ? new ImageIcon(url).getImage() : null;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (imagemFundo != null) {
                    g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        telaInicio.setLayout(null);

        JButton btnIniciar = new JButton();
        btnIniciar.setOpaque(false);
        btnIniciar.setContentAreaFilled(false);
        btnIniciar.setBorderPainted(false);
        btnIniciar.setFocusPainted(false);
        btnIniciar.setBounds(430, 400, 300, 100);
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIniciar.addActionListener(e -> navegarPara.accept("Ordenacao"));

        telaInicio.add(btnIniciar);
        painelPrincipal.add(telaInicio, "Inicio");
    }

    private static class TelaPrincipalPadrao extends TelaBaseMenu {
        public TelaPrincipalPadrao(Consumer<String> aoNavegar) {
            super("/image/Principal.png", aoNavegar);
        }
    }

    public static void main(String[] args) {
        System.setProperty("sun.java2d.uiScale", "1.0");

        SwingUtilities.invokeLater(() -> new MenuPrincipal().setVisible(true));
    }
}