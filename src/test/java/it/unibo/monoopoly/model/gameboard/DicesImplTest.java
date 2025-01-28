package it.unibo.monoopoly.model.gameboard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.impl.gameboard.DiceImpl;

public class DicesImplTest {

    private DiceImpl diceImpl;

    @BeforeEach
    void initialization() {
        this.diceImpl = new DiceImpl();
    }

    @Test
    public void testGetDices() {
        assertEquals(Optional.empty(), this.diceImpl.getDices());
        this.diceImpl.rollDices();
        assertNotEquals(Optional.empty(), this.diceImpl.getDices());
    }

}
