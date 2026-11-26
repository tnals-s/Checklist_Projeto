package telas;

import main.components.TelaBaseMenu;
import java.util.function.Consumer;

public class TelaFocoPanel extends TelaBaseMenu {

    public TelaFocoPanel(Consumer<String> aoNavegar) {
        super("/image/Principal.png", aoNavegar);
        // ... restante do seu código da tela de foco
    }
}