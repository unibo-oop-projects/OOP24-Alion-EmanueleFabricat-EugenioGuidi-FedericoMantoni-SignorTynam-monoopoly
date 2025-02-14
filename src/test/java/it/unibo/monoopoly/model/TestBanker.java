package it.unibo.monoopoly.model;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.CellFactory;
import it.unibo.monoopoly.model.api.gameboard.GameBoard;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.impl.gameboard.CellFactoryImpl;
import it.unibo.monoopoly.model.impl.gameboard.GameBoardImpl;
import it.unibo.monoopoly.model.impl.player.PlayerImpl;

/**
 * Tester of {@link Banker}
 */
public class TestBanker {
    private Player player;
    private GameBoard gameBoard;
    private CellFactory cellFactory;
    private Cell vC;
    private Cell pDV;
    /**
     * Initialization for the test.
     */
    @BeforeEach
    void init() {
        this.player = new PlayerImpl("Genoveffo", 1500, 0);
        this.cellFactory = new CellFactoryImpl();
        this.gameBoard = new GameBoardImpl(this.cellFactory.createCells(), List.of(this.player));
        this.vC = this.gameBoard.getCell(1);
        this.pDV = this.gameBoard.getCell(39);
        player.addProperty((Buyable)this.vC);
        player.addProperty((Buyable)this.pDV);
    }
    /**
     * 
     */
    @Test
    void testOperations() {
        
    }
    
}
