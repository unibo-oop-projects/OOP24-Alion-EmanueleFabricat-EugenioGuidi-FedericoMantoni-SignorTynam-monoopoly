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
import it.unibo.monoopoly.view.panel.impl.SellHousePanel;
import it.unibo.monoopoly.view.panel.impl.SuccessfulPaymentPanel;
import it.unibo.monoopoly.view.state.api.ViewState;

public class ViewBankerState implements ViewState {
    private final MainView mainView;
    private DataInput dataInput;
    private JPanel panel;

    public ViewBankerState(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(DataInput dataInput) {
        this.dataInput = dataInput;
    }

    @Override
    public void visualize() {
        if (this.dataInput.setMode1().get()) {
            if (this.dataInput.setMode2().get()) {
                this.panel = new SellHousePanel(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
            } else {
                this.panel = new MortgagePanel(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
            }
        } else {
            if (this.dataInput.setMode2().get()) {
                this.panel = new SuccessfulPaymentPanel(new SimpleExit());
            } else {
                this.panel = new BankruptcyPanel(new SimpleExit());
            }
        }
        this.mainView.getMainFrame().add(panel);
    }

    private List<String> intToTextCell(List<Integer> cellList) {
        return cellList.stream()
                .map(this.mainView.getNameCells()::get)
                .toList();
    }

    public class CellGiver implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            var button = (JButton) e.getSource();
            String cellName = button.getText();
            int cell = mainView.getNameCells().indexOf(cellName);
            mainView.getMainFrame().remove(panel);
            mainView.getMainController().getControllerState().continueState(new DataOutput(null, null));
        }

    }

    public class SimpleExit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            mainView.getMainFrame().remove(panel);
            mainView.getMainController().getControllerState().continueState(new DataOutput(null, null));
        }

    }

}
