package it.unibo.monoopoly.controller.data.impl;

import java.util.Optional;

/**
 * manca commenti qui.
 */
public record DataOutput(
                Optional<Boolean> buyProperty,
                Optional<Integer> cellChoose) {
}
