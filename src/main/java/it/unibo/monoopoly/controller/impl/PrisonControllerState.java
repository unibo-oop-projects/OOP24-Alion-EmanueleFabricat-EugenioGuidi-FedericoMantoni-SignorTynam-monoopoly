package it.unibo.monoopoly.controller.impl;

import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.state.api.ControllerState;
import it.unibo.monoopoly.view.api.ViewState;

public class PrisonControllerState implements ControllerState {

    @Override
    public void startState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startState'");
    }

    @Override
    public void continueState(DataOutput dataOutput) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'continueState'");
    }
/*
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
*/
}
