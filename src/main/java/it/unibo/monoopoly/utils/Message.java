package it.unibo.monoopoly.utils;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record of utility, it represents the message directed to {@link Turn}.
 * @param typeOfAction that {@link Turn} have to do.
 * @param data that {@link Turn} have to use to do the operation.
 */
public record Message(
    @JsonProperty("action") Message.Actions typeOfAction,
    @JsonProperty("data") Optional<Integer> data
) {
    public enum Actions {
        DRAW,
        FREE_CARD,
        MOVE,
        PAY,
        PRISON,
        RECEIVE
    }

}

