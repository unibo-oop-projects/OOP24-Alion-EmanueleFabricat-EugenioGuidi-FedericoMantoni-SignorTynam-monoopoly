package it.unibo.monoopoly.controller.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ControllerMovementState implements ControllerState {

    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;

    /**
     * comment.
     * 
     * @param mainController
     */
    public ControllerMovementState(final MainController mainController) {
        this.mainController = mainController;
        this.actualModelState = mainController.getModelState();
        this.actualViewState = this.mainController.getViewState();
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        // ritorna se è con dadi o no.
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualModelState.doAction(Optional.empty());
        this.actualViewState.visualize(new DataInput(null, null, null, null, null, null));
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
