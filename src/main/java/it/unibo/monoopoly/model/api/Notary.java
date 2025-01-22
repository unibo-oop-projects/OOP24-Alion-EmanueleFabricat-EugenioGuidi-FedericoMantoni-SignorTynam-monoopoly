package it.unibo.monoopoly.model.api;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

/**
 * Manage the operations of buying properties and pay.
 */
public interface Notary {

    /**
     * Tells if a property is owned by a {@code Player} different from a given one.
     * @param player the player to check
     * @param cell the cell of the property to check
     * @return if the property is not owned by the given player nor by the bank
     */
    boolean isOtherProperty(Player player, Buyable cell);

    /**
     * Set the given player as owner of the property.
     * @param player the player who buys
     * @param cell the property to buy
     */
    void buyProperty(Player player, Buyable cell);

}
