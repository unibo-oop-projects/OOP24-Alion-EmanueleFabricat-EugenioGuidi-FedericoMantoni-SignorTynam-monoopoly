package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import it.unibo.monoopoly.utils.api.PositionsFactory;
import it.unibo.monoopoly.utils.impl.Position;
import it.unibo.monoopoly.utils.impl.PositionsFactoryImpl;
import it.unibo.monoopoly.view.panel.api.PositionAllocator;

public class PositionAllocatorImpl implements PositionAllocator {

    private final Map<Color, List<Position>> playersPositions;
    private final Map<Integer, Position> propertyPositions;
    private final Map<Integer, Position> housesPositions;
    private final Map<Color, Position> prisonPositions;
    private final Map<String, Color> playersColors;

    public PositionAllocatorImpl(final int mainFrameHeight, final Map<Color, String> playersColors,
            final List<Color> colors) {
        this.playersColors = reverseColor(playersColors);
        final PositionsFactory positionsFactory = new PositionsFactoryImpl(mainFrameHeight, colors);
        this.playersPositions = positionsFactory.createPlayersPositions();
        this.propertyPositions = positionsFactory.createPropertyPositions();
        this.housesPositions = positionsFactory.createHousesPositions();
        this.prisonPositions = positionsFactory.createPrisonPositions();
    }

    /**
     * {@inheritDoc}
     */
    public List<NumberAndCirclePosition> createListCircleNumberPosition(final Map<String, Integer> newPlayersPositions,
            final Map<Integer, Optional<String>> cellsOwners,
            final List<String> prisonedPlayers,
            final Map<Integer, Integer> nBuiltHouses,
            final List<Integer> mortgagedProperties) {
        final List<NumberAndCirclePosition> newList = new ArrayList<>();
        NumberAndCirclePosition numberAndCirclePosition;
        for (final var entry : this.playersColors.entrySet()) {
            if (newPlayersPositions.containsKey(entry.getKey())) {
                numberAndCirclePosition = new NumberAndCirclePosition.Builder()
                        .setX((int) getX(entry, newPlayersPositions))
                        .setY((int) getY(entry, newPlayersPositions))
                        .setIsCircle(true)
                        .setColor(this.playersColors.get(entry.getKey()))
                        .build();
                newList.add(numberAndCirclePosition);
            }
        }

        for (final var entry : cellsOwners.entrySet()) {
            if (entry.getValue().isPresent()) {
                numberAndCirclePosition = new NumberAndCirclePosition.Builder()
                        .setX((int) this.propertyPositions.get(entry.getKey()).x())
                        .setY((int) this.propertyPositions.get(entry.getKey()).y())
                        .setIsCircle(true)
                        .setColor(this.playersColors.get(entry.getValue().get()))
                        .build();
                newList.add(numberAndCirclePosition);
            }
        }

        for (final var prisonedPlayer : prisonedPlayers) {
            final Color color = this.playersColors.get(prisonedPlayer);
            numberAndCirclePosition = new NumberAndCirclePosition.Builder()
                    .setX((int) this.prisonPositions.get(color).x())
                    .setY((int) this.prisonPositions.get(color).y())
                    .setIsCircle(true)
                    .setColor(color)
                    .build();
            newList.add(numberAndCirclePosition);
        }
        for (final var entry : nBuiltHouses.entrySet()) {
            numberAndCirclePosition = new NumberAndCirclePosition.Builder()
                    .setX((int) this.housesPositions.get(entry.getKey()).x())
                    .setY((int) this.housesPositions.get(entry.getKey()).y())
                    .setIsCircle(false)
                    .setColor(Color.BLACK)
                    .setNumber(entry.getValue().toString())
                    .build();
            newList.add(numberAndCirclePosition);
        }
        for (final var cellIndex : mortgagedProperties) {
            numberAndCirclePosition = new NumberAndCirclePosition.Builder()
                    .setX((int) this.propertyPositions.get(cellIndex).x())
                    .setY((int) this.propertyPositions.get(cellIndex).y())
                    .setIsCircle(true)
                    .setColor(Color.BLACK)
                    .build();
        }

        return newList;
    }

    private double getX(final Map.Entry<String, Color> entry, final Map<String, Integer> newPlayersPositions) {
        return this.playersPositions.get(entry.getValue()).get(newPlayersPositions.get(entry.getKey())).x();
    }

    private double getY(final Map.Entry<String, Color> entry, final Map<String, Integer> newPlayersPositions) {
        return this.playersPositions.get(entry.getValue()).get(newPlayersPositions.get(entry.getKey())).y();
    }

    private Map<String, Color> reverseColor(final Map<Color, String> list) {
        return list.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }
}
