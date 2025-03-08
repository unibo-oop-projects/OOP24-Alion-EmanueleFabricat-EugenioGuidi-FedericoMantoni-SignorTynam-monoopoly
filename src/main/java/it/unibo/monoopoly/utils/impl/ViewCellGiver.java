package it.unibo.monoopoly.utils.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.DefaultInteractivePanel;
import it.unibo.monoopoly.view.panel.impl.SelectionCellsPanel;

/**
 * {@link ActionListener} used to take a selected cell in an
 * {@link SelectionCellsPanel}.
 */
public class ViewCellGiver implements ActionListener {
    private final MainView mainView;
    /**
     * Field use to control if the related button was pressed.
     */
    public static final String NO_CHOICE = "Nessuna scelta";

    /**
     * Constructor of the class.
     * 
     * @param mainView used to call the {@link continueState} method of the
     *                 {@link ControllerState}.
     */
    public ViewCellGiver(final MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void actionPerformed(final ActionEvent e) {
        final var button = (JButton) e.getSource();
        final String cellName = button.getText().split("\n")[0];
        final int cell = mainView.getNameCells().indexOf(cellName);
        this.mainView.setInteractivePanel(new DefaultInteractivePanel(this.mainView.getMainFrame().getHeight()));
        if (NO_CHOICE.equals(cellName)) {
            mainView.getControllerState().closeControllerState(
                    new DataBuilderOutputImpl().build());
        } else {
            mainView.getControllerState().closeControllerState(
                    new DataBuilderOutputImpl().selectedCell(cell).build());
        }
    }
}
