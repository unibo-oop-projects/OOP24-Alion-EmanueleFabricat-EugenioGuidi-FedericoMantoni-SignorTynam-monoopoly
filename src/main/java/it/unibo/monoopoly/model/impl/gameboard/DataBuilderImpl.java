package it.unibo.monoopoly.model.impl.gameboard;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.api.DataBuilder;
import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;

public class DataBuilderImpl implements DataBuilder{    
    Optional<Event> event;
    Optional<String> nameOfProperty;
    Optional<String> nameOfPlayer;
    Optional<Pair> dices;
    Optional<Boolean> setMode1;
    Optional<Boolean> setMode2;
    Optional<List<Integer>> cellList;

    @Override
    public DataBuilder event(Event event) {
        this.event = Optional.of(event);
        return this;
    }

    @Override
    public DataBuilder nameOfProperty(String name) {
        this.nameOfProperty = Optional.of(name);
        return this;
    }

    @Override
    public DataBuilder nameOfPlayer(String name) {
        this.nameOfPlayer = Optional.of(name);
        return this;
    }

    @Override
    public DataBuilder dices(Pair dices) {
        this.dices = Optional.of(dices);
        return this;
    }

    @Override
    public DataBuilder setMode1(boolean mode) {
        this.setMode1 = Optional.of(mode);
        return this;
    }

    @Override
    public DataBuilder setMode2(boolean mode) {
        this.setMode2 = Optional.of(mode);
        return this;
    }

    @Override
    public DataBuilder cellList(List<Integer> list) {
        this.cellList =  Optional.of(list);
        return this;
    }

    @Override
    public DataBuilder build() {
        return this;
    }

}
