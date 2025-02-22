package it.unibo.monoopoly.utils.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.view.main.api.MainView;

public class ViewCellGiver implements ActionListener{
    private MainView mainView;
    public static final String NO_CHOICE = "Nessuna scelta";

    public ViewCellGiver(MainView mainView) {
        this.mainView = mainView;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
            final var button = (JButton) e.getSource();
            final String cellName = button.getText();
            final int cell = mainView.getNameCells().indexOf(cellName);
            if (cellName.equals(NO_CHOICE)) {
                mainView.getMainController().getControllerState().continueState(
                    new DataBuilderOutputImpl().build());
            } else {
                mainView.getMainController().getControllerState().continueState(
                        new DataBuilderOutputImpl().cellChoose(cell).build());
            }
    }
}
