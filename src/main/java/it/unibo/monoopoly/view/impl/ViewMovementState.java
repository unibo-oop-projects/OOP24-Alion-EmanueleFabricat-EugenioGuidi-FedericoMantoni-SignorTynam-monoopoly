package it.unibo.monoopoly.view.impl;

import it.unibo.monoopoly.view.api.ViewState;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;

public class ViewMovementState implements ViewState<Boolean, Pair> {

    private final MainView mainVIew;
    private boolean showRollDice;

    public ViewMovementState(final MainView mainView) {
        this.mainVIew = mainView;
    }

    @Override
    public void setMode(Boolean showRollDice) {
        this.showRollDice = showRollDice;
    }

    @Override
    public void visualize(Pair dices) {
        if(this.showRollDice) {
            String string = "Primo dado: " + dices.getFirstRoll() + " Secondo dado: " + dices.getSecondRoll();
            JOptionPane.showMessageDialog(this.mainVIew.getMainFrame(), string, "Lancio dei dadi", JOptionPane.INFORMATION_MESSAGE);
        }
        this.mainVIew.getMainController().getControllerState().continueState(null);
    }

}
