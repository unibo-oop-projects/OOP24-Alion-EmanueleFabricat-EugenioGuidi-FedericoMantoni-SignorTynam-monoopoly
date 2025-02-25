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

    public PositionsFactoryImpl(final int mainFrameHeight) {
        this.mainFrameHeight = mainFrameHeight;
        this.converter = new JsonConverterImpl<>(Position.class);
    }

    @Override
    public Map<Color, List<Position>> createPlayersPositions() {
        List<List<Position>> listFromJson = this.converter.jsonToListOfList(ClassLoader.getSystemResourceAsStream(PLAYERS_POSITIONS_FILE_NAME));
        List<Color> colors = List.of(Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE);
        Map<Color, List<Position>> playersPositions = IntStream.range(0, colors.size())
                                                            .boxed()
                                                            .collect(Collectors.toMap(colors::get, i -> updateList(listFromJson.get(i))
            ));

        return playersPositions;
    }

    private List<Position> updateList(final List<Position> list) {
        return list.stream()
                    .map(p -> new Position(p.x() * this.mainFrameHeight, p.y() * this.mainFrameHeight))
                    .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Position> createPropertyPositions() {
        Map<Integer, Position> propertyPositionsFromJson = this.converter.jsonToMap(ClassLoader.getSystemResourceAsStream(PROPERTY_POSITIONS_FILE_NAME));

        return updateMap(propertyPositionsFromJson);
    }

    private Map<Integer, Position> updateMap(final Map<Integer, Position> map) {
        Map<Integer, Position> newMap = new HashMap<>();
        for(var entry : map.entrySet()) {
            newMap.put(entry.getKey(), new Position(entry.getValue().x() * this.mainFrameHeight,
                                                    entry.getValue().y() * this.mainFrameHeight));
        }

        return newMap;
    }

    @Override
    public Map<Integer, Position> createHousesPositions() {
        Map<Integer, Position> housesPositionsFromJson = this.converter.jsonToMap(ClassLoader.getSystemResourceAsStream(HOUSES_POSITIONS_FILE_NAME));

        return updateMap(housesPositionsFromJson);
    }

    @Override
    public Map<Color, Position> createPrisonPositions() {
        return null;
    }

}
