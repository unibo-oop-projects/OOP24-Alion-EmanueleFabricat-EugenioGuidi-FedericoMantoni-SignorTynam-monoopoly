package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Dices;

public class DiceImpl implements Dices{

    private Optional<Pair> currentRoll;

    public DiceImpl() {
        this.currentRoll = Optional.empty();
    }

    @Override
    public Void rollDices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rollDice'");
    }

    @Override
    public Optional<Pair> getDices() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDices'");
    }

}
