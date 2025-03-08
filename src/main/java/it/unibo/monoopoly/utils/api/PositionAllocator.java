package it.unibo.monoopoly.utils.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.unibo.monoopoly.utils.impl.NumberAndCirclePosition;

/**
 * It is used to create a class that takes lists of player {@link Position},
 * cells,
 * prison and houses and creates a list of objects that will be displayed on the
 * gameBoard.
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
