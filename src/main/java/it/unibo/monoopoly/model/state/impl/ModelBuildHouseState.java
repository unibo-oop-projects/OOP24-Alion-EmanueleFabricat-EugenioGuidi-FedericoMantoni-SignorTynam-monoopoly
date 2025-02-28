package it.unibo.monoopoly.model.state.impl;

import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;

/**
 * Implementation of the model state for building houses.
 * Handles the logic for checking if house construction is possible and executing the action.
 */
public class ModelBuildHouseState implements ModelState {

    private static final int MAX_HOUSES = 5;
    private final MainModel model;
    private boolean canBuild;

    /**
     * Constructs the state for house building.
     * 
     * @param model the main game model
     */
    public ModelBuildHouseState(final MainModel model) {
        this.model = model;
    }

    /**
     * Verifies if the current player has properties on which houses can be built.
     * 
     * @return true if house building is possible, false otherwise
     */
    @Override
    public boolean verify() {
        final Player currentPlayer = model.getGameBoard().getCurrentPlayer();
        final Set<Buildable> buildableProperties = currentPlayer.getProperties().stream()
                .filter(p -> p instanceof Buildable)
                .map(p -> (Buildable) p)
                .filter(p -> p.getHousesNumber() < MAX_HOUSES && !p.isMortgaged())
                .filter(p -> currentPlayer.isPayable(p.getHouseCost()))
                .collect(Collectors.toSet());
        canBuild = !buildableProperties.isEmpty();
        return canBuild;
    }

    /**
     * Executes the action of building a house on the selected property.
     * 
     * @param data the data related to the selected cell
     */
    @Override
    public void doAction(final DataOutput data) {
        if (canBuild && data.cellChoose().isPresent()) {
            final int cellIndex = data.cellChoose().get();
            final Buildable property = (Buildable) (model.getGameBoard().getCell(cellIndex));
            property.buildHouse();
            model.getGameBoard().getCurrentPlayer().pay(property.getHouseCost());
        } else {
            canBuild = false;
        }
    }

    /**
     * Closes the current state and sets the next state.
     */
    @Override
    public void closeState() {
        if (!canBuild) {
            model.nextTurn();
        } else {
            model.setState(new ModelBuildHouseState(model));
        }
    }
}
