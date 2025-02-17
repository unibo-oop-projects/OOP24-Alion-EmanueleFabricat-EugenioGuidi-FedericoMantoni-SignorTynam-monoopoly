package it.unibo.monoopoly.common;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.unibo.monoopoly.model.api.player.Turn;

/**
 * Record of utility, it represents the message directed to {@link Turn}.
 * @param typeOfAction that {@link Turn} have to do.
 * @param data that {@link Turn} have to use to do the operation.
 */
public record Message(
    @JsonProperty("action") Event typeOfAction,
    @JsonProperty("data") Optional<Integer> data
) {
    
}

