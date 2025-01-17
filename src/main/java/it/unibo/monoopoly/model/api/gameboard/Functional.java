package it.unibo.monoopoly.model.api.gameboard;

import it.unibo.monoopoly.model.api.player.Player;
/**
 * Represents the cells of the gameboard not buyable
 */
public interface Functional extends Cell{

    /**
     * Performs the action according to the cell in question
     * @param player the player target of the effects of the cell
     */
    void doAction(Player player);

}
