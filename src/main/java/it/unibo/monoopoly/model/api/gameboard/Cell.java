package it.unibo.monoopoly.model.api.gameboard;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;
import it.unibo.monoopoly.model.impl.gameboard.CompanyImpl;
import it.unibo.monoopoly.model.impl.gameboard.FunctionalImpl;
import it.unibo.monoopoly.model.impl.gameboard.RailroadImpl;

@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type")
@JsonSubTypes({
    @Type(value = BuildableImpl.class, name = "Buildable"),
    @Type(value = CompanyImpl.class, name = "Company"),
    @Type(value = RailroadImpl.class, name = "Railroad"),
    @Type(value = FunctionalImpl.class, name = "Functional")
})

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
