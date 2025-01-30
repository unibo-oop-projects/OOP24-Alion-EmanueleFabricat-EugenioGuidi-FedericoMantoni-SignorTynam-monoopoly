package it.unibo.monoopoly.model.api;

import java.util.List;

import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.utils.Message;

/**
 * Interface that implements a benker who help the player decide wich house sell or properties mortagage.
 */
public interface Banker {
    /**
     * Select the right Operations to pay the amount.
     * 
     * @param player on which to perform the operation.
     * @param amount to subtract from player.
     * @return 
     */
    Message selectOperations(Player player, int amount);
    /**
     * Sell the given input house, and pay the player.
     * 
     * @param property to sell.
     * @param player to pay.
     */
    void sellHouse(Buildable proprety, Player player);
    /**
     * Mortgage the given input proprety, and pay the player.
     * 
     * @param proprety to be mortgaged.
     * @param palyer to pay.
     */
    void mortgageProprety(Buyable proprety, Player player);
}
