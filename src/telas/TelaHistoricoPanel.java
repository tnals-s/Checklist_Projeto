package telas;

import main.components.TelaBaseMenu;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class TelaHistoricoPanel extends TelaBaseMenu {

    public TelaHistoricoPanel(Consumer<String> aoNavegar) {
        super("/image/Principal.png", aoNavegar);

        // esse título é apenas de teste, pode ser removido
        JLabel titulo = new JLabel("Histórico", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(82, 107, 84));
        titulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        areaConteudo.add(titulo, BorderLayout.NORTH);
    }
}