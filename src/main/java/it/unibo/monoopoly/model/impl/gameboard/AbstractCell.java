package it.unibo.monoopoly.model.impl.gameboard;

import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.Company;
import it.unibo.monoopoly.model.api.gameboard.Railroad;

/**
 * Abstract class implementing common methods of a generic {@link Cell}.
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

    @Override
    public boolean isCompany() {
        return this instanceof Company;
    }

    @Override
    public boolean isRailroad() {
        return this instanceof Railroad;
    }

}
