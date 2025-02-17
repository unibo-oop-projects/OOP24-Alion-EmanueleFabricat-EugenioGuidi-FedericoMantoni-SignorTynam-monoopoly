package it.unibo.monoopoly;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.gameboard.Buyable;
import it.unibo.monoopoly.model.gameboard.Company;
import it.unibo.monoopoly.model.gameboard.Railroad;
import it.unibo.monoopoly.model.impl.NotaryImpl;
import it.unibo.monoopoly.model.impl.gameboard.CompanyImpl;
import it.unibo.monoopoly.model.impl.gameboard.RailroadImpl;
import it.unibo.monoopoly.model.impl.player.PlayerImpl;

public class TestBuyable {

    private static final Buyable RAILROAD_N = new RailroadImpl("Stazione Nord", 200);
    private static final Buyable RAILROAD_E = new RailroadImpl("Stazione Est", 200);
    private static final Buyable RAILROAD_S = new RailroadImpl("Stazione Sud", 200);
    private static final Buyable RAILROAD_O = new RailroadImpl("Stazione Ovest", 200);
    private static final int START_MONEY = 1500;
    private static final int TRIES = 10;

    private Set<Buyable> railroads;
    private Company company1;
    private Company company2;

    private Player owner;

    private Notary notary;

    @BeforeEach
    void init() {
        this.railroads = Set.of(RAILROAD_E, RAILROAD_N, RAILROAD_O, RAILROAD_S);
        this.company1 = new CompanyImpl("Società idrica", 150);
        this.company2 = new CompanyImpl("Società Elettrica", 150);
        this.owner = new PlayerImpl("Franco", START_MONEY, 0);
        this.notary = new NotaryImpl();
    }

    @Test
    void testSubinterface() {
        assertInstanceOf(Company.class, company1);
        assertInstanceOf(Company.class, company2);
        for (final Buyable buyable : railroads) {
            assertInstanceOf(Railroad.class, buyable);
        }
    }

    @Test
    void testRailroad() {
        assertThrows(IllegalStateException.class, () ->
            railroads.stream().findAny().get().getRentalValue());
        int expectedRent = 25;
        for (final Buyable buyable : railroads) {
            this.notary.buyProperty(owner, buyable);
            assertEquals(expectedRent, buyable.getRentalValue());
            expectedRent *= 2;
        }
    }

    @Test
    void testCompany() {
        final Company company1 = (Company) this.company1;
        final Company company2 = (Company) this.company2;
        final Exception exception1 = assertThrows(IllegalStateException.class, () ->
            company1.getRentalValue());
        final Exception exception2 = assertThrows(IllegalStateException.class, () ->
            company1.rollAndCalculate());
        assertEquals("The property must be owned by a player", exception1.getMessage());
        assertEquals("The property must be owned by a player", exception2.getMessage());
        notary.buyProperty(owner, company1);
        final Exception exception3 = assertThrows(IllegalStateException.class, () ->
            company1.getRentalValue());
        assertEquals("Rental value need to be first calculated for Companies",
            exception3.getMessage());
        this.checkRental(company1,8, 48);
        notary.buyProperty(owner, company2);
        this.checkRental(company1, 20, 120);
        this.checkRental(company2, 20, 120);
    }

    private void checkRental(final Company company, final int min, final int max) {
        for (int i = 0; i < TRIES; i++) {
            company.rollAndCalculate();
            final int rentalValue = company.getRentalValue();
            assertTrue(rentalValue >= min && rentalValue <= max);
        }
    }

}
