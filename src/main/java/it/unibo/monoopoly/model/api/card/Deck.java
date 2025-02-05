package it.unibo.monoopoly.model.api.card;

import it.unibo.monoopoly.model.api.player.Player;

/**
 * The interface that implemented the deck of cards,
 * and its management.
 */
public interface Deck {
    /**
     * 
     * @param player who drawn the card. 
     */
    void draw(Player player);
    /**
     * 
     * @return the drawn {@link Card}.
     */
    Card getActualCard();
}
