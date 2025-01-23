package it.unibo.monoopoly.model.api.card;

import it.unibo.monoopoly.model.api.player.Player;

/**
 * The interface that implemented the deck of cards,
 * and its management.
 */
public interface Deck {
    /**
     * method that shuffle the card deck.
     * 
     */
    void shuffleDeck();
    /**
     * @param player who drawn the card.
     * 
     */
    void draw(Player player); 
}
