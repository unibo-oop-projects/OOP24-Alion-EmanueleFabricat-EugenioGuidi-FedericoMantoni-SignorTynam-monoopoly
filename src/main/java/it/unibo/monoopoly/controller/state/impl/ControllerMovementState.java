package it.unibo.monoopoly.controller.state.impl;


import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.Dices;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ControllerMovementState implements ControllerState {

    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final Dices dices;

    /**
     * comment.
     * 
     * @param mainController
     */
    public ControllerMovementState(final MainController mainController, final ModelState modelState,
    final ViewState viewState, final Dices dices) {
        this.mainController = mainController;
        this.actualModelState = modelState;
        this.actualViewState = viewState;
        this.dices = dices;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        final boolean rollDice = this.actualModelState.verify();
        this.actualModelState.doAction(new DataBuilderOutputImpl().build());
        if (rollDice) {
            this.actualViewState.visualize(new DataBuilderInputImpl().dices(this.dices.getDices()).build());
        }
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void continueState(final DataOutput dataOutput) {
        this.actualModelState.closeState();
        mainController.nextPhase();
    }

}
