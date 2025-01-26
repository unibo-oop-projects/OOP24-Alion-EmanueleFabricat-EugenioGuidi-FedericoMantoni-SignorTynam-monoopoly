package it.unibo.monoopoly.model.api.gameboard;

/**
 * Cell interface.
 */

public interface Cell {

    /**
     * 
     * @return the name of the cell
     */
    String getName();

    /**
     * 
     * @return if the cell is a {@code Buyable} property
     */
    boolean isBuyable();

    /**
     * 
     * @return if the cell is a {@link Buildable} property
     */
    boolean isBuildable();

}
