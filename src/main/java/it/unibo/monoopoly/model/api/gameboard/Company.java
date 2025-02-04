package it.unibo.monoopoly.model.api.gameboard;

/**
 * Represents a company cell.
 */
public interface Company extends Buyable {

    /**
     * Calculate the amount to pay according to the roll of the dices.
     */
    void rollAndCalculate();

}
