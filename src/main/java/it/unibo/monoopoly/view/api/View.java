package it.unibo.monoopoly.view.api;

import javax.swing.JFrame;

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

}
