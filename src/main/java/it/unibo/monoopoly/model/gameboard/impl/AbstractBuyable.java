package it.unibo.monoopoly.model.gameboard.impl;

import java.util.Optional;

import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.player.api.Player;

/**
 * Abstract class implementing methods common to all {@link Buyable} cells.
 */
public abstract class AbstractBuyable extends AbstractCell implements Buyable {

    private Optional<Player> owner;
    private final int cost;
    private boolean mortgaged;

    /**
     * Constructor of a {@link Buyable} cell.
     * @param name the name of the cell
     * @param cost the cost of the property
     */
    public AbstractBuyable(final String name, final int cost) {
        super(name);
        this.owner = Optional.empty();
        this.cost = cost;
        this.mortgaged = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getCost() {
        return this.cost;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Player> getOwner() {
        return this.owner;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAvailable() {
        return this.owner.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isMortgaged() {
        return this.mortgaged;
    }

    /**
     * Check if the current class has an owner, if not there is an error.
     */
    @Override
    public int getRentalValue() {
        if (!isAvailable()) {
            return calculateRentalValue();
        } else {
            throw new IllegalStateException("The property must be owned by a player");
        }
    }

    /**
     * @return the relative rental of property.
     */
    public abstract int calculateRentalValue();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMortgage() {
        this.mortgaged = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMortgageValue() {
        return this.cost / 2;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMortgage() {
        this.mortgaged = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOwner(final Optional<Player> ownerPlayer) {
        this.owner = ownerPlayer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getUnmortgageValue() {
        return (this.cost * 110) / 100;
    }

}
