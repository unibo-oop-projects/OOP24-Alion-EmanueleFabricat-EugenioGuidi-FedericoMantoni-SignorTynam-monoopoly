package it.unibo.monoopoly.utils.impl;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.api.PositionsFactory;

public class PositionsFactoryImpl implements PositionsFactory {

    private static final String PLAYERS_POSITIONS_FILE_NAME = "players_positions.json";
    private static final String PROPERTY_POSITIONS_FILE_NAME = "property_positions.json";
    private static final String HOUSES_POSITIONS_FILE_NAME = "houses_positions.json";
    private static final String PRISON_POSITIONS_FILE_NAME = "prison_positions.json";

    private final JsonConverter<Position> converter;
    private final int mainFrameHeight;
    private final List<Color> colors;

    public PositionsFactoryImpl(final int mainFrameHeight, final List<Color> colors) {
        this.mainFrameHeight = mainFrameHeight;
        this.converter = new JsonConverterImpl<>(Position.class);
        this.colors = colors;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Color, List<Position>> createPlayersPositions() {
        final List<List<Position>> listFromJson = this.converter
                .jsonToListOfList(ClassLoader.getSystemResourceAsStream(PLAYERS_POSITIONS_FILE_NAME));
        return IntStream.range(0, this.colors.size())
                .boxed()
                .collect(Collectors.toMap(this.colors::get, i -> updateList(listFromJson.get(i))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Integer, Position> createPropertyPositions() {
        final Map<Integer, Position> propertyPositionsFromJson = this.converter
                .jsonToMap(ClassLoader.getSystemResourceAsStream(PROPERTY_POSITIONS_FILE_NAME));

        return updateMap(propertyPositionsFromJson);
    }

    private Map<Integer, Position> updateMap(final Map<Integer, Position> map) {
        final Map<Integer, Position> newMap = new HashMap<>();
        for (final var entry : map.entrySet()) {
            newMap.put(entry.getKey(), new Position(entry.getValue().x() / 100 * this.mainFrameHeight,
                    entry.getValue().y() / 100 * this.mainFrameHeight));
        }

        return newMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Integer, Position> createHousesPositions() {
        final Map<Integer, Position> housesPositionsFromJson = this.converter
                .jsonToMap(ClassLoader.getSystemResourceAsStream(HOUSES_POSITIONS_FILE_NAME));

        return updateMap(housesPositionsFromJson);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Color, Position> createPrisonPositions() {
        final List<Position> newList = updateList(
                this.converter.jsonToList(ClassLoader.getSystemResourceAsStream(PRISON_POSITIONS_FILE_NAME)));
        return IntStream.range(0, colors.size())
                .boxed()
                .collect(Collectors.toMap(colors::get, newList::get));
    }

    private List<Position> updateList(final List<Position> list) {
        return list.stream()
                .map(p -> new Position(p.x() / 100 * this.mainFrameHeight, p.y() / 100 * this.mainFrameHeight))
                .collect(Collectors.toList());
    }

}
