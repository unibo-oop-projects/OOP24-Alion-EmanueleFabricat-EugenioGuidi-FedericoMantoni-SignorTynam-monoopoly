package it.unibo.monoopoly.model.turn.api;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.deck.api.Deck;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.player.api.Player;
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
     * Gets the actual {@link Player}.
     * 
     * @return the actual {@link Player}.
     */
    Player getActualPlayer();

    /**
     * Gets the list of all {@link cell} of the game.
     * 
     * @return the list of {@link cell}.
     */
    List<Cell> getCellsList();

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
     * Gets the {@link Deck}.
     * 
     * @return the {@link Deck}.
     */
    Deck getDeck();

    /**
     * 
     * @return the actual event occurring.
     */
    Optional<Event> getEvent();



}
