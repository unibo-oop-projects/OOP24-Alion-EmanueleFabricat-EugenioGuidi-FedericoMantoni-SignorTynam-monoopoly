package it.unibo.monoopoly.model.api.gameboard;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;
import it.unibo.monoopoly.model.impl.gameboard.CompanyImpl;
import it.unibo.monoopoly.model.impl.gameboard.RailroadImpl;

@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
    @Type(value = BuildableImpl.class, name = "Buildable"),
    @Type(value = CompanyImpl.class, name = "Company"),
    @Type(value = RailroadImpl.class, name = "Railroad")
})

/**
 * Represents the buyable cells of the gameboard.
 */
public interface Buyable extends Cell {

    /**
     * method that return if is buyable.
     * 
     * @return true if is buyable
     */
    boolean isAvailable();

    /**
     * 
     * @return true if the property is already mortgaged
     */
    boolean isMortgaged();

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
    int getRentalValue();

    /**
     * 
     * @return the mortgage value
     */
    int getMortgageValue();

    /**
     * method that set the mortgage of property.
     * 
     */
    void setMortgage();

    /**
     * remove the mortgage of property.
     * 
     */
    void removeMortgage();

}
