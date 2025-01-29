package it.unibo.monoopoly.model.api.gameboard;

import it.unibo.monoopoly.model.api.player.Player;

public interface GameBoard {

    /**
     * method that return the return the cell in the index position.
     * 
     * @param index, index of cell
     * @return the cell in the index position
     */
    Cell getCell(int index);

    /**
     * method that remove a player from the game.
     * 
     */
    void removePlayer();

    /**
     * method that control if the game is ended controlling the number of player remaining.
     * 
     * @return true if the game is ended.
     */
    boolean isGameEnded();

    /**
     * 
     * @return next player to play.
     */
    Player getNextPlayer();

    /**
     * 
     * @return current player to play
     */
    Player getCurrentPlayer();

}
