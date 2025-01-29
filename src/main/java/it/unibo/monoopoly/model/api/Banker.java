package it.unibo.monoopoly.model.api;

import java.util.List;

import it.unibo.monoopoly.model.api.gameboard.Buildable;
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
     * Sell a house of the selected proprety and retry the payment.
     * 
     * @param list of propreties.
     * @param selected proprety.
     * @return the {@link Message} returned after try the payment.
     */
    Message sellHouse(List<Buildable> list, int selected);
    /**
     * Bankruptcy the proprety selected and retry the payment.
     * 
     * @param list of propreties.
     * @param selected proprety.
     * @return the {@link Message} returned after try the payment.
     */
    Message bankruptcyPropreties(List<Buildable> list, int selected);
}
