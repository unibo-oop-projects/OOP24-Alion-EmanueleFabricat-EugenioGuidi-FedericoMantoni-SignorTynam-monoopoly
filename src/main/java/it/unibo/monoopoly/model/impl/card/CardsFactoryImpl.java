package it.unibo.monoopoly.model.impl.card;

import java.util.List;
import java.util.stream.Stream;

import it.unibo.monoopoly.model.api.card.Card;
import it.unibo.monoopoly.model.api.card.CardsFactory;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

/**
 * Implementation of {@link CardsFactory}.
 */
public class CardsFactoryImpl implements CardsFactory {
    private final JsonConverter<Card> deserializer;
    private static final String PATH_MOVEMENT = "cards_movement.json";
    private static final String PATH_PAY = "cards_pay.json";
    private static final String PATH_SPECIAL = "cards_special.json";

    /* */
    public CardsFactoryImpl() {
        this.deserializer = new JsonConverterImpl<>(Card.class);
    }

    @Override
    public List<Card> createDeck() {
        return mergeLists(
            listFromPath(PATH_MOVEMENT),
            listFromPath(PATH_PAY),
            listFromPath(PATH_SPECIAL)
        );
    } 

    private Stream<Card> listFromPath(String path) {
        return this.deserializer.jsonToList(ClassLoader.getSystemResourceAsStream(path)).stream();
    }

    private List<Card> mergeLists(Stream<Card> s1, Stream<Card> s2, Stream<Card> s3) {
        return Stream.of(s1, s2, s3).flatMap(s -> s).toList();
    }

}
