package it.unibo.monoopoly.view.api;


import java.util.List;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.controller.impl.DataOutput;

/**
 * Interface for the View component of the application.
 */
public interface View {

    /**
     * Set visible the {@link JFrame} of the view.
     */
    void display();

    /**
     * @return the main {@link JFrame} of the view
     */
    JFrame getMainFrame();

    /* */
    MainController getMainController();

    /* */
    List<String> getNameCells();
}
