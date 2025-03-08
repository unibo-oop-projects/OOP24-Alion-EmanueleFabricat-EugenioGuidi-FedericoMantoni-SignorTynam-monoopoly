package it.unibo.monoopoly.model.gameboard.api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import it.unibo.monoopoly.model.gameboard.impl.BuildableImpl;
import it.unibo.monoopoly.model.gameboard.impl.CompanyImpl;
import it.unibo.monoopoly.model.gameboard.impl.FunctionalImpl;
import it.unibo.monoopoly.model.gameboard.impl.RailroadImpl;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Cell interface.
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = BuildableImpl.class, name = "Buildable"),
        @Type(value = CompanyImpl.class, name = "Company"),
        @Type(value = RailroadImpl.class, name = "Railroad"),
        @Type(value = FunctionalImpl.class, name = "Functional")
})
public interface Cell {

    /**
     * @return the name of the cell.
     */
    String getName();

    /**
     * @return if the cell is a {@link Buyable} property
     */
    boolean isBuyable();

    /**
     * @return if the cell is a {@link Buildable} property
     */
    boolean isBuildable();

    /**
     * @return if the cell is a buyable {@link Railroad}
     */
    boolean isRailroad();

    /**
     * @return if the cell is a buyable {@link Company}
     */
    boolean isCompany();

}
