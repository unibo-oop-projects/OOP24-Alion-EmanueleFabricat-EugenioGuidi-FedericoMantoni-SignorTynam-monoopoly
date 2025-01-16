package it.unibo.monoopoly.model.api.card;

public interface Dice {

    /**
     * method that is called to roll the dice
     * 
     * @return the roll of the dice
     */
    public Pair<Integer,Integer> rollDice();

}
