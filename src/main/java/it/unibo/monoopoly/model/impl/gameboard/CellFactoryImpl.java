package it.unibo.monoopoly.model.impl.gameboard;

import java.util.List;

import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.CellFactory;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

public class CellFactoryImpl implements CellFactory {

    private final static String PATH = "cells.json";
    private final static Class<Cell> TYPE = Cell.class;

    private final JsonConverter<Cell> deserializer;

    public CellFactoryImpl() {
        this.deserializer = new JsonConverterImpl<>(TYPE);
    }

    @Override
    public List<Cell> createCells() {
        return this.deserializer.jsonToList(ClassLoader.getSystemResourceAsStream(PATH));
    }

}
