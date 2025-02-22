package it.unibo.monoopoly.view.panel.api;

import java.util.List;

import it.unibo.monoopoly.view.panel.impl.GameBoardPanel.Position;

/**
 * create Position.
 */
public interface PositionsFactory {
    /**
     * @return {@link List} of {@link Position}.
     */
    List<Position> createPositions();
}
