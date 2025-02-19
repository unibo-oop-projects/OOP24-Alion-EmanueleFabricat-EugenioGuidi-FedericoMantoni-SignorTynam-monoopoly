package it.unibo.monoopoly.view.state.impl;

import java.util.Optional;

import javax.swing.JOptionPane;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.view.main.api.View;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementation of {@link ViewState} that shows messages concerning payment
 * caused directly by a {@link Cell} of the {@link Gameboard}.
 */
public class ViewCheckActionState implements ViewState {

    private static final String[] YES_NO = { "Sì", "No" };
    private final View mainView;

    /**
     * Constructor of {@link ViewCheckActionState}.
     * @param mainView the main view of the application
     */
    public ViewCheckActionState(final View mainView) {
        this.mainView = mainView;
    }

    /**
     * {@inheritDoc}
     * Unused in this class.
     */
    @Override
    public void setMode(final Boolean mode) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void visualize(final DataInput dataInput) {
        switch (dataInput.event().get()) {
            case RENT_PAYMENT -> JOptionPane.showMessageDialog(mainView.getMainFrame(),
                    "Devi pagare " + dataInput.valueToPay().get() + "€ a " + dataInput.text().get(),
                    "Pagamento affitto", JOptionPane.PLAIN_MESSAGE);

            case TAX_PAYMENT -> JOptionPane.showMessageDialog(mainView.getMainFrame(),
                    "Devi pagare " + dataInput.valueToPay().get() + "€ a " + dataInput.text().get(), "Pagamento tassa",
                    JOptionPane.PLAIN_MESSAGE);

            case BUY_PROPERTY -> {
                final int choice = JOptionPane.showOptionDialog(mainView.getMainFrame(),
                        "Vuoi comprare la proprietà " + dataInput.text().get() + "al costo di " + dataInput.valueToPay().get()
                                + "€",
                        "Compra proprietà",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        YES_NO, 1);
                if (choice == 0) {
                    mainView.getMainController().getControllerState()
                            .continueState(new DataOutput(Optional.of(true), Optional.empty()));
                } else {
                    mainView.getMainController().getControllerState()
                            .continueState(new DataOutput(Optional.of(false), Optional.empty()));
                }
            }
            default -> throw new IllegalArgumentException("Nothing to visualize in this state");
        }

    }

}
