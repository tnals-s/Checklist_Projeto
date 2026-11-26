package main.components;

import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class MenuLateralPanel extends JPanel {

    public static final Color COR_BOTAO_PRINCIPAL = new Color(82, 107, 84);
    public static final Color COR_BOTAO_SAIR = new Color(176, 202, 162);

    public MenuLateralPanel(Consumer<String> aoNavegar) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        setPreferredSize(new Dimension(375, 800));
        setBorder(BorderFactory.createEmptyBorder(155, 20, 36, 20));

        BotaoArredondado btnCadastro = new BotaoArredondado("Cadastro", COR_BOTAO_PRINCIPAL, Color.WHITE);
        BotaoArredondado btnFocoDia = new BotaoArredondado("Foco do Dia", COR_BOTAO_PRINCIPAL, Color.WHITE);
        BotaoArredondado btnHistorico = new BotaoArredondado("Histórico", COR_BOTAO_PRINCIPAL, Color.WHITE);
        BotaoArredondado btnSair = new BotaoArredondado("Sair", COR_BOTAO_SAIR, Color.WHITE);

        add(btnCadastro);
        add(Box.createRigidArea(new Dimension(0, 14)));
        add(btnFocoDia);
        add(Box.createRigidArea(new Dimension(0, 14)));
        add(btnHistorico);

        add(Box.createVerticalGlue());
        add(btnSair);

        btnCadastro.addActionListener(e -> aoNavegar.accept("Cadastro"));
        btnFocoDia.addActionListener(e -> aoNavegar.accept("Foco"));
        btnHistorico.addActionListener(e -> aoNavegar.accept("Historico"));
        btnSair.addActionListener(e -> aoNavegar.accept("Inicio"));
    }
}