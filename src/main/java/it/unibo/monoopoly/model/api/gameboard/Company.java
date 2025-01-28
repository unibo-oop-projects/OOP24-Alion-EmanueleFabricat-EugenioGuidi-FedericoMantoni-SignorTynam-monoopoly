package it.unibo.monoopoly.model.api.gameboard;

/**
 * Represents a company cell
 */
public interface Company extends Buyable {

    int rollAndCalculate();

}
