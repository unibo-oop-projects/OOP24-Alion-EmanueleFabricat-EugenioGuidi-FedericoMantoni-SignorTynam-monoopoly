package it.unibo.monoopoly.controller.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.api.Functional;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementation of {@link ControllerState} that retrieve data from model
 * according to the {@link Event} and pass it to the view.
 */
public class ControllerCheckActionState implements ControllerState {

    private final MainController mainController;
    private final ModelState modelState;
    private final ViewState viewState;
    private final GameBoard gameBoard;

    /**
     * Construct the {@link ControllerCheckActionState}.
     * 
     * @param mainController the main controller
     * @param modelState     the actual model state
     * @param viewState      the view state
     * @param event          the actual event triggered by the cell
     * @param actualCell     the actual cell where the player is right now
     */
    public ControllerCheckActionState(final MainController mainController, final ModelState modelState,
            final ViewState viewState, final GameBoard gameBoard) {
        this.mainController = mainController;
        this.modelState = modelState;
        this.viewState = viewState;
        this.gameBoard = gameBoard;
    }

    /**
     * {@inheritDoc}
     * Call the model and the view in the right order to perform and visualize the
     * right action.
     */
    @Override
    public void startState() {
        final Cell actualCell = this.gameBoard.getCell(this.gameBoard.getCurrentPlayer().getActualPosition());
        final Optional<Event> actualEvent = this.mainController.getActualEvent();
        if (modelState.verify()) {
            viewState.visualize(new DataBuilderInputImpl()
                    .event(Event.BUY_PROPERTY)
                    .valueToPay(((Buyable) actualCell).getCost())
                    .text(actualCell.getName()).build());
        } else if (actualEvent.isPresent()) {
            modelState.doAction(Optional.empty());
            if (actualEvent.get().equals(Event.RENT_PAYMENT)) {
                viewState.visualize(new DataBuilderInputImpl().event(actualEvent.get())
                        .valueToPay(((Buyable) actualCell).getRentalValue())
                        .text(((Buyable) actualCell).getOwner().get().getName()).build());
            } else if (actualEvent.get().equals(Event.TAX_PAYMENT)) {
                viewState.visualize(new DataBuilderInputImpl()
                        .event(actualEvent.get())
                        .valueToPay(((Functional) actualCell).getAction().get().data().get()).build());
            }
        }
        this.continueState(new DataBuilderOutputImpl().build());
    }

    /**
     * If needed perform the action of buy a property given the input of the player,
     * and next ends the state.
     * {@inheritDoc}
     */
    @Override
    public void continueState(final DataOutput dataOutput) {
        if (dataOutput.buyProperty().isPresent()) {
            modelState.doAction(Optional.of(dataOutput));
        }
        modelState.closeState();
    }

}
