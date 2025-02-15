package it.unibo.monoopoly.view.impl.card.state;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.view.api.ViewState;
import it.unibo.monoopoly.view.impl.MainView;

public class ViewCardState implements ViewState<Boolean, String> {
    private final MainView mainView;

    public ViewCardState(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(Boolean setMode) {
    }

    @Override
    public void visualize(String text) {
        JOptionPane.showMessageDialog(this.mainView.getMainPanel(), text, "Card", JOptionPane.PLAIN_MESSAGE);
    }

}
