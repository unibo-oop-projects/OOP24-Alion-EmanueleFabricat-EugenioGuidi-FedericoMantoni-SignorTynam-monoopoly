package it.unibo.monoopoly.model.impl.card;

import it.unibo.monoopoly.model.api.card.Card;
import it.unibo.monoopoly.utils.Message;

public class CardImpl implements Card{
    private final String effect;
    private final Message message;

    public CardImpl(String effect, Message message) {
        this.effect = effect;
        this.message = message;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Message getMessage() {
        return this.message;
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public String getEffectText() {
        return this.effect;
    }
}
