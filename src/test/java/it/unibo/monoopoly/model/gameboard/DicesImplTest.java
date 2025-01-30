package it.unibo.monoopoly.model.gameboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.impl.gameboard.DicesImpl;
import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;

/**
 * This class test the correct functioning of class DicesImpl.
 */
class DicesImplTest {

    private DicesImpl diceImpl;

    /**
     * Initialize the field diceImpl every time before each test.
     */
    @BeforeEach
    void initialization() {
        this.diceImpl = new DicesImpl();
    }

    /**
     * Test the methods getDices and rollDices.
     */
    @Test
    void testGetDices() {
        assertEquals(null, this.diceImpl.getDices());
        this.diceImpl.rollDices();
        assertNotEquals(null, this.diceImpl.getDices());
    }

    /**
     * Test method getResult.
     */
    @Test
    void testGetResult() {
        final int sumOfDices;
        final Pair pair;
        assertEquals(0, this.diceImpl.getResult());
        this.diceImpl.rollDices();
        pair = this.diceImpl.getDices();
        sumOfDices = pair.getFirstRoll() + pair.getSecondRoll();
        assertEquals(sumOfDices, this.diceImpl.getResult());
    }

}
