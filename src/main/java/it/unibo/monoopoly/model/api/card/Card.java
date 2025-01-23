package it.unibo.monoopoly.model.api.card;

/**
 * The interface that implement the resolution of draw a card.
 * The card must apply the effects itself to the player who drew the card.
 */
public interface Card {
    /**
     * This method deals with applying effects,
     * if they don't are about cash.
     */
    void doAction();
    /**
     * @return the text of the card.
     */
    String getText();
}
