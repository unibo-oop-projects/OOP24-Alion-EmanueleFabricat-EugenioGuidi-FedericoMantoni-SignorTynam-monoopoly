package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

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

    @Override
    public int getRentalValue() {
        if(!isAvailable()) {
            return calculateRentalValue();
        } else {
            throw new IllegalStateException("The property must be owned by a player");
        }
    }

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
        return (int) (this.cost / 2);
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

}
