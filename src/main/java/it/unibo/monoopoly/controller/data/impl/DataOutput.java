package it.unibo.monoopoly.controller.data.impl;

import java.util.Optional;

public record DataOutput(
    Optional<Boolean> buyProperty,
    Optional<Integer> cellChoose
) {
}
