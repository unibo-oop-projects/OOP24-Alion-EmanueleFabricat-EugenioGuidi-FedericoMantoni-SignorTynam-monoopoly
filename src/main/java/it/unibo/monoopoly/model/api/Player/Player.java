package it.unibo.monoopoly.model.api.Player;

/**
 * Represents the player of the game.
 */
public interface Player {

    /**
     * @return the name of the player.
     */
    public String getName();

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
    public boolean isPayable();

    /**
     * Deducts the specified amount from the player's money.
     * 
     * @param amount the amount to be deducted.
     */
    public void pay(int amount);
}