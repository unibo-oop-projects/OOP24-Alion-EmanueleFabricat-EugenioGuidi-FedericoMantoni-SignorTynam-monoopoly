package it.unibo.monoopoly.model.gameboard.impl;

import java.util.Random;

import it.unibo.monoopoly.model.gameboard.api.Dices;

/**
 * This class implement the {@link Dices} interface to simulate dice rolling in the game.
 */
public class DicesImpl implements Dices {

    static final int DICE_FACES = 6;

    private Pair currentRoll;
    private int totalResult;
    private final Random random = new Random();

    /**
     * Initialize the two fields.
     */
    public DicesImpl() {
        this.currentRoll = null;
        this.totalResult = 0;
    }

    /**
     * Create two random int like rolling real dices.
     */
    @Override
    public void rollDices() {
        final int firstRoll = this.random.nextInt(DICE_FACES) + 1;
        final int secondRoll = this.random.nextInt(DICE_FACES) + 1;
        this.totalResult = firstRoll + secondRoll;
        this.currentRoll = new Pair(firstRoll, secondRoll);
    }

    /**
     * @return the Pair of dices rolled.
     */
    @Override
    public Pair getDices() {
        return this.currentRoll;
    }

    /**
     * @return the sum of two dices rolled.
     */
    @Override
    public int getResult() {
        return this.totalResult;
    }

}
