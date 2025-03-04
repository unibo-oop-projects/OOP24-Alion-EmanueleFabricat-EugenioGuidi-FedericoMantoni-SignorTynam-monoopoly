package it.unibo.monoopoly.view.main.api;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
     * @return all {@link JPanel}s contained in the main frame of the view
     */
    JPanel getMainPanel();

}
