package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.impl.BuildableImpl;
import it.unibo.monoopoly.model.gameboard.impl.CellFactoryImpl;
import it.unibo.monoopoly.model.notary.api.Notary;
import it.unibo.monoopoly.model.notary.impl.NotaryImpl;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.player.impl.PlayerImpl;

public class TestNotary {

    private static final int START_MONEY = 1500;
    private final Notary notary = new NotaryImpl();

    private Player player1;
    private Player player2;

    private Buyable buildableProperty;
    private Cell notBuyableProperty;
    private List<Cell> cells = new CellFactoryImpl().createCells();

    @BeforeEach
    void init() {
        this.player1 = new PlayerImpl("Marco", 100, 0, false);
        this.player2 = new PlayerImpl("Franco", START_MONEY, 0, false);
        this.buildableProperty = (Buyable) cells.stream().filter(Cell::isBuyable).findFirst().get();
        this.notBuyableProperty = cells.stream().filter(Predicate.not(Cell::isBuyable)).findFirst().get();
    }

    @Test
    void testCheckBuyedProperty() {
        final Exception exception = assertThrows(IllegalArgumentException.class,
                () -> notary.checkBuyedProperty(player1, notBuyableProperty));
        assertEquals("Expected a buyable cell in input", exception.getMessage());
        notary.buyProperty(player2, buildableProperty);
        assertEquals(Optional.of(Event.RENT_PAYMENT), notary.checkBuyedProperty(player1, this.buildableProperty));
        this.buildableProperty.setMortgage();
        assertEquals(Optional.empty(), notary.checkBuyedProperty(player1, this.buildableProperty));
        assertEquals(Optional.empty(), notary.checkBuyedProperty(player2, this.buildableProperty));
    }

    @Test
    void testIsActionBuy() {
        assertFalse(notary.isActionBuy(buildableProperty, player1));
        player1.receive(START_MONEY);
        assertFalse(notary.isActionBuy(notBuyableProperty, player1));
        assertTrue(notary.isActionBuy(buildableProperty, player1));
        notary.buyProperty(player1, buildableProperty);
        assertFalse(notary.isActionBuy(buildableProperty, player2));

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
        final Exception exception = assertThrows(IllegalStateException.class,
                () -> notary.buyProperty(player2, buildableProperty));
        assertEquals("Property must be owned by the bank to be buyable", exception.getMessage());
    }

}
