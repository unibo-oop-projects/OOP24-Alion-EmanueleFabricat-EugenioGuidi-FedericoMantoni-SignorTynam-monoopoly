package it.unibo.monoopoly.view.panel.api;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import it.unibo.monoopoly.view.panel.impl.GameBoardPanel.Position;

/**
 * create Position.
 */
public interface PositionsFactory {

    Map<Color, Map<Integer, Position>> createPlayersPositions();

    Map<Integer, Position> createPropertyPositions();

    Map<Integer, Position> createHousesPositions();

    Map<Color, Position> createPrisonPositions();

}
