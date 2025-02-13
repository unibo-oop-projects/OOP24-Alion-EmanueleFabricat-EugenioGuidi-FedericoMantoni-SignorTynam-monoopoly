package it.unibo.monoopoly.model.api.card;

import java.util.List;

/**
 * The factory to create the cards.
 */
public interface CardsFactory {
    /**
     * @return the {@link List} of the cards in an {@link Deck}.
     */
    List<Card> createDeck();
}
