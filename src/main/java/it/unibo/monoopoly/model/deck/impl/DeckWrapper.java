package it.unibo.monoopoly.model.deck.impl;

import it.unibo.monoopoly.model.deck.api.Card;
import it.unibo.monoopoly.model.deck.api.Deck;

/**
 * Proxy of {@link DeckImpl}.
 */
public class DeckWrapper implements Deck {
    private final Deck deck;

    /**
     * Constructor of the proxy.
     * 
     * @param deck the real Deck.
     */
    public DeckWrapper(Deck deck) {
        this.deck = deck;
    }

    /**
     * {@inheritedDoc}
     */
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    /**
     * {@inheritedDoc}
     */
    @Override
    public Card getActualCard() {
        return new CardImpl(this.deck.getActualCard().getEffectText(), this.deck.getActualCard().getMessage());
    }

    /**
     * {@inheritedDoc}
     */
    @Override
    public void addPrisonCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPrisonCard'");
    }

}
