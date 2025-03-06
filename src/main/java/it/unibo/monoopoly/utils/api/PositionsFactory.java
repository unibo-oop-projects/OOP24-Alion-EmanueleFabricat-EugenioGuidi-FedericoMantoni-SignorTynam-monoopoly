package it.unibo.monoopoly.utils.api;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import it.unibo.monoopoly.utils.impl.Position;

/**
 * create Position.
 */
public interface PositionsFactory {

    /**
     * create map to associate to all color the relative list of all possible position
     * in the gameboard.
     * @return map of all position based on color.
     */
    Map<Color, List<Position>> createPlayersPositions();

    /**
     * create map to associate for all cell buyable the position of possible owner.
     * @return map of all position of property.
     */
    Map<Integer, Position> createPropertyPositions();

    /**
     * create map to associate for all cell buildable the position of possible
     * houses number.
     * @return map of all position of number.
     */
    Map<Integer, Position> createHousesPositions();

    /**
     * create map to associate for all color the position in prison.
     * @return map of position of prison.
     */
    Map<Color, Position> createPrisonPositions();

}
