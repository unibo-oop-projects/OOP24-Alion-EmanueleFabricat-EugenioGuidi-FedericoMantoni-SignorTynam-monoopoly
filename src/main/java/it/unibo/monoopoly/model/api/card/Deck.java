package it.unibo.monoopoly.model.api.card;

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
