package it.unibo.monoopoly.view.impl;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class MainView extends AbstractView {

    //private final PanelAdapter gamePanel;
    //private final MainController controller = new MainControllerImpl();
    //private final ViewState<?,?> viewState;

    public MainView (/*MainController controller*/) {
        //this.controller = controller;
        //gamePanel = new GamePanel(new MainControllerImpl());
        //this.viewState = new ViewPrisonState();
        //this.getMainFrame.getContentPane().add(gamePanel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PanelAdapter getMainPanel() {
        //TODO To complete when GamePanel will be available.
        throw new UnsupportedOperationException();
        //return (/*this.gamePanel*/);
    }

}
