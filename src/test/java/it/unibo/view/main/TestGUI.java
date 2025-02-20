package it.unibo.view.main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.view.main.impl.MainView;

public class TestGUI extends JFrame{

    public static void main(String[] strg) {
        List<String> listaCelle = new ArrayList<>();
        listaCelle.add("Vicolo corto");
        listaCelle.add("Vicolo stretto");
        List<String> listaPlayer = new ArrayList<>();
        listaPlayer.add("Franco");
        listaPlayer.add("Luca");
        listaPlayer.add("Gennaro");
        listaPlayer.add("Luigi");
        final MainController controller = new MainControllerImpl(new MainModelImpl(listaPlayer), listaPlayer);
        new MainView(controller, listaCelle, listaPlayer);
    }
}
