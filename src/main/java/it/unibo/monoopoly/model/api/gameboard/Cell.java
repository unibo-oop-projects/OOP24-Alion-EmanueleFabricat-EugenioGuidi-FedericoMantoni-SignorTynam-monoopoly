package it.unibo.monoopoly.model.api.gameboard;

/**
 * Cell interface.
 */

public interface Cell {

    /**
     * 
     * @return if the cell is a {@code Buyable} property
     */
    boolean isBuyable();

    /**
     * 
     * @return if the cell is a {@code Buildable} property
     */
    boolean isBuildable();

}
