package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

public abstract class AbstractBuyable implements Buyable{

    private Optional<Player> owner;
    private final int cost;
    private boolean mortgaged;

    public AbstractBuyable(final int cost) {
        this.owner = Optional.empty();
        this.cost = cost;
        this.mortgaged = false;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public Optional<Player> getOwner() {
        return this.owner;
    }

    @Override
    public boolean isBuyable() {
        return this.owner.isEmpty();
    }

    @Override
    public boolean isMortaged() {
        return this.mortgaged;
    }

    @Override
    public void setMortgage() {
        this.mortgaged = true;
    }

    @Override
    public void removeMortgage() {
        this.mortgaged = false;
    }

    @Override
    public void setOwner(Optional<Player> ownerPlayer) {
        this.owner = ownerPlayer;
    }

}
