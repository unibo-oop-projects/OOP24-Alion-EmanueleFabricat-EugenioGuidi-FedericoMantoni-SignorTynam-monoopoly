package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

public abstract class AbstractBuyable implements Buyable{

    private Optional<Player> owner;
    private final int cost;
    private final int mortgageValue;
    private boolean mortgaged;

    public AbstractBuyable(final int cost, final int mortgageValue) {
        this.owner = Optional.empty();
        this.cost = cost;
        this.mortgageValue = mortgageValue;
        this.mortgaged = false;
    }

    @Override
    public int getCost() {
        return this.cost;
    }

    @Override
    public int getMortgageValue() {
        return this.mortgageValue;
    }

    @Override
    public Optional<Player> getOwner() {
        return this.owner;
    }

    @Override
    public int getTRentalValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isBuyable() {
        return this.owner.isEmpty();
    }

    @Override
    public void setMortgage() {
        this.mortgaged = true;
    }

    @Override
    public void setOwner(Optional<Player> ownerPlayer) {
        // TODO Auto-generated method stub
        
    }

}
