package it.unibo.monoopoly.utils.impl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.DefaultInteractivePanel;

public class RollDicesListener implements ActionListener{

    private final MainView mainView;

    public RollDicesListener(final MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.mainView.setInteractivePanel(new DefaultInteractivePanel());
        mainView.getMainController().getControllerState().continueState(
                    new DataBuilderOutputImpl().build());
    }
}
