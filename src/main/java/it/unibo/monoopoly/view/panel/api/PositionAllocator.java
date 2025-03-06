package it.unibo.monoopoly.view.panel.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.unibo.monoopoly.view.panel.impl.NumberAndCirclePosition;

/**
 * It is used to create a class that takes lists of player positions, cells, prison and houses
 * and creates a list of objects that will be displayed on the gameBoard.
 */
public interface PositionAllocator {

    /**
     * 
     * @param newPlayersPositions
     * @param cellsOwners
     * @param prisonedPlayers
     * @param nBuiltHouses
     * @param mortgagedProperties
     * @return the list of all position to be displayed in gameBoard.
     */
    List<NumberAndCirclePosition> createListCircleNumberPosition(Map<String, Integer> newPlayersPositions,
                                                                 Map<Integer, Optional<String>> cellsOwners,
                                                                 List<String> prisonedPlayers,
                                                                 Map<Integer, Integer> nBuiltHouses,
                                                                 List<Integer> mortgagedProperties);
}
