package it.unibo.monoopoly.model.api.gameboard;

/**
 * Cell interface.
 */

public interface Cell {

    /**
     * 
     * @return if the cell is a {@link Buyable} property
     */
    boolean isBuyable();

    /**
     * 
     * @return if the cell is a {@link Buildable} property
     */
    boolean isBuildable();

}
