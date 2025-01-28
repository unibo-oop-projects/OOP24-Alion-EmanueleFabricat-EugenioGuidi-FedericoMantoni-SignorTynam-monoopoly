package it.unibo.monoopoly.model.impl;

import java.util.Objects;
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
        } else if (cell.isMortgaged() || owner.get().equals(player)) {
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
        Objects.requireNonNull(player);
        Objects.requireNonNull(cell);
        if (cell.isBuyable()) {
            player.pay(cell.getCost());
            cell.setOwner(Optional.of(player));
            player.addProperty(cell);
        } else {
            throw new IllegalStateException("Property must be owned by the bank to be buyable");
        }

    }

}
