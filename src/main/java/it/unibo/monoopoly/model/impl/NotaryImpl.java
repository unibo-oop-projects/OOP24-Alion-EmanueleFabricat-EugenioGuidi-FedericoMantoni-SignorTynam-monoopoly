package it.unibo.monoopoly.model.impl;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

/**
 * Implementation of {@link Notary} interface.
 */
public class NotaryImpl implements Notary {

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Event> checkProperty(final Player player, final Buyable cell) {
        final Optional<Player> owner = cell.getOwner();
        if (owner.isEmpty() && player.isPayable(cell.getCost())) {
            return Optional.of(Event.BUY_PROPERTY);
        } else if (cell.isMortaged() || owner.get().equals(player)) {
            return Optional.empty();
        } else {
            return Optional.of(Event.RENT_PAYMENT);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void buyProperty(final Player player, final Buyable cell) {
        player.pay(cell.getCost());
        cell.setOwner(Optional.of(player));
    }

}
