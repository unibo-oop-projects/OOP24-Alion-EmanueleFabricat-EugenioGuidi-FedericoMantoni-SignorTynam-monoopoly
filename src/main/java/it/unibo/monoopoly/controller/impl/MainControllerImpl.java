package it.unibo.monoopoly.controller.impl;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.view.impl.MainView;

public class MainControllerImpl implements MainController {

    //private final ControllerState<?> actualState;
    private final MainView mainView;
    private final Turn model;

    public MainControllerImpl(Turn model) {
        this.model = model;
        this.mainView = new MainView();
        this.mainView.display();
        //this.actualState = new PrisonControllerState();
        this.startTurn();
    }

    public void startTurn() {
        //this.actualState.startState();
    }

}
