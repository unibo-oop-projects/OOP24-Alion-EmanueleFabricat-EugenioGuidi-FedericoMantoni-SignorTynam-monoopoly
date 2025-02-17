package it.unibo.monoopoly.view.impl.card.state;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.impl.DataInput;
import it.unibo.monoopoly.view.api.ViewState;
import it.unibo.monoopoly.view.impl.MainView;

public class ViewCardState implements ViewState {
    private final MainView mainView;
    private DataInput dataInput;

    public ViewCardState(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(DataInput dataInput) {
        this.dataInput = dataInput;
    }

    @Override
    public void visualize() {
        JOptionPane.showMessageDialog(this.mainView.getMainPanel(), this.dataInput.cardText().get(), "Card", JOptionPane.PLAIN_MESSAGE);
    }

}
