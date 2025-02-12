package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.impl.card.CardImpl;
import it.unibo.monoopoly.model.impl.card.DeckImpl;
import it.unibo.monoopoly.utils.Message;
import it.unibo.monoopoly.utils.Message.Actions;

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
            this.deck.draw(null);
            switch (this.deck.getActualCard().getMessage().typeOfAction()) {
                case Message.Actions.MOVE:
                    countMove++;
                    break;
                case Message.Actions.PAY:
                    countMove++;
                    break;
                case Message.Actions.SPECIAL:
                    countMove++;
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
            this.deck.draw(null);
        }
        
    }
}
