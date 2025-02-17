package it.unibo.monoopoly.model.card.api;

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
