package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Visualizes the prison state.
 */
public class ViewPrisonState implements ViewState {

    private final MainView mainView;
    private boolean goToJail;

    /**
     * Constructs the view prison state.
     * 
     * @param mainView the main view
     */
    public ViewPrisonState(final MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * Sets the mode.
     * 
     * @param mode the mode
     */
    @Override
    public void setMode(final Boolean mode) {
        this.goToJail = mode;
    }

    /**
     * Visualizes the state.
     * 
     * @param data the data
     */
    @Override
    public void visualize(final DataInput data) {
        final String message;
        if (goToJail) {
            message = "Devi andare in prigione senza passare dal VIA!";
        } else {
            if (data.isEnabled().isPresent() && data.isEnabled().get()) {
                message = "Sei uscito di prigione usando la tua carta 'Esci Gratis di Prigione'.";
            } else {
                message = "Devi uscire di prigione e pagare €50.";
            }
        }
        JOptionPane.showMessageDialog(mainView.getMainFrame(), message);
    }
}
