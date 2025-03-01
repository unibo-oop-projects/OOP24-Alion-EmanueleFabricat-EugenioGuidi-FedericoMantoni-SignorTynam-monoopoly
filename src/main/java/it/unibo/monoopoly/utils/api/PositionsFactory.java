package it.unibo.monoopoly.utils.api;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import it.unibo.monoopoly.utils.impl.Position;

/**
 * create Position.
 */
public interface PositionsFactory {

    Map<Color, List<Position>> createPlayersPositions();

    Map<Integer, Position> createPropertyPositions();

    Map<Integer, Position> createHousesPositions();

    Map<Color, Position> createPrisonPositions();

}
