package it.unibo.monoopoly.controller.state.impl;


import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementations of {@link ControllerState} for the card's phase:
 * that call the {@link ModelState} and {@link ViewState} methods, 
 * in the right order,
 * with the right input.
 * Build with {@link DataBuilderInput} all the data that need the View.
 */
public class ControllerCardState implements ControllerState {
    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final GameBoard gameBoard;

   /**
    * Constructor of the class that sets the fields.
    * @param mainController to set.
    * @param actualModelState to set.
    * @param actualViewState to set.
    * @param gameBoard to set.
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
    public void startControllerState() {
        this.actualViewState.setMode(this.actualModelState.verify());
        this.actualModelState.doAction(new DataBuilderOutputImpl().build());
        this.actualViewState.visualize(new DataBuilderInputImpl().text(
                this.gameBoard.getDeck().getActualCard().getEffectText() 
        ).build());
        closeControllerState(new DataBuilderOutputImpl().build());
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void closeControllerState(final DataOutput dataOutput) {
        this.actualModelState.closeState();
        this.mainController.nextPhase();
    }

}
