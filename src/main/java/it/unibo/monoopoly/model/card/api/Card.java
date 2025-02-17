package it.unibo.monoopoly.model.card.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import it.unibo.monoopoly.common.Message;
import it.unibo.monoopoly.model.card.impl.CardImpl;

/**
 * The interface that implement the resolution of draw a card.
 * The card must apply the effects itself to the player who drew the card.
 */
@JsonDeserialize(as = CardImpl.class)
public interface Card {
    /**
     * 
     * @return the {@link Message} to interpret represents the action of the {@link Card}.
     */
    Message getMessage();
    /**
     * @return the text of the card.
     */
    String getEffectText();
}
