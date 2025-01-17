package it.unibo.monoopoly.model.api.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.player.Player;

public interface Buyable {

    /**
     * method that return if is buyable.
     * 
     * @return true if is buyable
     */
    boolean isBuyable();

    /**
     * method that return the owner of property.
     * 
     * @return the owner of property
     */
    Optional<Player> getOwner();

    /**
     * method that return the cost of property.
     * 
     * @return the cost of property
     */
    int getCost();

    /**
     * method that set the owner of property.
     * 
     * @param ownerPlayer
     */
    void setOwner(Optional<Player> ownerPlayer);

    /**
     * method that return the rent of ther property.
     * 
     * @return the value of rent the property
     */
    int getTRentalValue();

    /**
     * method that set the mortgage of property.
     * 
     */
    void mortgage();

    /**
     * method that return the mortgage value.
     * 
     * @return the mortgage value
     */
    int getMortgageValue();

}
