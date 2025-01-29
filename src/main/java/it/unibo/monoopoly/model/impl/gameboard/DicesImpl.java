package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;
import java.util.Random;

import it.unibo.monoopoly.model.api.gameboard.Dices;

public class DicesImpl implements Dices{

    private Pair currentRoll;

    public DicesImpl() {
        this.currentRoll = null;
    }

    @Override
    public void rollDices() {
        Random random = new Random();
        int firstRoll = random.nextInt(6) + 1;
        int secondRoll = random.nextInt(6) + 1;
        this.currentRoll = new Pair(firstRoll, secondRoll);
    }

    @Override
    public Pair getDices() {
        return this.currentRoll;
    }

}
