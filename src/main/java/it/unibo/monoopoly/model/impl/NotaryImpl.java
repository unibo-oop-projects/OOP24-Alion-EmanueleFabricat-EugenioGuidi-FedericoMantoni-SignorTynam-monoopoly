package it.unibo.monoopoly.model.impl;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

public class NotaryImpl implements Notary{

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Event> checkProperty(Player player, Buyable cell) {
        Optional<Player> owner = cell.getOwner();
        if (owner.isEmpty() && player.isPayable(cell.getCost())) {
            return Optional.of(Event.BUY_PROPERTY);
        } else if (owner.get().equals(player)) {
            return Optional.empty();
        } else {
            final int amount = cell.getRentalValue();
            if (player.isPayable(amount)) {
                player.pay(amount);
                return Optional.of(Event.RENT_PAYMENT);
            } else {
                player.pay(amount);
                return Optional.of(Event.NO_LIQUIDITY);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void buyProperty(Player player, Buyable cell) {
        player.pay(cell.getCost());
        cell.setOwner(Optional.of(player));
    }

}
