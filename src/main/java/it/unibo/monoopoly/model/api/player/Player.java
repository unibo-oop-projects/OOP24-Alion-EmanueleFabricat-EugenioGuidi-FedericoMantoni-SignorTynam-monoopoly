package it.unibo.monoopoly.model.api.player;

import java.util.Optional;

/**
 * Represents the player of the game.
 */
public interface Player {

    /**
     * @return the name of the player.
     */
    public Optional<String> getName();

    /**
     * @return the amount of money the player has.
     */
    public int getMoneyAmount();

    /**
     * @return the current position of the player.
     */
    public int getActualPosition();

    /**
     * @return true if the player is in prison, false otherwise.
     */
    public boolean isPrisoned();

    /**
     * @return true if the player can pay, false otherwise.
     */
    public boolean isPayable(int amount);

    /**
     * Deducts the specified amount from the player's money.
     * 
     * @param amount the amount to be deducted.
     */
    public void pay(int amount);

    /**
     * Adds the specified amount to the player's money.
     * 
     * @param amount the amount to be added.
     */
    public void receive(int amount);
}