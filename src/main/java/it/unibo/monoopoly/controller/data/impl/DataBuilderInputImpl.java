package it.unibo.monoopoly.controller.data.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.model.gameboard.api.Dices.Pair;

public class DataBuilderInputImpl implements DataBuilderInput {
    Optional<Event> event;
    Optional<String> nameOfProperty;
    Optional<String> nameOfPlayer;
    Optional<Integer> valueToPay;
    Optional<Pair> dices;
    Optional<Boolean> setMode1;
    Optional<Boolean> setMode2;
    Optional<List<Integer>> cellList;
    Optional<String> cardText;

    @Override
    public DataBuilderInput event(final Event event) {
        this.event = Optional.of(event);
        return this;
    }

    @Override
    public DataBuilderInput nameOfProperty(final String name) {
        this.nameOfProperty = Optional.of(name);
        return this;
    }

    @Override
    public DataBuilderInput nameOfPlayer(final String name) {
        this.nameOfPlayer = Optional.of(name);
        return this;
    }

    @Override
    public DataBuilderInput dices(final Pair dices) {
        this.dices = Optional.of(dices);
        return this;
    }

    @Override
    public DataBuilderInput setMode1(final boolean mode) {
        this.setMode1 = Optional.of(mode);
        return this;
    }

    @Override
    public DataBuilderInput setMode2(final boolean mode) {
        this.setMode2 = Optional.of(mode);
        return this;
    }

    @Override
    public DataBuilderInput cellList(final List<Integer> list) {
        this.cellList = Optional.of(list);
        return this;
    }

    @Override
    public DataBuilderInput valueToPay(final Integer value) {
        this.valueToPay = Optional.of(value);
        return this;
    }

    @Override
    public DataBuilderInput cardText(final String text) {
        this.cardText = Optional.of(text);
        return this;
    }

    @Override
    public DataInput build() {
        return new DataInput(this.event, this.nameOfProperty, this.nameOfPlayer, this.valueToPay, this.dices,
                this.setMode1, this.setMode2, this.cellList, this.cardText);
    }

}
