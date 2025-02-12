package it.unibo.monoopoly.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.impl.card.DeckImpl;
/**
 * Tester of {@link Deck} and {@link Card}
 */
class TestDeckAndCards {
    private Deck deck;

    @BeforeEach
    void init(){
        this.deck = new DeckImpl();
    }

    @Test
    void testNumberOfCards() {

    }
}
