package it.unibo.monoopoly.controller.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * manca comment.
 */
public class ControllerCardState implements ControllerState {
    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final GameBoard gameBoard;
    private final DataBuilderInput dataBuilderInput = new DataBuilderInputImpl();

    /**
     * comment.
     * 
     * @param mainController
     */
    public ControllerCardState(final MainController mainController, final ModelState actualModelState,
            final ViewState actualViewState, final GameBoard gameBoard) {
        this.mainController = mainController;
        this.actualModelState = actualModelState;
        this.actualViewState = actualViewState;
        this.gameBoard = gameBoard;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualModelState.doAction(Optional.empty());
        this.actualViewState.visualize(this.dataBuilderInput.text(
                this.gameBoard.getDeck().getActualCard().getEffectText() // aspetto implementazione
        ).build());
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
