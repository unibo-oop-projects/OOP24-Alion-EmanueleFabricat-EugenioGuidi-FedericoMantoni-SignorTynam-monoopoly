package it.unibo.monoopoly.controller.state.impl;

import java.util.Map;
import java.util.stream.Collectors;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementations of {@link ControllerState} for the card's phase:
 * that call the {@link ModelState} and {@link ViewState} methods,
 * in the right order,
 * with the right input.
 * Build with {@link DataBuilderInput} all the data that need the view
 */
public class ControllerUnmortgageState implements ControllerState {
    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final GameBoard gameBoard;
    private boolean runState;
    private final DataBuilderInput dataBuilderInput = new DataBuilderInputImpl();

    /**
     * Constructor of the class that sets the fields.
     * 
     * @param mainController   to set.
     * @param actualModelState to set.
     * @param actualViewState  to set.
     * @param gameBoard        to set.
     */
    public ControllerUnmortgageState(final MainController mainController, final ModelState actualModelState,
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
        this.runState = this.actualModelState.verify();
        this.actualViewState.setMode(this.runState);
        this.actualViewState.visualize(buildData());
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void continueState(final DataOutput dataOutput) {
        this.actualModelState.doAction(dataOutput);
        this.actualModelState.closeState();
        this.mainController.nextPhase();
    }

    private DataInput buildData() {
        if (runState) {
            return this.dataBuilderInput.cellMap(unmortgageableList()).build();
        } else {
            return this.dataBuilderInput.build();
        }
    }

    private Map<Integer, Integer> unmortgageableList() {
        return this.gameBoard.getCurrentPlayer().getProperties().stream()
                .filter(Buyable::isMortgaged)
                .filter(this::isPayable)
                .collect(Collectors.toMap(this.gameBoard.getCellsList()::indexOf, Buyable::getUnmortgageValue));
    }

    private boolean isPayable(final Buyable property) {
        final int toPay = property.getUnmortgageValue();
        return this.gameBoard.getCurrentPlayer().isPayable(toPay);
    }

}
