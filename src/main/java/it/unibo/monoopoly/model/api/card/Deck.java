package it.unibo.monoopoly.model.api.card;

import it.unibo.monoopoly.model.api.player.Player;

/**
 * The interface that implemented the deck of cards,
 * and its management.
 */
public interface Deck {
    /**
     * @param player who drawn the card. 
     */
    void draw();
    /**
     * @return the drawn {@link Card}.
     */
    Card getActualCard();
    /**
     * To add a go to prison card in the discard pile.
     */
    void addPrisonCard();
}
