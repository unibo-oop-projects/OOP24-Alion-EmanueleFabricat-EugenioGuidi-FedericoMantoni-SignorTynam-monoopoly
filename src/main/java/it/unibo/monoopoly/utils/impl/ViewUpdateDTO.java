package it.unibo.monoopoly.utils.impl;

import java.util.List;

import java.util.Map;
import java.util.Optional;

public record ViewUpdateDTO(
    Map<String,Integer> playerPositions,
    Map<Integer,Optional<String>> cellsOwners, 
    Map<Integer,Integer> nBuiltHouses,
    List<String> prisonedPlayers,
    Map<String, Integer> playersMoney,
    String actualPlayer) {
}
