package it.unibo.monoopoly.common;

/**
 * Represents the various events triggered by a cell, needing an interaction with the player.
 */
public enum Event {

    /**
     * Event triggered by finishing in a {@link Buyable} cell owned by another {@link Player}.
     * Involves in the payment to the player owner
     */
    RENT_PAYMENT,
    /**
     * Event triggered by some {@link Functional} cell, involving the payment of a fixed tax.
     */
    TAX_PAYMENT,
    /**
     * Event triggered by finishing in a {@link Buyable} cell owned by bank,
     * involving the choice of the player to buy or not buy the property.
     */
    BUY_PROPERTY

}
