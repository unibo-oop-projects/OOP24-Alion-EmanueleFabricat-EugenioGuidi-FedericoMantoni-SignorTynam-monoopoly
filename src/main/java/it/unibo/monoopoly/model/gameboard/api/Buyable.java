package it.unibo.monoopoly.model.gameboard.api;

import java.util.Optional;

import it.unibo.monoopoly.model.player.api.Player;

/**
 * Represents the buyable cells of the gameboard implementing
 * {@link Cell} interface.
 */
public interface Buyable extends Cell {

    /**
     * @return true if is buyable.
     */
    boolean isAvailable();

    /**
     * @return true if the property is already mortgaged.
     */
    boolean isMortgaged();

    /**
     * @return the owner of property.
     */
    Optional<Player> getOwner();

    /**
     * @return the cost of property.
     */
    int getCost();

    /**
     * @param ownerPlayer
     */
    void setOwner(Optional<Player> ownerPlayer);

    /**
     * @return the value of rent the property.
     */
    int getRentalValue();

    /**
     * @return the mortgage value.
     */
    int getMortgageValue();

    /**
     * method that set the mortgage of property.
     */
    void setMortgage();

    /**
     * remove the mortgage of property.
     */
    void removeMortgage();

    /**
     * @return the 10% incremented of mortgage value.
     */
    int getUnmortgageValue();

}
