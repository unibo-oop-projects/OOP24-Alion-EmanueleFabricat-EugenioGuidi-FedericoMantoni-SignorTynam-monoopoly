package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import it.unibo.monoopoly.utils.api.PositionsFactory;
import it.unibo.monoopoly.utils.impl.Position;
import it.unibo.monoopoly.utils.impl.PositionsFactoryImpl;
import it.unibo.monoopoly.view.panel.api.PositionAllocator;

public class PositionAllocatorImpl implements PositionAllocator{

    private final Map<Color, List<Position>> playersPositions;
    private final Map<Integer, Position> propertyPositions;
    private final Map<Integer, Position> housesPositions;
    private final Map<Color, Position> prisonPositions;
    private final Map<Color, String> playersColors;
    private final int mainFrameHeight;

    public PositionAllocatorImpl(final int mainFrameHeight, final Map<Color, String> playersColors, final List<Color> colors) {
        this.playersColors = playersColors;
        this.mainFrameHeight = mainFrameHeight;
        final PositionsFactory positionsFactory = new PositionsFactoryImpl(mainFrameHeight, colors);
        this.playersPositions = positionsFactory.createPlayersPositions();
        this.propertyPositions = positionsFactory.createPropertyPositions();
        this.housesPositions = positionsFactory.createHousesPositions();
        this.prisonPositions = positionsFactory.createPrisonPositions();
    }
}
