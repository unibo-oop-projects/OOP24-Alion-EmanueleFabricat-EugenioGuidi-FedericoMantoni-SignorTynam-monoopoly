package it.unibo.monoopoly.controller.data.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.api.DataBuilderOutput;

public class DataBuilderOutputImpl implements DataBuilderOutput {
    Optional<Boolean> buyProperty;
    Optional<Integer> cellChoose;

    @Override
    public DataBuilderOutput buyProperty(final boolean buy) {
        this.buyProperty = Optional.of(buy);
        return this;
    }

    @Override
    public DataBuilderOutput cellChoose(final int cell) {
        this.cellChoose = Optional.of(cell);
        return this;
    }

    @Override
    public DataOutput build() {
        return new DataOutput(this.buyProperty, this.cellChoose);
    }
}
