package main.components;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.function.Consumer;

public abstract class TelaBaseMenu extends JPanel {

    private final Image imagemFundo;
    protected final JPanel areaConteudo;

    protected TelaBaseMenu(String caminhoImagem, Consumer<String> aoNavegar) {
        URL urlImagem = getClass().getResource(caminhoImagem);
        this.imagemFundo = (urlImagem != null) ? new ImageIcon(urlImagem).getImage() : null;

        setLayout(new BorderLayout());
        add(new MenuLateralPanel(aoNavegar), BorderLayout.WEST);

        this.areaConteudo = new JPanel(new BorderLayout());
        this.areaConteudo.setOpaque(false);
        add(this.areaConteudo, BorderLayout.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagemFundo != null) {
            g.drawImage(imagemFundo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}