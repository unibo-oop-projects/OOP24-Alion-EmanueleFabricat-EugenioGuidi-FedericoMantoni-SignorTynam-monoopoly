package it.unibo.monoopoly.controller.state.impl;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.state.api.ModelState;

/**
 * manca comment.
 */
public class BuildHouseControllerState implements ControllerState {
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startState'");
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void continueState(final DataOutput dataOutput) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'continueState'");
    }
    /*
     * private final ModelState<Integer, String> modelState;
     * private final ViewState<String, String> viewState;
     * 
     * 
     * public BuildHouseControllerState(ModelState<Integer, String> modelState,
     * ViewState<String, String> viewState) {
     * this.modelState = modelState;
     * this.viewState = viewState;
     * }
     * 
     * @Override
     * public void startState() {
     * modelState.verify();
     * viewState.setMode("Build a house");
     * viewState.visualize(modelState.getData());
     * }
     * 
     * @Override
     * public void continueState(Integer input) {
     * modelState.doAction(input);
     * viewState.setMode("Build Hourse State");
     * viewState.visualize(modelState.getData());
     * }
     */
}
