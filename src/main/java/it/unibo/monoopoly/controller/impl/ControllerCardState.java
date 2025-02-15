package it.unibo.monoopoly.controller.impl;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerCardState implements ControllerState<Void> {
    MainController mainController;
    ModelState<Void, String> actualModelState;
    ViewState<Boolean, String> actualViewState;

    @SuppressWarnings("unchecked")
    public ControllerCardState(MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = (ModelState<Void, String>) this.mainController.getModelState();
        this.actualViewState = (ViewState<Boolean, String>) this.mainController.getViewState();
    }

    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualModelState.doAction(null);
        this.actualViewState.visualize(this.actualModelState.getData());
    }

    @Override
    public void continueState(Void empty) {
        this.actualModelState.closeState();
    }

}
