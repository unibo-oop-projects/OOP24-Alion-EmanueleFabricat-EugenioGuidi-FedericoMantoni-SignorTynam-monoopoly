package it.unibo.monoopoly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.impl.player.PlayerImpl;
import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;

public class BuildableImplTest {

    static final int COST = 100;
    static final String PROPERTY_NAME = "Corso Magellano";
    static final Optional<Player> FIRSTOWNER = Optional.of(new PlayerImpl("Mario", 1500, 0, false));
    static final Optional<Player> SECONDOWNER = Optional.of(new PlayerImpl("Franco", 1500, 0, false));

    private BuildableImpl property;

    @BeforeEach
    public void initialization() {
        this.property = new BuildableImpl(PROPERTY_NAME, COST);
    }

    @Test
    public void testCell() {
        assertEquals(PROPERTY_NAME, this.property.getName());
        assertTrue(this.property.isBuildable());
        assertTrue(this.property.isBuyable());
    }

    @Test
    public void testGetCost() {
        assertEquals(COST, property.getCost());
    }

    @Test
    public void testOwner() {
        assertEquals(Optional.empty(), this.property.getOwner());
        this.property.setOwner(FIRSTOWNER);
        assertNotEquals(Optional.empty(), this.property.getOwner());
        assertNotEquals(SECONDOWNER, this.property.getOwner());
        assertEquals(FIRSTOWNER, this.property.getOwner());
        this.property.setOwner(Optional.empty());
        assertNotEquals(FIRSTOWNER, this.property.getOwner());
        assertNotEquals(SECONDOWNER, this.property.getOwner());
        assertEquals(Optional.empty(), this.property.getOwner());
    }

    @Test
    public void testIsBuyable() {
        assertTrue(this.property.isBuyable());
        this.property.setOwner(FIRSTOWNER);
        assertFalse(this.property.isBuyable());
    }

    @Test
    public void testIsMortgaged() {
        assertEquals(COST / 2, this.property.getMortgageValue());
        assertFalse(this.property.isMortgaged());
        this.property.setMortgage();
        assertTrue(this.property.isMortgaged());
        this.property.removeMortgage();
        assertFalse(this.property.isMortgaged());
    }
}
