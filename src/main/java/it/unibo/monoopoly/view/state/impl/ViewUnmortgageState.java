package it.unibo.monoopoly.view.state.impl;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.utils.impl.ViewCellGiver;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.SelectionCellsPanel;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementations of {@link ViewState} for the card's phase:
 * to allow the player to decide which property to release the mortgage on.
 */
public class ViewUnmortgageState implements ViewState {
    private final MainView mainView;
    private boolean makeState;

    /**
     * Constructor of the class that sets the field.
     * 
     * @param mainView to set.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Suppressing according to pattern State")
    public ViewUnmortgageState(final MainView mainView) {
        this.mainView = mainView;
    }

    /**
     *
     * {@inheritDoc}
     */

    @Override
    public void setMode(final Boolean setter) {
        this.makeState = setter;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void visualize(final DataInput dataInput) {
        if (this.makeState) {
            final JPanel panel = new SelectionCellsPanel(this.mainView.getMainFrame().getHeight(),
                    new ViewCellGiver(this.mainView),
                    intToTextCell(dataInput.cellMap().get()), "da disipotecare", true);
            this.mainView.setInteractivePanel(panel);
        } else {
            JOptionPane.showMessageDialog(this.mainView.getMainFrame(),
                    "Mi spiace non hai proprietà da disipotecare", "Disipoteca", JOptionPane.PLAIN_MESSAGE);
            this.mainView.getControllerState().closeControllerState(new DataBuilderOutputImpl().build());
        }
    }

    private Map<String, Integer> intToTextCell(final Map<Integer, Integer> cellMap) {
        return cellMap.entrySet().stream()
                .collect(Collectors.toMap(e -> this.mainView.getNameCells().get(e.getKey()), Entry::getValue));
    }
}
