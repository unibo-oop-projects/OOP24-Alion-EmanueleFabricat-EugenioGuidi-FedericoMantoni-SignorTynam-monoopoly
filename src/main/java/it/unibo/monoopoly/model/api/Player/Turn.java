package it.unibo.monoopoly.model.api.Player;

/**
 * Interface representing the turn of a player.
 */
public interface Turn {

    /**
     * Executes the move phase of the player's turn.
     */
    void movePhase();

    /**
     * Executes the construction phase of the player's turn.
     */
    void constructPhase();

    /**
     * Rolls the dice for the player's turn.
     * 
     * @return the result of the dice roll
     */
    int rollDice();

    /**
     * Gets the current phase of the player's turn.
     * 
     * @return the current phase
     */
    Player getPhase();
}
