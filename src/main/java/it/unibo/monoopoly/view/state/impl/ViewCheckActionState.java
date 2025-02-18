package it.unibo.monoopoly.view.state.impl;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.api.DataBuilderOutput;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.view.main.api.View;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ViewCheckActionState implements ViewState {

    private static final String[] YES_NO = { "Sì", "No" };
    private final View mainView;
    private DataBuilderOutput dataBuilderOutput;
    private DataInput dataInput;

    /**
     * comment.
     * 
     * @param mainView
     */
    public ViewCheckActionState(final View mainView) {
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
        switch (this.dataInput.event().get()) {
            case RENT_PAYMENT -> JOptionPane.showMessageDialog(mainView.getMainFrame(),
                    "Devi pagare " + this.dataInput.valueToPay().get() + "€ a " + this.dataInput.nameOfPlayer().get(),
                    "Pagamento affitto", JOptionPane.PLAIN_MESSAGE);

            case TAX_PAYMENT -> JOptionPane.showMessageDialog(mainView.getMainFrame(),
                    "Devi pagare " + this.dataInput.valueToPay().get() + "€ a " + this.dataInput.nameOfPlayer().get(),
                    "Pagamento tassa",
                    JOptionPane.PLAIN_MESSAGE);

            case BUY_PROPERTY -> {
                final int choice = JOptionPane.showOptionDialog(mainView.getMainFrame(),
                        "Vuoi comprare la proprietà " + this.dataInput.nameOfProperty().get() + "al costo di "
                                + this.dataInput.valueToPay().get() + "€",
                        "Compra proprietà",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        YES_NO, 1);
                if (choice == 0) {
                    mainView.getMainController().getControllerState().continueState(new DataOutput(null, null));
                } else {
                    mainView.getMainController().getControllerState().continueState(new DataOutput(null, null));
                }
            }
            default -> throw new IllegalArgumentException("Nothing to visualize in this state");
        }
    }

}
