import java.util.List;

import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

public class TestJsonConverter {

    private JsonConverter<Buyable> converter;
    private List<Buyable> result;

    @Test
    void testConversion() {
        this.converter = new JsonConverterImpl<>(Buyable.class);
        result = converter.jsonToList(ClassLoader.getSystemResourceAsStream("cells.json"));
    }

}
