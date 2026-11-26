package telas;

import main.components.TelaBaseMenu;
import java.util.function.Consumer;

public class TelaCadastroPanel extends TelaBaseMenu {

    public TelaCadastroPanel(Consumer<String> aoNavegar) {
        super("/image/Principal.png", aoNavegar);
        // ... restante do seu código da tela de cadastro
    }
}