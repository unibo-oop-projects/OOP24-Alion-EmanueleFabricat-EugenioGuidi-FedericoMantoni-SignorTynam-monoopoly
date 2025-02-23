package it.unibo.monoopoly.controller.data.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.api.DataBuilderOutput;

/**
 * manca commenti qui.
 */
public class DataBuilderOutputImpl implements DataBuilderOutput {
    private Optional<Boolean> buyProperty = Optional.empty();
    private Optional<Integer> cellChoose = Optional.empty();

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderOutput buyProperty(final boolean buy) {
        this.buyProperty = Optional.of(buy);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataBuilderOutput cellChoose(final int cell) {
        this.cellChoose = Optional.of(cell);
        return this;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataOutput build() {
        return new DataOutput(this.buyProperty, this.cellChoose);
    }
}
