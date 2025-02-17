package it.unibo.monoopoly.controller.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.state.api.ControllerState;
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
        this.actualViewState.setMode(new DataInput(null, null, null, null, null, null, null, null, null));//ritorna se è con dadi o no
        this.actualModelState.doAction(Optional.empty());
        this.actualViewState.visualize();
    }

    @Override
    public void continueState(DataOutput dataOutput) {
        this.actualModelState.closeState();
    }

}
