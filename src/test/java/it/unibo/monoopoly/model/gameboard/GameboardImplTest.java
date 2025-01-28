package it.unibo.monoopoly.model.gameboard;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.monoopoly.model.api.gameboard.GameBoard;
import it.unibo.monoopoly.model.impl.gameboard.GameBoardImpl;


public class GameBoardImplTest {

    private GameBoard gameBoardImpl;

    @BeforeEach
    public void initialization() {
        this.gameBoardImpl = new GameBoardImpl();
    }

}
