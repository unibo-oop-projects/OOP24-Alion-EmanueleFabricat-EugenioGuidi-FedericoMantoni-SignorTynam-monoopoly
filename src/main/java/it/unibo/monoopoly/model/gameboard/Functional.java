package it.unibo.monoopoly.model.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.common.Message;
/**
 * Represents the cells of the gameboard not buyable.
 */
public interface Functional extends Cell {

    /**
     * @return the action triggered by the cell in question.
     */
    Optional<Message> getAction();

    /**
     * 
     * @return if the cell trigger an action.
     */
    boolean hasAction();

}
