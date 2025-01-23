package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

public abstract class AbstractBuyable implements Buyable{

    @Override
    public int getCost() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getMortgageValue() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Optional<Player> getOwner() {
        // TODO Auto-generated method stub
        return Optional.empty();
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
