package it.unibo.monoopoly.controller.state.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * missing comment.
 */
public class ControllerBankerState implements ControllerState {
    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final GameBoard gameBoard;
    private final DataBuilderInput dataBuilderInput = new DataBuilderInputImpl();

    /**
     * 
     * @param mainController   the main controller
     * @param actualModelState the actual {@link ModelState}
     * @param actualViewState  the actual {@link ViewState}
     * @param gameBoard        the {@link GameBoard}
     */
    public ControllerBankerState(final MainController mainController, final ModelState actualModelState,
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
        mainController.nextPhase();

    }

    private DataInput buildData() {
        if (this.mainController.getActualEvent().isEmpty()) {
            return this.dataBuilderInput.build();
        }
        final Event event = this.mainController.getActualEvent().get();
        return switch (event) {
            case Event.SELL_HOUSE -> this.dataBuilderInput
                    .event(event)
                    .cellList(cellListChoser(event))
                    .build();
            case Event.MORTGAGE_PROPERTY -> this.dataBuilderInput
                    .event(event)
                    .cellList(cellListChoser(event))
                    .build();
            case Event.BANKRUPT -> this.dataBuilderInput
                    .event(event)
                    .build();
            default -> this.dataBuilderInput.build();
        };
    }

    private List<Integer> cellListChoser(final Event event) {
        return switch (event) {
            case Event.SELL_HOUSE -> sellHouseList();
            case Event.MORTGAGE_PROPERTY -> propertiesMortgageableList();
            default -> throw new IllegalStateException(
                    "It's impossible to create a list of cells to show in ControllerBankerState without an Event");
        };
    }

    private Stream<Buyable> unmortgagedList(final Set<Buyable> properties) {
        return properties.stream()
                .filter(p -> p instanceof Buildable)
                .filter(p -> !p.isMortgaged());
    }

    private List<Integer> sellHouseList() {
        System.out.println("\n\n\nhouse\n" + unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
        .filter(p -> p instanceof Buildable)
        .map(p -> (Buildable) p)
        .filter(p -> p.getHousesNumber() > 0)
        .map(this.gameBoard.getCellsList()::indexOf)
        .toList());
        return unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
                .filter(p -> p instanceof Buildable)
                .map(p -> (Buildable) p)
                .filter(p -> p.getHousesNumber() > 0)
                .map(this.gameBoard.getCellsList()::indexOf)
                .toList();
    }

    private List<Integer> propertiesMortgageableList() {
        System.out.println("\n\n\nunmortgage\n" + unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
        .map(this.gameBoard.getCellsList()::indexOf)
        .toList());
        return unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
                .map(this.gameBoard.getCellsList()::indexOf)
                .toList();
    }

}
