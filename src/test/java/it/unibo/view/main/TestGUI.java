package it.unibo.view.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.turn.impl.MainModelImpl;
import it.unibo.monoopoly.view.main.impl.MainView;

public class TestGUI extends JFrame{

    public static void main(String[] strg) {
        List<String> lista = new ArrayList<>();
        lista.add("ciao");
        lista.add("lol");
        List<String> lis = new ArrayList<>();
        lis.add("Franco");
        lis.add("Luca");
        final MainController controller = new MainControllerImpl(new MainModelImpl(lista), lis);
        new MainView(controller, lista, lis);
    }
}
