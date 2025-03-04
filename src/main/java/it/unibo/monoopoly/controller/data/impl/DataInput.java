package it.unibo.monoopoly.controller.data.impl;

import java.util.Map;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.gameboard.api.Dices.Pair;

/**
 * comment.
 * 
 * @param cellList
 * @param dices
 * @param event
 * @param mode
 * @param text
 * @param valueToPay
 */
public record DataInput(
        Optional<Map<Integer, Integer>> cellMap,
        Optional<Pair> dices,
        Optional<Event> event,
        Optional<Boolean> mode,
        Optional<String> text,
        Optional<Integer> valueToPay) {
}
