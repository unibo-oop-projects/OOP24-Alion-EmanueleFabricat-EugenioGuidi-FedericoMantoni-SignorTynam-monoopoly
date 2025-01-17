package it.unibo.monoopoly.model.api.player;

/**
 * Represents the bank account of a player in the game.
 */
public interface BankPlayer {

    /**
     * Retrieves the current balance of the player's bank account.
     *
     * @return the current bank account balance.
     */
    int getBankAccountBalance();

    /**
     * Checks if the player has sufficient funds to pay a specified amount.
     *
     * @return true if the player can pay, false otherwise.
     */
    boolean canPay();

    /**
     * Retrieves the total amount of money the player possesses, including cash and bank account balance.
     *
     * @return the total amount of money.
     */
    int getTotalMoney();
}
