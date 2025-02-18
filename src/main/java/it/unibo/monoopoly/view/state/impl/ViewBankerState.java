package it.unibo.monoopoly.view.state.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.panel.impl.BankruptcyPanel;
import it.unibo.monoopoly.view.panel.impl.MortgagePanel;
import it.unibo.monoopoly.view.panel.impl.SellHousePanel;
import it.unibo.monoopoly.view.panel.impl.SuccessfulPaymentPanel;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ViewBankerState implements ViewState {
    private final MainView mainView;
    private DataInput dataInput;
    private JPanel panel;
    private boolean payable;

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
    public void setMode(Boolean setter) {
        this.payable = setter;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void visualize(final DataInput data) {
        this.dataInput = data;
        if (this.payable) {
            if (this.dataInput.setMode().get()) {
                this.panel = new SellHousePanel(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
            } else {
                this.panel = new MortgagePanel(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
            }
        } else {
            if (this.dataInput.setMode().get()) {
                this.panel = new SuccessfulPaymentPanel(new SimpleExit());
            } else {
                this.panel = new BankruptcyPanel(new SimpleExit());
            }
        }
        this.mainView.getMainFrame().add(panel);
    }

    private List<String> intToTextCell(final List<Integer> cellList) {
        return cellList.stream()
                .map(this.mainView.getNameCells()::get)
                .toList();
    }

    /**
     * comment.
     */
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

    /**
     * comment.
     */
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
