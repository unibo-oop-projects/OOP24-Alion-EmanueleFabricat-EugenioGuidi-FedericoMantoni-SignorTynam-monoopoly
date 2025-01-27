package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Map;

import it.unibo.monoopoly.model.api.gameboard.Buildable;

public class BuildableImpl extends AbstractBuyable implements Buildable{

    private final Map<Integer, Integer> rentalMap;

    public BuildableImpl(final Map<Integer, Integer> rentalMap, final String name, final int cost) {
            super(name, cost);
            this.rentalMap = rentalMap;
        }
    
        @Override
    public int getRentalValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRentalValue'");
    }

    @Override
    public int getHouseCost() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHouseCost'");
    }

    @Override
    public void buildHouse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buildHouse'");
    }

    @Override
    public int sellHouse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sellHouse'");
    }

    @Override
    public int getHousesNumber() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getHousesNumber'");
    }

}
