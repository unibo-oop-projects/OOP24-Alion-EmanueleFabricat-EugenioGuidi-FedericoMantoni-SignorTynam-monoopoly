package it.unibo.view.state;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.state.impl.ViewUnmortgageState;

public class TestUnmortgage extends JFrame{

    public static void main(String[] strg) {
        ViewUnmortgageState state;
        List<String> lista = new ArrayList<>();
        lista.add("ciao");
        lista.add("lol");
        List<String> lis = new ArrayList<>();
        lis.add("Franco");
        lis.add("Luca");
        List<Integer> cells = new LinkedList<>();
        cells.add(1);
        cells.add(0);
        final MainController controller = new MainControllerImpl(new MainModelImpl(lista), lis);        
        state = new ViewUnmortgageState(new MainView(controller, lista, lis));
    }

}
