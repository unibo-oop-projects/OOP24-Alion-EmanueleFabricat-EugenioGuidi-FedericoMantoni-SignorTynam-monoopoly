package it.unibo.monoopoly.view.impl;

import java.awt.Dimension;
import java.awt.Frame;
import java.util.List;
import java.util.Set;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.naming.spi.StateFactory;
import javax.swing.JFrame;

import it.unibo.monoopoly.controller.impl.MenuControllerImpl;
import it.unibo.monoopoly.view.api.View;
import it.unibo.monoopoly.view.api.ViewState;

public class MainView extends AbstractView {

    private final JFrame mainFrame = new JFrame("MONOOPOLY");
    private final PanelAdapter gamePanel;
    //private final MainController controller = new MainControllerImpl();
    private final ViewState<?,?> viewState;

    public MainView (/*MainController controller*/) {
        //this.controller = controller;
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        //gamePanel = new GamePanel(new MenuControllerImpl());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(screenSize.width / 2, screenSize.height / 2);
        //mainFrame.getContentPane().add(gamePanel);
        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        mainFrame.setVisible(true);
        mainFrame.addComponentListener(new ComponentAdapter() {
            
            @Override
            public void componentResized(ComponentEvent e) {
                menuPanel.resizeText(mainFrame.getSize());
            }
        });
    }

    @Override
    public Set<PanelAdapter> getAllPanels() {
        return Set.of(this.gamePanel);
    }

}
