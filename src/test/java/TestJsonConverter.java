import java.util.List;

import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

public class TestJsonConverter {

    private JsonConverter<Cell> converter;
    private List<Cell> result;

    @Test
    void testConversion() {
        this.converter = new JsonConverterImpl<>(Cell.class);
        result = converter.jsonToList(ClassLoader.getSystemResourceAsStream("cells.json"));
    }

}
