package it.unibo.monoopoly.controller.data.impl;

import java.util.List;
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
        Optional<List<Integer>> cellList,
        Optional<Pair> dices,
        Optional<Event> event,
        Optional<Boolean> mode,
        Optional<String> text,
        Optional<Integer> valueToPay) {
}
