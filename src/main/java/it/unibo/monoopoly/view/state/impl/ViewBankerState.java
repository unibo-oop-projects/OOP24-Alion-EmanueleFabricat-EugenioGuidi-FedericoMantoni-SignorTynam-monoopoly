package it.unibo.monoopoly.view.state.impl;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.utils.impl.ViewCellGiver;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.SelectionCellsPanel;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ViewBankerState implements ViewState {
    private final MainView mainView;
    private DataInput dataInput;
    private boolean isIndebited;

    /**
     * comment.
     * 
     * @param mainView
     */
    public ViewBankerState(final MainView mainView) {
        this.mainView = mainView;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void setMode(final Boolean setter) {
        this.isIndebited = setter;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void visualize(final DataInput data) {
        if (!isIndebited) {
            JOptionPane.showMessageDialog(this.mainView.getMainFrame(),
                    "Pagamento effetuato con successo", "Pagamento", JOptionPane.PLAIN_MESSAGE);
            this.mainView.getMainController().getControllerState().continueState(new DataBuilderOutputImpl().build());
        } else {
            switch (data.event().get()) {
                case Event.SELL_HOUSE:
                    JPanel panel = new SelectionCellsPanel(new ViewCellGiver(this.mainView),
                            intToTextCell(data.cellList().get()), "in cui vendere una casa");
                    this.mainView.setInteractivePanel(panel);
                    break;
                case Event.MORTGAGE_PROPERTY:
                    JPanel panel1 = new SelectionCellsPanel(new ViewCellGiver(this.mainView),
                            intToTextCell(dataInput.cellList().get()), "da disipotecare");
                    this.mainView.setInteractivePanel(panel1);
                    break;
                case Event.BANKRUPT:
                    JOptionPane.showMessageDialog(this.mainView.getMainFrame(),
                            "HAI FINITO I SOLDI E LE PROPRIETA' SEI IN BANCAROTTA, PER TE IL GIOCO E' FINITO",
                            "Bancarotta", JOptionPane.PLAIN_MESSAGE);
                    this.mainView.getMainController().getControllerState()
                            .continueState(new DataBuilderOutputImpl().build());
                default:
                    throw new IllegalStateException("ViewBankerState non riconosce lo stato in cui ti trovi");
            }
        }
    }

    private List<String> intToTextCell(final List<Integer> cellList) {
        return cellList.stream()
                .map(this.mainView.getNameCells()::get)
                .toList();
    }
}
