package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ViewCardState implements ViewState {
    private final MainView mainView;
    private DataInput dataInput;

    /**
     * comment.
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
    public void setMode(final DataInput dataInput) {
        this.dataInput = dataInput;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void visualize() {
        JOptionPane.showMessageDialog(this.mainView.getMainPanel(), this.dataInput.cardText().get(), "Card",
                JOptionPane.PLAIN_MESSAGE);
    }

}
