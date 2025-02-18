package it.unibo.view.state;


import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.turn.impl.TurnImpl;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.state.impl.ViewCardState;


public class TestCard extends JFrame{

    public static void main(String[] strg) {
        ViewCardState state;
        List<String> lista = new ArrayList<>();
        lista.add("ciao");
        lista.add("lol");
        List<String> lis = new ArrayList<>();
        lis.add("Franco");
        lis.add("Luca");
        final MainController controller = new MainControllerImpl(new TurnImpl(lista), lis);        
        state = new ViewCardState(new MainView(controller, lista, lis));
    }
}