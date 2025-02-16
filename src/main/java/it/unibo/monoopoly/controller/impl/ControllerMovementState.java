package it.unibo.monoopoly.controller.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;
import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerMovementState implements ControllerState<Void>{

    private final MainController mainController;
    private final ModelState<Void, Pair> actualModelState;
    private final ViewState<Boolean, Pair> actualViewState;

    public ControllerMovementState(final MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());//ritorna se è con dadi o no
        this.actualModelState.doAction(null);
        this.actualViewState.visualize(this.actualModelState.getData());
    }

    @Override
    public void continueState(Void empty) {
        this.actualModelState.closeState();
    }

}
