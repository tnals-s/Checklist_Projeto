package main.components;

import javax.swing.*;
import java.awt.*;

public class BotaoArredondado extends JButton {
    private final Color corFundo;

    public BotaoArredondado(String texto, Color corFundo, Color corTexto) {
        super(texto);
        this.corFundo = corFundo;

        Dimension tamanho = new Dimension(320, 54);
        setPreferredSize(tamanho);
        setMaximumSize(tamanho);
        setMinimumSize(tamanho);
        setAlignmentX(Component.CENTER_ALIGNMENT);

        setFont(new Font("Arial", Font.BOLD, 16));
        setForeground(corTexto);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arco = getHeight();
        g2.setColor(getModel().isPressed() ? corFundo.darker() : corFundo);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arco, arco);

        g2.dispose();
        super.paintComponent(g);
    }
}