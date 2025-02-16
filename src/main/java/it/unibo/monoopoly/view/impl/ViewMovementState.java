package it.unibo.monoopoly.view.impl;

import it.unibo.monoopoly.view.api.ViewState;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.impl.DataInput;

public class ViewMovementState implements ViewState {

    private final MainView mainVIew;
    private DataInput dataInput;

    public ViewMovementState(final MainView mainView) {
        this.mainVIew = mainView;
    }

    @Override
    public void setMode(DataInput dataInput) {
        this.dataInput = dataInput;
    }

    @Override
    public void visualize() {
        if(this.dataInput.setMode1().get()) {
            String string = "Primo dado: " + this.dataInput.dices().get().getFirstRoll() + "\nSecondo dado: " + this.dataInput.dices().get().getSecondRoll();
            JOptionPane.showMessageDialog(this.mainVIew.getMainFrame(), string, "Lancio dei dadi", JOptionPane.INFORMATION_MESSAGE);
        }
        this.mainVIew.getMainController().getControllerState().continueState(null);
    }

}
