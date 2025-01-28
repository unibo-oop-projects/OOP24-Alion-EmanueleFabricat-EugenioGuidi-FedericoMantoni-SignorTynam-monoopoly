package it.unibo.monoopoly;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.impl.player.PlayerImpl;
import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;

public class BuildableImplTest {

    static final int COST = 550;
    static final int HOUSE_COST = 100;
    static final String PROPERTY_NAME = "Corso Magellano";
    static final Optional<Player> FIRSTOWNER = Optional.of(new PlayerImpl("Mario", 1500, 0, false));
    static final Optional<Player> SECONDOWNER = Optional.of(new PlayerImpl("Franco", 1500, 0, false));
    static final Map<Integer, Integer> RENTAL_MAP = BuildableImplTest.initializeRentalMap();
    
        private BuildableImpl property;

        private static Map<Integer, Integer> initializeRentalMap() {
            final Map<Integer, Integer> rentalMap = new HashMap<>();
            rentalMap.put(0, 45);
            rentalMap.put(1, 225);
            rentalMap.put(2, 625);
            rentalMap.put(3, 1750);
            rentalMap.put(4, 2200);
            rentalMap.put(5, 2625);
            return rentalMap;
        }
    
        @BeforeEach
        public void initialization() {
            this.property = new BuildableImpl(RENTAL_MAP, PROPERTY_NAME, COST, HOUSE_COST);
        }

    @Test
    public void testCell() {
        assertEquals(PROPERTY_NAME, this.property.getName());
        assertTrue(this.property.isBuildable());
        assertTrue(this.property.isBuyable());
    }

    @Test
    public void testGetRentalValue() {
        assertEquals(BuildableImplTest.RENTAL_MAP.get(0), this.property.getRentalValue());
        this.property.buildHouse();
        assertEquals(BuildableImplTest.RENTAL_MAP.get(1), this.property.getRentalValue());
        this.property.sellHouse();
        assertEquals(BuildableImplTest.RENTAL_MAP.get(0), this.property.getRentalValue());
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

    @Test
    public void testBuildHouse() {
        this.property.buildHouse();
        assertEquals(1, this.property.getHousesNumber());
        assertEquals(RENTAL_MAP.get(1), this.property.getRentalValue());

        for (int i = 0; i < 4; i++) {
            this.property.buildHouse();
        }

        assertEquals(5, this.property.getHousesNumber());
        assertThrows(IllegalStateException.class, () -> this.property.buildHouse());
    }

    @Test
    public void testSellHouse() {
        this.property.buildHouse();
        this.property.buildHouse();
        assertEquals(2, this.property.getHousesNumber());
        
        int sellValue = this.property.sellHouse();
        assertEquals(HOUSE_COST / 2, sellValue);
        assertEquals(1, this.property.getHousesNumber());
        assertEquals(RENTAL_MAP.get(1), this.property.getRentalValue());

        this.property.sellHouse();
        assertEquals(0, this.property.getHousesNumber());
        assertEquals(RENTAL_MAP.get(0), this.property.getRentalValue());
        assertThrows(IllegalStateException.class, () -> this.property.sellHouse());
    }

    @Test
    public void testBuildAndSellHouseOnMortgagedProperty() {
        this.property.setMortgage();
        assertTrue(this.property.isMortgaged());
        
        assertThrows(IllegalStateException.class, () -> this.property.buildHouse());
        assertThrows(IllegalStateException.class, () -> this.property.sellHouse());
    }
}
