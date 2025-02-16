package it.unibo.monoopoly.controller.impl;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerCardState implements ControllerState {
    MainController mainController;
    ModelState actualModelState;
    ViewState actualViewState;

    public ControllerCardState(MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = this.mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualModelState.doAction(this.mainController.getOutputData());
        this.actualViewState.visualize();
    }

    @Override
    public void continueState() {
        this.actualModelState.closeState();
    }

}
