package it.unibo.monoopoly.model.api.card;

import it.unibo.monoopoly.model.api.player.Player;

/**
 * The interface that implemented the deck of cards,
 * and its management
 */
public interface Deck {
    /**
     * method that shuffle the card deck
     * 
     */
    public void shuffleDeck();
    /**
     * @param player, who drawn the card.
     * 
     */
    public void draw(Player player); 
}
