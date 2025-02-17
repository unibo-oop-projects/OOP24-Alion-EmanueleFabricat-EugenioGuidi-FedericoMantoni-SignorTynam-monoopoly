package it.unibo.monoopoly.view.state.impl;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

import javax.swing.JOptionPane;

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
