package it.unibo.monoopoly.controller.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * manca comment.
 */
public class ControllerCardState implements ControllerState {
    private MainController mainController;
    private ModelState actualModelState;
    private ViewState actualViewState;

    /**
     * comment.
     * 
     * @param mainController
     */
    public ControllerCardState(final MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = this.mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        this.actualViewState.setMode(new DataInput(null, null, null, null, null, null, null, null, null));
        this.actualModelState.doAction(Optional.empty());
        this.actualViewState.visualize();
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void continueState(final DataOutput dataOutput) {
        this.actualModelState.closeState();
    }

}
