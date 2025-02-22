package it.unibo.monoopoly.view.panel.api;

import java.util.List;

/**
 * create Position.
 */
public interface PositionsFactory {
    /**
     * @return {@link List} of {@link Position}.
     */
    List<Position> createPositions();
}
