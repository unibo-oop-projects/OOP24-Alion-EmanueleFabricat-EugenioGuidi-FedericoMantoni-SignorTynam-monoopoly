package it.unibo.monoopoly.model.gameboard.api;

import java.util.List;

import it.unibo.monoopoly.model.player.api.Player;

/**
 * This interface rapresents the game board of the game.
 * Save the current player in turn amd check if the game is ended.
 */
public interface GameBoard {

    /**
     * @param index
     * @return cell in index position.
     */
    Cell getCell(int index);

    /**
     * remove a player from the game.
     */
    void removePlayer();

    /**
     * control if the game is ended checking the number of player remaining.
     * @return true if the game is ended.
     */
    boolean isGameEnded();

    /**
     * @return next player to play.
     */
    Player getNextPlayer();

    /**
     * @return current player to play.
     */
    Player getCurrentPlayer();

    /**
     * @return list of players in game.
     */
    List<Player> getPlayersList();

    /**
     * @return list of names of cells
     */
    List<String> getCellsNames();

}
