package it.unibo.monoopoly.model.api;


import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.common.Message;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.gameboard.Buildable;
import it.unibo.monoopoly.model.gameboard.Buyable;

/**
 * Interface that implements a banker who help the player decide witch house sell or properties mortagage.
 */
public interface Banker {
    /**
     * Select the right Operations to pay the amount.
     * 
     * @param player on which to perform the operation.
     * @return the {@link Message} to {@link Turn}.
     */
    Optional<List<Buyable>> selectOperations(Player player);
    /**
     * 
     * @param player from take the list of properties.
     * @return the {@link List} of the properties with houses of the {@link Player}.
     */
    List<Buyable> getPropertiesWithHome(Player player);
    /**
     * 
     * @param player from take the list of properties.
     * @return the {@link List} of the properties mortgageable of the {@link Player}.
     */
    List<Buyable> getPropertiesMortgageable(Player player);
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
