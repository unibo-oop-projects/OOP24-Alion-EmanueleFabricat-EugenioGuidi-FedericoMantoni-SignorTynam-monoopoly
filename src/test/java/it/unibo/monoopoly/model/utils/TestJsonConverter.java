package it.unibo.monoopoly.model.utils;

import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.gameboard.Cell;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

/**
 * Test for the Json deserialization.
 */
class TestJsonConverter {

    @Test
    void testConversion() {
        final JsonConverter<Cell> converter;
        converter = new JsonConverterImpl<>(Cell.class);
        converter.jsonToList(ClassLoader.getSystemResourceAsStream("cells.json"));
    }

}
