package it.unibo.monoopoly.view.state.impl;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * comment.
 */
public class ViewMovementState implements ViewState {

    private final MainView mainView;
    private DataInput dataInput;

    /**
     * comment.
     * 
     * @param mainView
     */
    public ViewMovementState(final MainView mainView) {
        this.mainView = mainView;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void setMode(final Boolean setter) {
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void visualize(final DataInput dataInput) {
        this.dataInput = dataInput;
        if (this.dataInput.dices().isPresent()) {
            final String string = "Primo dado: " + this.dataInput.dices().get().getFirstRoll() + "\nSecondo dado: "
                    + this.dataInput.dices().get().getSecondRoll();
            JOptionPane.showMessageDialog(this.mainView.getMainFrame(), string, "Lancio dei dadi",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this.mainView.getMainFrame(), "Ti sei mosso", "movimento", 
                    JOptionPane.INFORMATION_MESSAGE);
        }
        this.mainView.getMainController().getControllerState().continueState(null);
    }

}
