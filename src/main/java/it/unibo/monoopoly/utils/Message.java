package it.unibo.monoopoly.utils;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Record of utility, it rappresents the message dirrected to {@link Turn}.
 * @param typeOfAction that {@link Turn} have to do.
 * @param data that {@link Turn} have to use to do the opration.
 */
public record Message(
    @JsonProperty("action") Actions typeOfAction,
    @JsonProperty("data") Object data) {
    public enum Actions {
        CHOOSE,
        BANKRUPTCY,
        MOVE,
        PAY,
        WRITE,
        DRAW,
        PRISON
    }

}

