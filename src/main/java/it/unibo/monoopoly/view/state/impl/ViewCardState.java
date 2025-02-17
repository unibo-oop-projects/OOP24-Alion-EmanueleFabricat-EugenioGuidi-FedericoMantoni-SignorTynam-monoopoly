package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

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
