package it.unibo.monoopoly.model.card.impl;

import java.util.List;

import it.unibo.monoopoly.model.card.api.Card;
import it.unibo.monoopoly.model.card.api.CardsFactory;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

/**
 * Implementation of {@link CardsFactory}.
 */
public class CardsFactoryImpl implements CardsFactory {
    private final JsonConverter<Card> deserializer;
    private static final String PATH = "cards.json";
    /**
     * constructor of the factory that sets the class.
     */
    public CardsFactoryImpl() {
        this.deserializer = new JsonConverterImpl<>(Card.class);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Card> createDeck() {
        return this.deserializer.jsonToList(ClassLoader.getSystemResourceAsStream(PATH));
    } 
}
