package it.unibo.monoopoly.controller.data.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.gameboard.api.Dices.Pair;

/**
 * manca commento qui.
 */
public record DataInput(
                Optional<Event> event,
                Optional<String> nameOfProperty,
                Optional<String> nameOfPlayer,
                Optional<Integer> valueToPay,
                Optional<Pair> dices,
                Optional<Boolean> setMode1,
                Optional<Boolean> setMode2,
                Optional<List<Integer>> cellList,
                Optional<String> cardText) {
}
