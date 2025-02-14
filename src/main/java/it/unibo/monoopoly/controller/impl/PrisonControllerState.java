package it.unibo.monoopoly.controller.impl;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.view.api.ViewState;

public class PrisonControllerState implements ControllerState<Boolean> {

    private final ModelState<Boolean, String> modelState;
    private final ViewState<String, String> viewState;

    public PrisonControllerState(ModelState<Boolean, String> modelState, ViewState<String, String> viewState) {
        this.modelState = modelState;
        this.viewState = viewState;
    }

    @Override
    public void startState() {
        modelState.verify();
        viewState.setMode("Prison State");
        viewState.visualize(modelState.getData());
    }

    @Override
    public void continueState(Boolean input) {
        modelState.doAction(input);
        modelState.closeState();
        viewState.visualize(modelState.getData());
    }
    
}
