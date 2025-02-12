package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @BeforeEach
    void init() {
        this.deck =  new DeckImpl();
    }

    @Test
    void testCorrectCards() {
        assert(Stream
                .iterate(0, n -> deck.draw(null))
                .anyMatch(deck.getActualCard().equals(
                    new CardImpl(
                        "Andate sino a Largo Colombo, se passate dal via ritirate 200€", 
                        new Message(Actions.MOVE,  24))
                )));
    }
}
