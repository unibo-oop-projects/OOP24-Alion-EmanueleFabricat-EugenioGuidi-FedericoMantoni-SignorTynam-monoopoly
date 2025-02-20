package it.unibo.monoopoly.controller.state.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class ControllerUnmortgageState implements ControllerState {
    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final GameBoard gameBoard;
    private boolean runState;
    private final DataBuilderInput dataBuilderInput = new DataBuilderInputImpl(); 

    /**
     * comment.
     * 
     * @param mainController
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
        this.actualModelState.doAction(new DataBuilderOutputImpl().build());
        this.actualModelState.closeState();
    }

    private DataInput buildData() {
        if (runState) {
            return this.dataBuilderInput.cellList(unmortgageableList()).build();
        } else {
            return this.dataBuilderInput.build();
        }
    }

    private List<Integer> unmortgageableList() {
        return Optional.of(this.gameBoard.getCurrentPlayer().getProperties().stream()
                .filter(c -> c.isMortgaged())
                .filter(this::isPayable)
                .map(this.gameBoard.getCellsList()::indexOf)
                .toList()).get();
    }

    private boolean isPayable(final Buyable property) {
        int toPay = property.getMortgageValue()*110/100;
        return this.gameBoard.getCurrentPlayer().isPayable(toPay);
    }

}
