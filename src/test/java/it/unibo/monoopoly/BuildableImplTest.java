package it.unibo.monoopoly;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;

public class BuildableImplTest {

    static final int COST = 100;

    private BuildableImpl property;

    @BeforeEach
    public void initialization() {
        this.property = new BuildableImpl(COST);
    }

    @Test
    public void testGetCost() {
        assertEquals(COST, property.getCost());
    }

}
