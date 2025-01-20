package it.unibo.monoopoly.model.impl;

import java.util.Optional;

import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

public class NotaryImpl implements Notary{

    @Override
    public boolean isOtherProperty(Player player, Buyable cell) {
        Optional<Player> owner = cell.getOwner();
        return owner.isPresent() && !cell.get().equals(player);
    }

    @Override
    public void buyProperty(Player player, Buyable cell) {
        
    }

}
