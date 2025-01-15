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
    public void doAction();
    /**
     * This method deals with applying effects,
     * if they are about cash.
     * @return the amount to be pay or collected
     */
    public int getValue();
    /**
     * @return the text of the card.
     */
    public String getText();
}
