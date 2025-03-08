package it.unibo.monoopoly.model.deck.impl;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
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
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Suppressing according to pattern Proxy")
    public DeckWrapper(final Deck deck) {
        this.deck = deck;
    }

    /**
     * Proxy version.
     * {@inheritedDoc}.
     */
    @Override
    public void draw() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    /**
     * Proxy version.
     * {@inheritedDoc}.
     */
    @Override
    public Card getActualCard() {
        return new CardImpl(this.deck.getActualCard().getEffectText(), this.deck.getActualCard().getMessage());
    }

    /**
     * Proxy version.
     * {@inheritedDoc}.
     */
    @Override
    public void addPrisonCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPrisonCard'");
    }

}
