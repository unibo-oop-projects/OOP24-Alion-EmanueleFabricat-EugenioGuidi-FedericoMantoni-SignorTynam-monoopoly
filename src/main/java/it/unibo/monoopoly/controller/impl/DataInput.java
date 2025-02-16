package it.unibo.monoopoly.controller.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;

public record DataInput(
    Optional<Event> event,
    Optional<String> nameOfProperty,
    Optional<String> nameOfPlayer,
    Optional<Integer> valueToPay,
    Optional<Pair> dices,
    Optional<Boolean> setMode1,
    Optional<Boolean> setMode2,
    Optional<List<Integer>> cellList
) {
}
