package it.unibo.monoopoly.utils.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.List;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.unibo.monoopoly.utils.api.JsonConverter;

/**
 * Generic implementation of interface {@link JsonConverter}.
 * 
 * @param <T> the class that the json file will be converted to
 */
public class JsonConverterImpl<T> implements JsonConverter<T> {

    private final Class<T> type;
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Create a converter for the given class.
     * @param type the class that the json file will be converted to
     */
    public JsonConverterImpl(final Class<T> type) {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> jsonToList(final InputStream fileJson) {
        final List<T> out;
        try {
            final JavaType outType = mapper.getTypeFactory()
                    .constructCollectionLikeType(List.class, type);
            out = mapper.readValue(fileJson, outType);
        } catch (final IOException e) {
            throw new UncheckedIOException("Failed to convert the Json file", e);
        }
        return out;
    }

}
