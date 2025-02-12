package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.impl.NotaryImpl;
import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;
import it.unibo.monoopoly.model.impl.player.PlayerImpl;


public class TestNotary {

    private static final int START_MONEY = 1500;
    private final Notary notary = new NotaryImpl();

    private Player player1;
    private Player player2;
    
    private Buyable buildableProperty;

    @BeforeEach
    void init() {
        this.player1 = new PlayerImpl("Marco", START_MONEY, 0);
        this.player2 = new PlayerImpl("Franco", START_MONEY, 0);
        this.buildableProperty = new BuildableImpl(Map.of(), "Prova", 150, 50);
    }

    @Test
    void testCheckProperty() {
        assertEquals(Event.BUY_PROPERTY,notary.checkProperty(player1, buildableProperty).get());
        notary.buyProperty(player1, buildableProperty);
        assertEquals(Optional.empty(), notary.checkProperty(player1, buildableProperty));
        assertEquals(Event.RENT_PAYMENT, notary.checkProperty(player2, buildableProperty).get());
    }

    @Test
    void testBuyProperty() {
        notary.buyProperty(player1, buildableProperty);
        assertEquals(player1, buildableProperty.getOwner().get());
        assertFalse(buildableProperty.isAvailable());
        assertTrue(player1.getProperties().contains(buildableProperty));
    }

    @Test
    void testBuyOwnedProperty() {
        notary.buyProperty(player1, buildableProperty);
        final Exception exception = assertThrows(IllegalStateException.class,() -> 
            notary.buyProperty(player2, buildableProperty));
        assertEquals("Property must be owned by the bank to be buyable", exception.getMessage());
    }



}
