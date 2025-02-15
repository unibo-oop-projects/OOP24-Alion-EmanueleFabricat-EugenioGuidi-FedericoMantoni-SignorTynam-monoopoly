package it.unibo.monoopoly.controller.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerUnmortgageState implements ControllerState<Optional<Integer>>{
    MainController mainController;
    ModelState<Optional<Integer>, Optional<List<Integer>>> actualModelState;
    ViewState<Boolean, Optional<List<Integer>>> actualViewState;

    public ControllerUnmortgageState(MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = this.mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualViewState.visualize(this.actualModelState.getData());
    }

    @Override
    public void continueState(Optional<Integer> selectedCell) {
        this.actualModelState.doAction(selectedCell);
        this.actualModelState.closeState();
    }

}
