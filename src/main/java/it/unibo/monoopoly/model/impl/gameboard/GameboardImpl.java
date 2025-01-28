package it.unibo.monoopoly.model.impl.gameboard;

import java.util.List;

import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.GameBoard;
import it.unibo.monoopoly.model.api.player.Player;

public class GameBoardImpl implements GameBoard{

    private final List<Cell> cellsList;
    private final List<Player> playersList;
    private int currentPlayer;
    
    public GameBoardImpl(final List<Cell> cellsList, List<Player> playersList) {
        this.cellsList = cellsList;
        this.playersList = playersList;
        this.currentPlayer = 0;
    }

    @Override
    public Cell getCell(int index) {
        if(index < 0 || index > 39) {
            throw new IndexOutOfBoundsException("Index " + index + " not valid, it must be between 0 and 39 inclusive");
        }
        return cellsList.get(index);
    }

    @Override
    public void removePlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlayer'");
    }

    @Override
    public boolean isGameEnded() {
        return this.playersList.size() < 2;
    }

}
