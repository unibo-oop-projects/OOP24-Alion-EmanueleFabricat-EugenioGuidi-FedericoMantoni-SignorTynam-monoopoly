package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementations of {@link ViewState} for the card's phase:
 * that visualize in the PlayerPanel the text of the {@link Card}.
 */
public class ViewCardState implements ViewState {
    private final MainView mainView;
    private DataInput dataInput;

    /**
     * 
     * 
     * @param mainView
     */
    public ViewCardState(final MainView mainView) {
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
    public void visualize(final DataInput data) {
        this.dataInput = data;
        final JPanel panel = new JPanel();
        JOptionPane.showMessageDialog(panel, this.dataInput.text().get(), "Card",
                JOptionPane.PLAIN_MESSAGE);
        this.mainView.setInteractivePanel(panel);
    }

}
