package it.unibo.monoopoly.controller.data.impl;

import java.util.Optional;

/**
 * comment.
 * @param buyProperty
 * @param cellChoose
 */
public record DataOutput(
                Optional<Boolean> buyProperty,
                Optional<Integer> cellChoose) {
}
