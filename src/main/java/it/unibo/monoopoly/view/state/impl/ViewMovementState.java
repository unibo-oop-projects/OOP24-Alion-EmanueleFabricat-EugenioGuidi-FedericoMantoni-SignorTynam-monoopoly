package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.model.gameboard.api.Dices;
import it.unibo.monoopoly.utils.impl.RollDicesListener;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.RollDicesPanel;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementations of {@link ViewState} for the movement's phase:
 * that visualize in the PlayerPanel the text of the {@link Dices}.
 */
public class ViewMovementState implements ViewState {

    private final MainView mainView;

    /**
     * Constructor of the class that sets the field.
     * 
     * @param mainView
     */
    public ViewMovementState(final MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMode(final Boolean setter) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visualize(final DataInput dataInput) {
        if (dataInput.isEnabled().isPresent() && dataInput.isEnabled().get()) {
            this.mainView.setInteractivePanel(new RollDicesPanel(new RollDicesListener(this.mainView),
                    mainView.getMainFrame().getHeight()));
        } else if (dataInput.dices().isPresent()) {
            JOptionPane.showMessageDialog(this.mainView.getMainFrame(),
                    "Primo dado: " + dataInput.dices().get().getFirstRoll()
                            + "\nSecondo dado: " + dataInput.dices().get().getSecondRoll(),
                    null, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
