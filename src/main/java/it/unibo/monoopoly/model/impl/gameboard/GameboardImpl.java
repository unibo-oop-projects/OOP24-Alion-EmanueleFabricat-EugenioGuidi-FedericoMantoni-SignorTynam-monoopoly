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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCell'");
    }

    @Override
    public void removePlayer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePlayer'");
    }

    @Override
    public boolean isGameEnded() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGameEnded'");
    }

}
