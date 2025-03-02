package it.unibo.monoopoly.view.panel.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import it.unibo.monoopoly.view.panel.impl.NumberAndCirclePosition;

public interface PositionAllocator {

    List<NumberAndCirclePosition> createListCircleNumberPosition(Map<String, Integer> newPlayersPositions, 
                                                                 Map<Integer, Optional<String>> cellsOwners, 
                                                                 List<String> prisonedPlayers,
                                                                 Map<Integer, Integer> nBuiltHouses);
}
