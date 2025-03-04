package it.unibo.monoopoly.utils.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.DefaultInteractivePanel;

public class ViewCellGiver implements ActionListener {
    private final MainView mainView;
    public static final String NO_CHOICE = "Nessuna scelta";

    public ViewCellGiver(final MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
            final var button = (JButton) e.getSource();
            final String cellName = button.getText().split("\n")[0];
            final int cell = mainView.getNameCells().indexOf(cellName);
            this.mainView.setInteractivePanel(new DefaultInteractivePanel());
            if (NO_CHOICE.equals(cellName)) {
                mainView.getMainController().getControllerState().continueState(
                    new DataBuilderOutputImpl().build());
            } else {
                mainView.getMainController().getControllerState().continueState(
                        new DataBuilderOutputImpl().cellChoose(cell).build());
            }
    }
}
