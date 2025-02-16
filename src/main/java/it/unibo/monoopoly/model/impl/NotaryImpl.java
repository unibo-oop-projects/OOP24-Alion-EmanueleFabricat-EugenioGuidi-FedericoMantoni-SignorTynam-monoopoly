package it.unibo.monoopoly.model.impl;

import java.util.Objects;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.player.Player;

/**
 * Implementation of {@link Notary} interface.
 */
public class NotaryImpl implements Notary {


    /**
     * {@inheritDoc}
     */
    @Override
    public void buyProperty(final Player player, final Buyable cell) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(cell);
        if (cell.isAvailable()) {
            cell.setOwner(Optional.of(player));
            player.addProperty(cell);
        } else {
            throw new IllegalStateException("Property must be owned by the bank to be buyable");
        }

    }
        @Override
        public boolean isActionBuy(Cell cell, Player actualPlayer) {
        if (cell.isBuyable()) {
            final Buyable buyableCell = (Buyable) cell;
            return buyableCell.isAvailable() && actualPlayer.isPayable(buyableCell.getCost());
        } else {
            return false;
        }
    }

    public Optional<Event> checkBuyedProperty(final Player player, final Cell cell) {
        final Buyable buyableCell = (Buyable) cell;
        if (checkRentPayment(player, buyableCell)) {
            payOwner(buyableCell);
            return Optional.of(Event.RENT_PAYMENT);
        } else {
            return Optional.empty();
        }
    }

    private boolean checkRentPayment(Player player, Buyable cell) {
        return !cell.isMortgaged() && !cell.getOwner().get().equals(player);
    }

    private void payOwner(final Buyable buyableCell) {
        buyableCell.getOwner().get().receive(buyableCell.getRentalValue());
    }

}
