package it.unibo.monoopoly.model.gameboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.impl.gameboard.DicesImpl;
import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;

public class DicesImplTest {

    private DicesImpl diceImpl;

    @BeforeEach
    void initialization() {
        this.diceImpl = new DicesImpl();
    }

    @Test
    public void testGetDices() {
        assertEquals(null, this.diceImpl.getDices());
        this.diceImpl.rollDices();
        assertNotEquals(null, this.diceImpl.getDices());
    }

    @Test
    public void testGetResult() {
        int sumOfDices;
        Pair pair;
        assertEquals(0, this.diceImpl.getResult());
        this.diceImpl.rollDices();
        pair = this.diceImpl.getDices();
        sumOfDices = pair.getFirstRoll() + pair.getSecondRoll();
        assertEquals(sumOfDices, this.diceImpl.getResult());
    }

}
