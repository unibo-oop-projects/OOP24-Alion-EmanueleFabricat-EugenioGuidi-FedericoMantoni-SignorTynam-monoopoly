package it.unibo.monoopoly.utils;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibo.monoopoly.model.api.player.Turn;

/**
 * Record of utility, it represents the message directed to {@link Turn}.
 * @param typeOfAction that {@link Turn} have to do.
 * @param data that {@link Turn} have to use to do the operation.
 */
public record Message(
    @JsonProperty("action") Message.Actions typeOfAction,
    @JsonProperty("data") Optional<Integer> data
) {
    /**
     * Enum for selecting the type of action,
     * that the messenger have to send.
     */
    public enum Actions {
        /**
         * Actions represents having to draw a {@link Card}.
         */
        DRAW,
        /**
         * Actions represents that a: get out of jail {@link Card} it has been drawn.
         */
        FREE_CARD,
        /**
         * Actions represents having to move a the actual {@link Player}.
         */
        MOVE,
        /**
         * Actions represents having to pay an amount.
         */
        PAY,
        /**
         * Actions represents having to go to prison the actual {@link Player}. 
         */
        PRISON,
        /**
         * Actions represents having to receive an amount.
         */
        RECEIVE
    }

}

