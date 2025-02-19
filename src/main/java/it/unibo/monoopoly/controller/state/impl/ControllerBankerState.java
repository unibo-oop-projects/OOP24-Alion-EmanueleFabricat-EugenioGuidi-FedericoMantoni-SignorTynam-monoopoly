package it.unibo.monoopoly.controller.state.impl;

import java.util.List;
import java.util.Optional;
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
import it.unibo.monoopoly.model.player.api.Player;
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
    private final Event event;
    private boolean payable;
    private final DataBuilderInput dataBuilderInput = new DataBuilderInputImpl();

    /**
     * comment.
     * 
     * @param mainController
     */
    public ControllerBankerState(final MainController mainController, final ModelState actualModelState,
            final ViewState actualViewState, final GameBoard gameBoard, final Event event) {
        this.mainController = mainController;
        this.actualModelState = actualModelState;
        this.actualViewState = actualViewState;
        this.gameBoard = gameBoard;
        this.event = event;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void startState() {
        this.payable = this.actualModelState.verify();
        this.actualViewState.setMode(this.payable);
        this.actualViewState.visualize(buildData());
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

    private DataInput buildData() {
        return switch(this.event) {
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

    private List<Integer> cellListChoser(Event event){
        return switch(event) {
            case Event.SELL_HOUSE -> sellHouseList();
            case Event.MORTGAGE_PROPERTY -> propertiesMortgageableList();
            default -> List.of();
        };
    }

    /*
     * private Optional<List<Integer>> cellToIndex(final Optional<List<Buyable>>
     * propertyList) {
     * return Optional.of(
     * propertyList.get().stream()
     * .map(this.gameBoard.getCellList()::indexOf) //aspetto implementazione
     * .toList());
     * }
     */

    private Stream<Buyable> unmortgagedList(final Set<Buyable> properties) {
        return properties.stream()
                .filter(p -> p instanceof Buildable)
                .filter(p -> !p.isMortgaged());
    }

    private List<Integer> sellHouseList() {
        return unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
                .map(p -> (Buildable) p)
                .filter(p -> p.getHousesNumber() > 0)
                .map(p -> (Buyable) p)
                .map(this.gameBoard.getCellsList()::indexOf) //aspetto implementazione
                .toList();
    }

    public List<Integer> propertiesMortgageableList() {
        return Stream.concat(unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
                    .filter(p -> !(p instanceof Buildable)),
                unmortgagedList(this.gameBoard.getCurrentPlayer().getProperties())
                    .filter(p -> p instanceof Buildable)
                    .map(p -> (Buildable) p)
                    .filter(p -> p.getHousesNumber() == 0)
                    .map(p -> (Buyable) p))
                .map(this.gameBoard.getCellsList()::indexOf) //aspetto implementazione
                .toList();
    }

}
