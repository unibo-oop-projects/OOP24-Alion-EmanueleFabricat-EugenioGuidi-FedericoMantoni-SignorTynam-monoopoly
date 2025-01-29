package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Random;

import it.unibo.monoopoly.model.api.gameboard.Dices;

public class DicesImpl implements Dices{

    private Pair currentRoll;
    private int totalResult;

    public DicesImpl() {
        this.currentRoll = null;
        this.totalResult = 0;
    }

    @Override
    public void rollDices() {
        Random random = new Random();
        int firstRoll = random.nextInt(6) + 1;
        int secondRoll = random.nextInt(6) + 1;
        this.totalResult = firstRoll + secondRoll;
        this.currentRoll = new Pair(firstRoll, secondRoll);
    }

    @Override
    public Pair getDices() {
        return this.currentRoll;
    }

    @Override
    public int getResult() {
        return this.totalResult;
    }

}
