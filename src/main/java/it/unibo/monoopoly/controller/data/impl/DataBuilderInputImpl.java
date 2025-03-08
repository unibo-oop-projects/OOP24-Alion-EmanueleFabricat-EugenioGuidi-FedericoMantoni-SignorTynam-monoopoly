package it.unibo.monoopoly.controller.data.impl;

import java.util.Map;
import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.model.gameboard.api.Dices.Pair;

/**
 * Implementation of the DataBuilderInput.
 */
public class DataBuilderInputImpl implements DataBuilderInput {
    private Optional<Event> event = Optional.empty();
    private Optional<Integer> valueToPAy = Optional.empty();
    private Optional<Pair> dices = Optional.empty();
    private Optional<Boolean> enabled = Optional.empty();
    private Optional<Map<Integer, Integer>> cellMap = Optional.empty();
    private Optional<String> text = Optional.empty();

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput cellMap(final Map<Integer, Integer> map) {
        this.cellMap = Optional.of(map);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput dices(final Pair dices) {
        this.dices = Optional.of(dices);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput event(final Event event) {
        this.event = Optional.of(event);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput enabled(final boolean mode) {
        this.enabled = Optional.of(mode);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput text(final String text) {
        this.text = Optional.of(text);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderInput valueToPay(final Integer value) {
        this.valueToPAy = Optional.of(value);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataInput build() {
        return new DataInput(this.cellMap, this.dices, this.event, this.enabled, this.text, this.valueToPAy);
    }

}
