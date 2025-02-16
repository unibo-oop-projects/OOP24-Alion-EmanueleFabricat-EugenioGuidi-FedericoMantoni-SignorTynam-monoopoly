package it.unibo.monoopoly.controller.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerUnmortgageState implements ControllerState {
    MainController mainController;
    ModelState actualModelState;
    ViewState actualViewState;

    public ControllerUnmortgageState(MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = this.mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    @Override
    public void startState() {
        this.actualViewState.setMode(new DataInput(null, null, null, null, null, null, null, null, null));
        this.actualViewState.visualize();
    }

    @Override
    public void continueState(DataOutput dataOutput) {
        this.actualModelState.doAction(Optional.of(dataOutput));
        this.actualModelState.closeState();
    }

}
