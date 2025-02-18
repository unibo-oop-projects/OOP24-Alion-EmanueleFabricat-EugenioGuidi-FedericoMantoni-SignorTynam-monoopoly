package it.unibo.monoopoly.controller.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * missing comment.
 */
public class ControllerBankerState implements ControllerState {
    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final DataBuilderInput dataBuilderInput = new DataBuilderInputImpl(); 

    /**
     * comment.
     * 
     * @param mainController
     */
    public ControllerBankerState(final MainController mainController, final ModelState actualModelState,
            final ViewState actualViewState) {
        this.mainController = mainController;
        this.actualModelState = actualModelState;
        this.actualViewState = actualViewState;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualViewState.visualize(new DataInput(null, null, null, null, null, null));
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void continueState(final DataOutput dataOutput) {
        this.actualModelState.doAction(Optional.of(dataOutput));
        this.actualModelState.closeState();
    }

}
