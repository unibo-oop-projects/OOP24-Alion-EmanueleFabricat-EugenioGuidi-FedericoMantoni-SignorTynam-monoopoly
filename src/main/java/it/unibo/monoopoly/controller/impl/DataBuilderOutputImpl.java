package it.unibo.monoopoly.controller.impl;

import java.util.Optional;


import it.unibo.monoopoly.controller.api.DataBuilderOutput;

public class DataBuilderOutputImpl implements DataBuilderOutput{
    Optional<Boolean> buyProperty;
    Optional<Integer> cellChoose;

    @Override
    public DataBuilderOutput buyProperty(boolean buy) {
        this.buyProperty = Optional.of(buy);
        return this;
    }

    @Override
    public DataBuilderOutput cellChoose(int cell) {
        this.cellChoose = Optional.of(cell);
        return this;
    }

    @Override
    public DataOutput build() {
        return new DataOutput(this.buyProperty, this.cellChoose);
    }
}
