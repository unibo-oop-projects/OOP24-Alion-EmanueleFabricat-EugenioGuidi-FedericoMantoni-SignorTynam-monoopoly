package it.unibo.monoopoly.model.api.card;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import it.unibo.monoopoly.utils.Message;

/**
 * The interface that implement the resolution of draw a card.
 * The card must apply the effects itself to the player who drew the card.
 */
@JsonTypeInfo(
use = JsonTypeInfo.Id.CLASS,
include = JsonTypeInfo.As.PROPERTY,
property = "@class")
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
