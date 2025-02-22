package it.unibo.monoopoly.controller.data.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.model.gameboard.api.Dices.Pair;

/**
 * manca commento qui.
 */
public class DataBuilderInputImpl implements DataBuilderInput {
    private Optional<Event> event = Optional.empty();
    private Optional<Integer> valueToPAy = Optional.empty();
    private Optional<Pair> dices = Optional.empty();
    private Optional<Boolean> setMode = Optional.empty();
    private Optional<List<Integer>> cellList = Optional.empty();
    private Optional<String> text = Optional.empty();

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput cellList(List<Integer> list) {
        this.cellList = Optional.of(list);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput dices(Pair dices) {
        this.dices = Optional.of(dices);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput event(Event event) {
        this.event = Optional.of(event);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput setMode(boolean mode) {
        this.setMode = Optional.of(mode);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput text(String text) {
        this.text = Optional.of(text);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput valueToPay(Integer value) {
        this.valueToPAy = Optional.of(value);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataInput build() {
        return new DataInput(this.cellList, this.dices, this.event, this.setMode, this.text, this.valueToPAy);
    }

}
