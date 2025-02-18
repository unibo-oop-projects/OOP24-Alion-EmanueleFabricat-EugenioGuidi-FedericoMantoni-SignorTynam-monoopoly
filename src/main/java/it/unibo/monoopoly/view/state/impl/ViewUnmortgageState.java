package it.unibo.monoopoly.view.state.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.panel.impl.NothingUnmortgageablePanel;
import it.unibo.monoopoly.view.panel.impl.UnmortgagePanel;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ViewUnmortgageState implements ViewState {
    private final MainView mainView;
    private JPanel panel;
    private DataInput dataInput;

    /**
     * comment.
     * 
     * @param mainView
     */
    public ViewUnmortgageState(final MainView mainView) {
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
        if (this.dataInput.setMode1().get()) {
            this.panel = new UnmortgagePanel(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
        } else {
            this.panel = new NothingUnmortgageablePanel(new SimpleExit());
        }
        this.mainView.getMainFrame().add(panel);
    }

    private List<String> intToTextCell(final List<Integer> cellList) {
        return cellList.stream()
                .map(this.mainView.getNameCells()::get)
                .toList();
    }

    public class CellGiver implements ActionListener {
        /**
         *
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(final ActionEvent e) {
            final var button = (JButton) e.getSource();
            final String cellName = button.getText();
            final int cell = mainView.getNameCells().indexOf(cellName);
            mainView.getMainFrame().remove(panel);
            mainView.getMainController().getControllerState().continueState(new DataOutput(null, null));
        }

    }

    public class SimpleExit implements ActionListener {
        /**
         *
         * {@inheritDoc}
         */
        @Override
        public void actionPerformed(final ActionEvent e) {
            mainView.getMainFrame().remove(panel);
            mainView.getMainController().getControllerState().continueState(new DataOutput(null, null));
        }

    }

}
