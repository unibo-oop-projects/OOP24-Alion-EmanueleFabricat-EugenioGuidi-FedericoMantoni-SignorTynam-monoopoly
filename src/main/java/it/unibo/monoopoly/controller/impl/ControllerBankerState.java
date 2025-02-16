package it.unibo.monoopoly.controller.impl;


import java.util.Optional;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerBankerState implements ControllerState {
    MainController mainController;
    ModelState actualModelState;
    ViewState actualViewState;

    public ControllerBankerState(MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = this.mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualViewState.visualize();
    }

    @Override
    public void continueState(DataOutput dataOutput) {
        this.actualModelState.doAction(Optional.of(dataOutput));
        this.actualModelState.closeState();
    }

}
