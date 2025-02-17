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

public class ViewUnmortgageState implements ViewState {
    private final MainView mainView;
    private JPanel panel;
    private DataInput dataInput;
    
    public ViewUnmortgageState(MainView mainView) {
        this.mainView = mainView;
    }


    @Override
    public void setMode(DataInput dataInput) {
        this.dataInput = dataInput;
    }

    @Override
    public void visualize() {
        if (this.dataInput.setMode1().get()) {
            this.panel = new UnmortgagePanel(new CellGiver(), intToTextCell(this.dataInput.cellList().get()));
        } else {
            this.panel = new NothingUnmortgageablePanel(new SimpleExit());
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
