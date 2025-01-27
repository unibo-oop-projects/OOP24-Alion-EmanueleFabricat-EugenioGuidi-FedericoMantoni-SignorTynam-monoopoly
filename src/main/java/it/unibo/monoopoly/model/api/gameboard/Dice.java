package it.unibo.monoopoly.model.api.gameboard;

public interface Dice {

    record Pair<T, U> (T firstRoll, U secondRoll){}

    /**
     * 
     * @return the roll of the dice
     */
    Pair<Integer,Integer> rollDice();

}