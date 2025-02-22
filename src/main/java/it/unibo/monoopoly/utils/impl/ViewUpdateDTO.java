package it.unibo.monoopoly.utils.impl;

import java.util.List;

import java.util.Map;
import java.util.Optional;

/**
 * DTO for view update.
 * 
 * @param playerPositions map of name of {@link player} in game and its position
 *                        as a number
 * @param cellsOwners     map of {@link Buyable} cells expressed as a number and
 *                        the name of its owner
 * @param nBuiltHouses    map of {@link Buildable} cell expressed as a number
 *                        and the number of houses built in it
 * @param prisonedPlayers list of the name of the {@link Player}s in prison
 * @param playersMoney
 * @param actualPlayer    the name of the actual {@link Player}
 */
public record ViewUpdateDTO(
        Map<String, Integer> playerPositions,
        Map<Integer, Optional<String>> cellsOwners,
        Map<Integer, Integer> nBuiltHouses,
        List<String> prisonedPlayers,
        Map<String, Integer> playersMoney,
        String actualPlayer) {
}
