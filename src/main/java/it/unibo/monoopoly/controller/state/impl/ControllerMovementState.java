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
    private boolean rollDice;

    /**
     * inizialize fields of class.
     * @param mainController
     * @param modelState
     * @param viewState
     * @param dices
     */
    public ControllerMovementState(final MainController mainController, 
                                   final ModelState modelState,
                                   final ViewState viewState, 
                                   final Dices dices) {
        this.mainController = mainController;
        this.actualModelState = modelState;
        this.actualViewState = viewState;
        this.dices = dices;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        this.rollDice = this.actualModelState.verify();
        if (this.rollDice) {
            this.actualViewState.visualize(new DataBuilderInputImpl().mode(this.rollDice).build());
        } else {
            continueState(new DataBuilderOutputImpl().build());
        }
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void continueState(final DataOutput dataOutput) {
        this.actualModelState.doAction(new DataBuilderOutputImpl().build());
        if (this.rollDice) {
            this.actualViewState.visualize(new DataBuilderInputImpl().dices(this.dices.getDices()).build());
        }
        this.actualModelState.closeState();
        mainController.nextPhase();
    }
}
