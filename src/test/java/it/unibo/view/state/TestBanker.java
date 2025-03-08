package it.unibo.view.state;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.view.main.impl.MainViewImpl;
import it.unibo.monoopoly.view.state.impl.ViewBankerState;

/**
 * Test for {@link Banker} View.
 */
public class TestBanker extends JFrame {
    /**
     * 
     * @param strg initialization.
     */
    public static void main(final String[] strg) {
        ViewBankerState state;
        final List<String> lista = new ArrayList<>();
        lista.add("ciao");
        lista.add("lol");
        final List<String> lis = new ArrayList<>();
        lis.add("Franco");
        lis.add("Luca");
        final List<Integer> cells = new LinkedList<>();
        cells.add(1);
        cells.add(0);
        final MainController controller = new MainControllerImpl(new MainModelImpl(lista), lis);
        state = new ViewBankerState(new MainViewImpl(controller, lista, lis));
    }

}
