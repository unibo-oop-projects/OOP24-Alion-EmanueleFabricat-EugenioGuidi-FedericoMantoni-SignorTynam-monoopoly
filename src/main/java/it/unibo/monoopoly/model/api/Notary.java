package it.unibo.monoopoly.model.api;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.gameboard.Buyable;
import it.unibo.monoopoly.model.gameboard.Cell;

/**
 * Manage the operations of buying properties and pay.
 */
public interface Notary {

    /**
     * Tells how the active {@link Player} is going to interacte with the {@link Buyable} property is on.
     * @param player the player to check
     * @param cell the cell of the property to check
     * @return the type of event if this occurs
     */
    Optional<Event> checkBuyedProperty(Player player, Cell cell);

    /**
     * Set the given player as owner of the property.
     * @param player the player who buys
     * @param cell the property to buy
     */
    void buyProperty(Player player, Buyable cell);

    boolean isActionBuy(Cell cell, Player actualPlayer);

}
