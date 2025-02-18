package it.unibo.monoopoly.view.main.api;


import java.util.List;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.main.api.MainController;

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

    /**
     * 
     * @return comment.
     */
    MainController getMainController();

    /**
     * 
     * @return comment.
     */
    List<String> getNameCells();
}
