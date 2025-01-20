package it.unibo.monoopoly.model.api;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

/**
 * Manage the operations of buying properties and pay
 */
public interface Notary {

    /**
     * Manages the sale or payment when a {@code Player} ends up in a {@code Buyable}
     * @param player the player who buys
     * @param cell the property to buy
     */
    void work(Player player, Buyable cell);

    

}
