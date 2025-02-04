package it.unibo.monoopoly.model.api.gameboard;

import it.unibo.monoopoly.utils.Message;
/**
 * Represents the cells of the gameboard not buyable.
 */
public interface Functional extends Cell {

    /**
     * @return the action triggered by the cell in question.
     */
    Message getAction();

    /**
     * 
     * @return if the cell trigger an action.
     */
    boolean hasAction();

}
