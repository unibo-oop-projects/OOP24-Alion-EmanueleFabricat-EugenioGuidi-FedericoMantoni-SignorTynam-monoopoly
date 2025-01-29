package it.unibo.monoopoly.model.impl.gameboard;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;

@JsonTypeInfo(
use = JsonTypeInfo.Id.NAME,
include = JsonTypeInfo.As.PROPERTY,
property = "type") // field name
@JsonSubTypes({
    @JsonSubTypes.Type(value = Buildable.class, name = "Buildable")
})

/**
 * Abstract class implementing common method of a generic {@link Cell}.
 */
public abstract class AbstractCell implements Cell {

    private final String name;

    /**
     * Constructor in common for any cell.
     * @param name the name of the cell
     */
    public AbstractCell(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBuildable() {
        return this instanceof Buildable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBuyable() {
        return this instanceof Buyable;
    }

}
