package it.unibo.monoopoly.model.api.gameboard;

public interface Dice {

    /**
     * 
     * @return the roll of the dice
     */
    Pair<Integer,Integer> rollDice();

}