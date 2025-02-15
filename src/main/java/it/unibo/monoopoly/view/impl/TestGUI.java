package it.unibo.monoopoly.view.impl;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.controller.impl.MainControllerImpl;
import it.unibo.monoopoly.model.impl.player.TurnImpl;

public class TestGUI extends JFrame{

    JPanel gamePanel;

    public TestGUI() {
        /*final MainController controller = new MainControllerImpl(new TurnImpl(List.of("maurizio")), List.of("franco"));*/

        Dimension screeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screeDimension);
        setResizable(false);
        setUndecorated(true);

        this.gamePanel = new GamePanel(/*controller, */ getHeight(), getWidth());
        add(this.gamePanel);

        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] strg) {
        new TestGUI();
    }
}
