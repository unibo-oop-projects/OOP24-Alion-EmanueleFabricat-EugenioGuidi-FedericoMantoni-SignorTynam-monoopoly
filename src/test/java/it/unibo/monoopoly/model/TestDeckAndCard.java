package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.impl.card.DeckImpl;

public class TestDeckAndCard {
    
    private Deck deck;
    private static int MAX_DRAW = 29;
    private static int NUM_MOVE_CARDS = 8;
    private static int NUM_PAY_CARDS = 17;
    private static int NUM_SPECIAL_CARDS = 4;

    @BeforeEach
    void init() {
        this.deck =  new DeckImpl();
    }

    @Test
    void testCorrectCards() {
        int countMove = 0;
        int countPay = 0;
        int countSpecial = 0;
        for (int i = 0; i < MAX_DRAW; i++) {
            this.deck.draw();
            switch (this.deck.getActualCard().getMessage().typeOfAction()) {
                case DRAW:
                    break;
                case FREE_CARD:
                    break;
                case MOVE:
                    break;
                case PAY:
                    break;
                case PRISON:
                    break;
                case RECEIVE:
                    break;
                default:
                    break;
            }
        }
        assertEquals(NUM_MOVE_CARDS, countMove);
        assertEquals(NUM_PAY_CARDS, countPay);
        assertEquals(NUM_SPECIAL_CARDS, countSpecial);
    }

    @Test
    void testRefill() {
        for (int i = 0; i < MAX_DRAW + 1; i++) {
            this.deck.draw();
        }
        
    }
}
