package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.monoopoly.view.panel.api.PositionsFactory;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

public class PositionsFactoryImpl implements PositionsFactory {

    private static final String PLAYERS_POSITIONS_FILE_NAME = "players_positions.json";
    private static final String PROPERTY_POSITIONS_FILE_NAME = "property_positions.json";
    private static final String HOUSES_POSITIONS_FILE_NAME = "houses_positions.json";
    private static final String PRISON_POSITIONS_FILE_NAME = "prison_positions.json";

    private JsonConverter<Position> converter;
    private final int mainFrameHeight;
    private final List<Color> colors;

    public PositionsFactoryImpl(final int mainFrameHeight) {
        this.mainFrameHeight = mainFrameHeight;
        this.converter = new JsonConverterImpl<>(Position.class);
        this.colors = List.of(Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE);
    }

    @Override
    public Map<Color, List<Position>> createPlayersPositions() {
        final List<List<Position>> listFromJson = this.converter.jsonToListOfList(ClassLoader.getSystemResourceAsStream(PLAYERS_POSITIONS_FILE_NAME));
        return IntStream.range(0, this.colors.size())
                        .boxed()
                        .collect(Collectors.toMap(this.colors::get, i -> updateList(listFromJson.get(i))));
    }

    @Override
    public Map<Integer, Position> createPropertyPositions() {
        Map<Integer, Position> propertyPositionsFromJson = this.converter.jsonToMap(ClassLoader.getSystemResourceAsStream(PROPERTY_POSITIONS_FILE_NAME));

        return updateMap(propertyPositionsFromJson);
    }

    private Map<Integer, Position> updateMap(final Map<Integer, Position> map) {
        final Map<Integer, Position> newMap = new HashMap<>();
        for(var entry : map.entrySet()) {
            newMap.put(entry.getKey(), new Position(entry.getValue().x() * this.mainFrameHeight,
                                                    entry.getValue().y() * this.mainFrameHeight));
        }

        return newMap;
    }

    @Override
    public Map<Integer, Position> createHousesPositions() {
        final Map<Integer, Position> housesPositionsFromJson = this.converter.jsonToMap(ClassLoader.getSystemResourceAsStream(HOUSES_POSITIONS_FILE_NAME));

        return updateMap(housesPositionsFromJson);
    }

    @Override
    public Map<Color, Position> createPrisonPositions() {
        final List<Position> newList = updateList(this.converter.jsonToList(ClassLoader.getSystemResourceAsStream(PRISON_POSITIONS_FILE_NAME)));
        return IntStream.range(0, colors.size())
                        .boxed()
                        .collect(Collectors.toMap(colors::get, i -> newList.get(i)));
    }

    private List<Position> updateList(final List<Position> list) {
        return list.stream()
                    .map(p -> new Position(p.x() * this.mainFrameHeight, p.y() * this.mainFrameHeight))
                    .collect(Collectors.toList());
    }

}
