package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import it.unibo.monoopoly.view.panel.api.PositionsFactory;
import it.unibo.monoopoly.view.panel.impl.GameBoardPanel.Position;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

public class PositionsFactoryImpl implements PositionsFactory{

    private final JsonConverter<Position> converter;
    private final int mainFrameHeight;


    public PositionsFactoryImpl(final int mainFrameHeight) {
        this.mainFrameHeight = mainFrameHeight;
        this.converter = new JsonConverterImpl<>(Position.class);
    }

    @Override
    public Map<Color, Map<Integer, Position>> createPlayersPositions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPlayersPositions'");
    }

    @Override
    public Map<Integer, Position> createPropertyPositions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPropertyPositions'");
    }

    @Override
    public Map<Integer, Position> createHousesPositions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createHousesPositions'");
    }

    @Override
    public Map<Color, Position> createPrisonPositions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPrisonPositions'");
    }

}
