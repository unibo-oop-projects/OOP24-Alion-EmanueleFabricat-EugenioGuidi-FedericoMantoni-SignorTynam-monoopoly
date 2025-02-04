package it.unibo.monoopoly.model.gameboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.GameBoard;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;
import it.unibo.monoopoly.model.impl.gameboard.GameBoardImpl;
import it.unibo.monoopoly.model.impl.player.PlayerImpl;

/**
 * This class test the GameBoardImpl class.
 */
class GameBoardImplTest {

    private static final List<Cell> CELLS_LIST = initializeCellsList();
    private static final List<Player> PLAYERS_LIST = initializePlayersList();

    private static final int INITIAL_AMOUNT = 1500;
    private static final int ONE_HUNDRED = 100;
    private static final int TWO_HUNDRED = 200;
    private static final int THREE_HUNDRED = 300;

    private GameBoard gameBoardImpl;

    private static List<Cell> initializeCellsList() {
        final List<Cell> cellsList = new LinkedList<>();
        cellsList.add(new BuildableImpl(new HashMap<>(), "first", ONE_HUNDRED, ONE_HUNDRED));
        cellsList.add(new BuildableImpl(new HashMap<>(), "second", TWO_HUNDRED, TWO_HUNDRED));
        cellsList.add(new BuildableImpl(new HashMap<>(), "third", THREE_HUNDRED, THREE_HUNDRED));
        return cellsList;
    }

    private static List<Player> initializePlayersList() {
        final List<Player> playersList = new LinkedList<>();
        playersList.add(new PlayerImpl("Mario", INITIAL_AMOUNT, 0, false));
        playersList.add(new PlayerImpl("Franco", INITIAL_AMOUNT, 0, false));
        playersList.add(new PlayerImpl("Luigi", INITIAL_AMOUNT, 0, false));
        return playersList;
    }

    /**
     * initialize the field before every test.
     */
    @BeforeEach
    void initialization() {
        this.gameBoardImpl = new GameBoardImpl(CELLS_LIST, PLAYERS_LIST);
    }

    /**
     * Test the method getCell.
     */
    @Test
    void testGetCell() {
        assertEquals(CELLS_LIST.get(0), this.gameBoardImpl.getCell(0));
        assertNotEquals(CELLS_LIST.get(0), this.gameBoardImpl.getCell(1));
    }

    /**
     * Test the methods isGameEnded and removePlayer.
     */
    @Test
    void testRemovePlayerAndGameEnded() {
        assertFalse(this.gameBoardImpl.isGameEnded());
        this.gameBoardImpl.removePlayer();
        assertFalse(this.gameBoardImpl.isGameEnded());
        this.gameBoardImpl.removePlayer();
        assertTrue(this.gameBoardImpl.isGameEnded());
    }

    /**
     * Test the methods getCurrrentPlayer and getNextPlayer.
     */
    @Test
    void testGetNextAndCurrentPlayer() {
        assertEquals(this.gameBoardImpl.getCurrentPlayer(), PLAYERS_LIST.get(0));
        this.gameBoardImpl.getNextPlayer();
        assertEquals(this.gameBoardImpl.getCurrentPlayer(), PLAYERS_LIST.get(1));
        this.gameBoardImpl.getNextPlayer();
        assertEquals(this.gameBoardImpl.getCurrentPlayer(), PLAYERS_LIST.get(2));
        this.gameBoardImpl.getNextPlayer();
        assertEquals(this.gameBoardImpl.getCurrentPlayer(), PLAYERS_LIST.get(0));
    }

    /**
     * Test the method getPlayersList.
     */
    @Test
    void testGetPlayersList() {
        assertEquals(PLAYERS_LIST, this.gameBoardImpl.getPlayersList());
    }

}
