package it.unibo.monoopoly.view.panel.impl;

import java.util.List;

import it.unibo.monoopoly.view.panel.api.PositionsFactory;
import it.unibo.monoopoly.view.panel.impl.GameBoardPanel.Position;
import it.unibo.monoopoly.model.deck.api.Card;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

public class PositionsFactoryImpl implements PositionsFactory{

    private final JsonConverter<Position> converter;
    private final String fileName;


    public PositionsFactoryImpl(final String fileName) {
        this.fileName = fileName;
        this.converter = new JsonConverterImpl<>(Position.class);
    }

    @Override
    public List<Position> createPositions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPositions'");
    }

}
