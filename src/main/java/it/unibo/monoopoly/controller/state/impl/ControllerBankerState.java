package it.unibo.monoopoly.controller.state.impl;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
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
 * Implementation of {@link ControllerState} for the banker:
 * that call the {@link ModelState} and {@link ViewState} methods,
 * in the right order,
 * with the right input.
 * Build with {@link DataBuilderInput} all the data that need the view.
 */
public class ControllerBankerState implements ControllerState {
    private final MainController mainController;
    private final ModelState actualModelState;
    private final ViewState actualViewState;
    private final GameBoard gameBoard;
    private final DataBuilderInput dataBuilderInput = new DataBuilderInputImpl();

    /**
     * Constructor of the class that sets the fields.
     * @param mainController   the main controller to be set.
     * @param actualModelState the actual {@link ModelState} to be set.
     * @param actualViewState  the actual {@link ViewState} to be set.
     * @param gameBoard        the {@link GameBoard} to be set.
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
                    .cellMap(cellListChooser(event))
                    .build();
            case Event.MORTGAGE_PROPERTY -> this.dataBuilderInput
                    .event(event)
                    .cellMap(cellListChooser(event))
                    .build();
            case Event.BANKRUPT -> this.dataBuilderInput
                    .event(event)
                    .build();
            default -> this.dataBuilderInput.build();
        };
    }

    private Map<Integer, Integer> cellListChooser(final Event event) {
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

    private Map<Integer, Integer> sellHouseList() {
        return unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
                .filter(p -> p instanceof Buildable)
                .map(p -> (Buildable) p)
                .filter(p -> p.getHousesNumber() > 0)
                .collect(Collectors.toMap(this.gameBoard.getCellsList()::indexOf, this::getHouseIncome));
    }

    private int getHouseIncome(final Buildable property) {
        return property.getSellHouseCost();
    }

    private Map<Integer, Integer> propertiesMortgageableList() {
        return unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
                .collect(Collectors.toMap(this.gameBoard.getCellsList()::indexOf, this::getMortgageIncome));
    }

    private int getMortgageIncome(final Buyable property) {
        return property.getMortgageValue();
    }

}
