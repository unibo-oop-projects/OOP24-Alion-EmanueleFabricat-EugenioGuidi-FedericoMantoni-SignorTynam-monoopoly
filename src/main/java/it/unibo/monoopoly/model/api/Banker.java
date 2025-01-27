package it.unibo.monoopoly.model.api;

import it.unibo.monoopoly.model.api.player.Player;

/**
 * Interface that implements a benker who help the player decide wich house sell or properties mortagage.
 */
public interface Banker {
    /**
     * Make with the palyer the operationes.
     * 
     * @param player from who to subtract the amount.
     * @param amount to subtract from player
     * @return the proceeds of the oparationes.
     */
    int selectOperations(Player player, int amount);
}
