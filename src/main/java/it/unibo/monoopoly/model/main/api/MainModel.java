package it.unibo.monoopoly.model.main.api;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;

/**
 * Interface representing the turn of a player.
 */
public interface MainModel {
    /**
     * Gets the current {@link ModelState}.
     * 
     * @return the current {@link ModelState}.
     */
    ModelState getState();

    /**
     * Set the {@link ModelState} of the model.
     * 
     * @param state to set.
     */
    void setState(ModelState state);

    /**
     * Gets the {@link GameBoard}.
     * 
     * @return the {@link GameBoard}.
     */
    GameBoard getGameBoard();

    /**
     * 
     * @return the actual event occurring.
     */
    Optional<Event> getEvent();

    /**
     * 
     * @param selectOperations the new event setted.
     */
    void setEvent(Event selectOperations);

    /**
     * Correctly finish a turn and set the {@link ModelState}.
     */
    void nextTurn();

}
