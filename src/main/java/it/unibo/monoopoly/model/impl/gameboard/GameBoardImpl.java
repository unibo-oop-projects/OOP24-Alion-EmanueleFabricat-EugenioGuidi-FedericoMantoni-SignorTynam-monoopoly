package it.unibo.monoopoly.model.impl.gameboard;

import java.util.LinkedList;
import java.util.List;

import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.GameBoard;
import it.unibo.monoopoly.model.api.player.Player;

/**
 * This class implement the {@link GameBoard} interface to simulate the game board of Monopoly game.
 */
public class GameBoardImpl implements GameBoard {

    private final List<Cell> cellsList;
    private final List<Player> playersList;
    private int currentPlayerIndex;

    /**
     * Initialize the fields to save players and cells.
     * @param cellsList is the list of cells in the game board.
     * @param playersList is the list of players in the current game.
     */
    public GameBoardImpl(final List<Cell> cellsList, final List<Player> playersList) {
        this.cellsList = new LinkedList<>(cellsList);
        this.playersList = new LinkedList<>(playersList);
        this.currentPlayerIndex = 0;
    }

    /**
     * @return the cell in position index.
     */
    @Override
    public Cell getCell(final int index) {
        if (index < 0 || index > this.cellsList.size() - 1) {
            throw new IndexOutOfBoundsException("Index " + index + " not valid, it must be between 0 and 39 inclusive");
        }
        return cellsList.get(index);
    }

    /**
     * Remove the current player from the list of players.
     */
    @Override
    public void removePlayer() {
        this.playersList.remove(this.currentPlayerIndex);
        if (this.currentPlayerIndex != 0) {
            this.currentPlayerIndex--;
        } else {
            this.currentPlayerIndex = this.playersList.size() - 1;
        }
    }

    /**
     * @return true if the game is ended, when only one player remains.
     */
    @Override
    public boolean isGameEnded() {
        return this.playersList.size() < 2;
    }

    /**
     * @return the next player in game to paly.
     */
    @Override
    public Player getNextPlayer() {
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.playersList.size();
        return this.getCurrentPlayer();
    }

    /**
     * @return the current player in game to play.
     */
    @Override
    public Player getCurrentPlayer() {
        return this.playersList.get(this.currentPlayerIndex);
    }

}
