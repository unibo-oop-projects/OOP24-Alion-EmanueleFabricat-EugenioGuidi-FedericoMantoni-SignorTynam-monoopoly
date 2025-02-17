package it.unibo.monoopoly.view.impl;

import java.util.Optional;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.impl.DataInput;
import it.unibo.monoopoly.controller.impl.DataOutput;
import it.unibo.monoopoly.view.api.View;
import it.unibo.monoopoly.view.api.ViewState;

public class ViewCheckActionState implements ViewState {

    private static final String[] YES_NO = {"Sì", "No"};
    private final View mainView;
    private DataInput dataInput;

    public ViewCheckActionState(final View mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(DataInput dataInput) {
        this.dataInput = dataInput;
    }

    @Override
    public void visualize() {
        switch (this.dataInput.event().get()) {
            case RENT_PAYMENT -> JOptionPane.showMessageDialog(mainView.getMainFrame(),
            "Devi pagare " + this.dataInput.valueToPay().get() + "€ a " + this.dataInput.nameOfPlayer().get(),
            "Pagamento affitto", JOptionPane.PLAIN_MESSAGE);

            case TAX_PAYMENT -> JOptionPane.showMessageDialog(mainView.getMainFrame(),
            "Devi pagare " + this.dataInput.valueToPay().get() + "€ a " + this.dataInput.nameOfPlayer().get(), "Pagamento tassa",
            JOptionPane.PLAIN_MESSAGE);

            case BUY_PROPERTY -> {
            final int choice = JOptionPane.showOptionDialog(mainView.getMainFrame(),
            "Vuoi comprare la proprietà " + this.dataInput.nameOfProperty().get() + "al costo di " + this.dataInput.valueToPay().get() + "€",
            "Compra proprietà",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null,
            YES_NO, 1);
            if(choice == 0) {
                mainView.getMainController().getControllerState().continueState(new DataOutput(Optional.of(true), Optional.empty()));
            } else {
                mainView.getMainController().getControllerState().continueState(new DataOutput(Optional.of(false), Optional.empty()));
            }
        }
            default -> throw new IllegalArgumentException("Nothing to visualize in this state");
        }
    }

}
