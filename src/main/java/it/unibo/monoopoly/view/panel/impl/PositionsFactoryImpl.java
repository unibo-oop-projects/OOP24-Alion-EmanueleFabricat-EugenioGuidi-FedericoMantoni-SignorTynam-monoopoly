package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import it.unibo.monoopoly.view.panel.api.PositionsFactory;
import it.unibo.monoopoly.utils.api.JsonConverter;
import it.unibo.monoopoly.utils.impl.JsonConverterImpl;

public class PositionsFactoryImpl implements PositionsFactory {

    private static final String PLAYERS_POSITIONS_FILE_NAME = "players_positions.json";
    private static final String PROPERTY_POSITIONS_FILE_NAME = "property_positions.json";
    private static final String HOUSES_POSITIONS_FILE_NAME = "houses_positions.json";
    private static final String PRISON_POSITIONS_FILE_NAME = "prison_positions.json";
    private static final int NUMBER_OF_PLAYERS = 4;

    private JsonConverter<Position> converter;
    private final int mainFrameHeight;

    public PositionsFactoryImpl(final int mainFrameHeight) {
        this.mainFrameHeight = mainFrameHeight;
        this.converter = new JsonConverterImpl<>(Position.class);
    }

    @Override
    public Map<Color, Map<Integer, Position>> createPlayersPositions() {
        List<Position> newList = this.converter.jsonToList(ClassLoader.getSystemResourceAsStream(PLAYERS_POSITIONS_FILE_NAME));
        Map<Color, Map<Integer, Position>> playersPositions = new HashMap<>();
        int index = 0;
        final List<Position> blueList = portionOfList(newList, index++);
        final List<Position> redList = portionOfList(newList, index++);
        final List<Position> greenList = portionOfList(newList, index++);
        final List<Position> orangeList = portionOfList(newList, index++);

        playersPositions.put(Color.BLUE, transformListToMap(blueList));
        playersPositions.put(Color.RED, transformListToMap(redList));
        playersPositions.put(Color.GREEN, transformListToMap(greenList));
        playersPositions.put(Color.ORANGE, transformListToMap(orangeList));

        return playersPositions;
    }

    private List<Position> portionOfList(final List<Position> newList, final int index) {
        List<Position> tempList = new ArrayList<>();
        final int upperExtreme = (index * newList.size()) / NUMBER_OF_PLAYERS;
        final int lowerExtreme = ((index + 1) * newList.size()) / NUMBER_OF_PLAYERS;

        for(int i = upperExtreme ; i < lowerExtreme ; i++) {
            tempList.add(newList.get(i));
        }

        return tempList;
    }

    private Map<Integer, Position> transformListToMap(final List<Position> partialList) {
        List<Position> newPartialListUpdated = updateList(partialList);
        Map<Integer, Position> positionMap = new HashMap<>();

        for(int i = 0; i < newPartialListUpdated.size() ; i++) {
            positionMap.put(i, newPartialListUpdated.get(i));
        }

        return positionMap;
    }

    private List<Position> updateList(final List<Position> newList) {
        return newList.stream()
                    .map(p -> new Position(p.x() * this.mainFrameHeight, p.y() * this.mainFrameHeight))
                    .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, Position> createPropertyPositions() {
        return null;
    }

    @Override
    public Map<Integer, Position> createHousesPositions() {
        return null;
    }

    @Override
    public Map<Color, Position> createPrisonPositions() {
        return null;
    }

}
