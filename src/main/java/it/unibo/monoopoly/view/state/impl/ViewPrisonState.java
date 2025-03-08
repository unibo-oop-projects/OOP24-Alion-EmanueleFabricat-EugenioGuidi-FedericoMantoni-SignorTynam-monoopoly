package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Suppressing according to pattern State")
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
            message = "You must go to jail without passing VIA!";
        } else {
            if (data.isEnabled().isPresent() && data.isEnabled().get()) {
                message = "You got out of jail using your 'Get Out of Jail Free' card.";
            } else {
                message = "You must exit jail and pay €50.";
            }
        }
        JOptionPane.showMessageDialog(mainView.getMainFrame(), message);
    }
}
