package it.unibo.monoopoly.controller.impl;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerMovementState implements ControllerState {

    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;

    public ControllerMovementState(final MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());//ritorna se è con dadi o no
        this.actualModelState.doAction(this.mainController.getOutputData());
        this.actualViewState.visualize();
    }

    @Override
    public void continueState() {
        this.actualModelState.closeState();
    }

}
