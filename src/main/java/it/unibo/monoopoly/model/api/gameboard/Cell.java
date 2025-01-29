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
     * @return if the cell is a {@link Buyable} property
     */
    boolean isBuyable();

    /**
     * 
     * @return if the cell is a {@link Buildable} property
     */
    boolean isBuildable();

    /**
     * 
     * @return if the cell is a buyable {@link Railroad}
     */
    boolean isRailroad();

    /**
     * 
     * @return if the cell is a buyable {@link Company}
     */
    boolean isCompany();

}
