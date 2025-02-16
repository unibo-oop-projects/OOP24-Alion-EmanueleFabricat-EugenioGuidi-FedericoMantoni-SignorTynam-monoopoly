package it.unibo.monoopoly.view.impl.banker.state;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.impl.DataInput;
import it.unibo.monoopoly.controller.impl.DataOutput;
import it.unibo.monoopoly.view.api.ViewState;
import it.unibo.monoopoly.view.impl.MainView;

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
                this.panel = new SellHouseView(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
            } else {
                this.panel = new MortgageView(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
            }
        } else {
            if (this.dataInput.setMode2().get()) {
                this.panel = new SuccessfulPaymentView(new SimpleExit());
            } else {
                this.panel = new BankruptcyView(new SimpleExit());
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
