package it.unibo.monoopoly.model.api.gameboard;

import java.util.Optional;

public interface Buyable {

    /**
     * method that return if is buyable.
     * 
     * @return true if is buyable
     */
    public boolean isBuyable();

    /**
     * method that return the owner of property.
     * 
     * @return the owner of property
     */
    public Optional<Player> getOwner();

    /**
     * method that return the cost of property.
     * 
     * @return the cost of property
     */
    public int getCost();

    /**
     * method that set the owner of property.
     * 
     * @param ownerPlayer
     */
    public void setOwner(Optional<player> ownerPlayer);

    /**
     * method that return the rent of ther property.
     * 
     * @return the value of rent the property
     */
    public int getTRentalValue();

    /**
     * method that set the mortgage of property.
     * 
     */
    public void mortgage();

    /**
     * method that return the mortgage value.
     * 
     * @return the mortgage value
     */
    public int getMortgageValue();

}
