package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

public class ViewPrisonState implements ViewState {

    private final MainView mainView;
    private boolean goToJail;

    public ViewPrisonState(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(Boolean mode) {
        this.goToJail = mode;
    }

    @Override
    public void visualize(DataInput data) {
        String message;
        if (goToJail) {
            message = "You must go to jail without passing VIA!";
        } else {
            if (data.mode().isPresent() && data.mode().get()) {
                message = "You got out of jail using your 'Get Out of Jail Free' card.";
            } else {
                message = "You must exit jail and pay €50.";
            }
        }
        JOptionPane.showMessageDialog(mainView.getMainFrame(), message);
    }
}
