package it.unibo.monoopoly.view.state.impl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

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
                    final JPanel panel = new SelectionCellsPanel(this.mainView.getMainFrame().getHeight(),
                            new ViewCellGiver(this.mainView),
                            intToTextCell(data.cellMap().get()), "in cui vendere una casa", false);
                    this.mainView.setInteractivePanel(panel);
                    break;
                case Event.MORTGAGE_PROPERTY:
                    final JPanel panel1 = new SelectionCellsPanel(this.mainView.getMainFrame().getHeight(),
                            new ViewCellGiver(this.mainView),
                            intToTextCell(data.cellMap().get()), "da disipotecare", false);
                    this.mainView.setInteractivePanel(panel1);
                    break;
                case Event.BANKRUPT:
                    JOptionPane.showMessageDialog(this.mainView.getMainFrame(),
                            "HAI FINITO I SOLDI E LE PROPRIETA' SEI IN BANCAROTTA, PER TE IL GIOCO E' FINITO",
                            "Bancarotta", JOptionPane.PLAIN_MESSAGE);
                    this.mainView.getMainController().getControllerState()
                            .continueState(new DataBuilderOutputImpl().build());
                    break;
                default:
                    throw new IllegalStateException("ViewBankerState non riconosce lo stato in cui ti trovi");
            }
        }
    }

    private Map<String, Integer> intToTextCell(final Map<Integer, Integer> cellMap) {
        return cellMap.entrySet().stream()
                .collect(Collectors.toMap(e -> this.mainView.getNameCells().get(e.getKey()), Entry::getValue));
    }
}
