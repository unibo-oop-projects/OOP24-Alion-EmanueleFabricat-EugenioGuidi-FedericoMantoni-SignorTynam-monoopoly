package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

public abstract class AbstractBuyable implements Buyable{

    private Optional<Player> owner;
    private final int cost;
    private final int mortgageValue;

    public AbstractBuyable(final int cost, final int mortgageValue) {
        this.owner = Optional.empty();
        this.cost = cost;
        this.mortgageValue = mortgageValue;
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
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void mortgage() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setOwner(Optional<Player> ownerPlayer) {
        // TODO Auto-generated method stub
        
    }

}
