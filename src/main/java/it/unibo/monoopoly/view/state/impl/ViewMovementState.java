package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.utils.impl.RollDicesListener;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.RollDicesPanel;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ViewMovementState implements ViewState {

    private final MainView mainView;

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
        if (dataInput.mode().isPresent() && dataInput.mode().get()) {
            this.mainView.setInteractivePanel(new RollDicesPanel(new RollDicesListener(this.mainView)));
        } else if (dataInput.dices().isPresent()) {
            JOptionPane.showMessageDialog(this.mainView.getMainFrame(),
                    "Primo dado: " + dataInput.dices().get().getFirstRoll() 
                    + "\nSecondo dado: " + dataInput.dices().get().getSecondRoll(),
                    null, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
