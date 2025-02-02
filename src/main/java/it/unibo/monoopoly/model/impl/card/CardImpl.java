package it.unibo.monoopoly.model.impl.card;

import it.unibo.monoopoly.model.api.card.Card;
import it.unibo.monoopoly.utils.Message;

public class CardImpl implements Card{
    private final String effect;
    private final Message action;

    public CardImpl(String effect, Message action) {
        this.effect = effect;
        this.action = action;
    }

    @Override
    public void doAction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doAction'");
    }

    @Override
    public String getText() {
        return this.effect;
    }

}
