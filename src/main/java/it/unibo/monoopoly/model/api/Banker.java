package it.unibo.monoopoly.model.api;


import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

/**
 * Interface that implements a banker who help the player decide witch house sell or properties mortagage.
 */
public interface Banker {
    /**
     * Select the right Operations to pay the amount.
     * 
     * @param player on which to perform the operation.
     * @param amount to subtract from player.
     * @return the {@link Message} to {@link Turn}.
     */
    Optional<Event> selectOperations(Player player, int amount);
    /**
     * Sell a house on the given input property, and pay the player.
     * 
     * @param property to sell.
     * @param player to pay.
     */
    void sellHouse(Buildable property, Player player);
    /**
     * Mortgage the given input property, and pay the player.
     * 
     * @param property to be mortgaged.
     * @param player to pay.
     */
    void mortgageProperty(Buyable property, Player player);
}
