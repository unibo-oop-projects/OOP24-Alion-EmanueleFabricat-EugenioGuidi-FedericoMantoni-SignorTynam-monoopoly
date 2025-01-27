package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Map;

import it.unibo.monoopoly.model.api.gameboard.Buildable;

public class BuildableImpl extends AbstractBuyable implements Buildable{

    private final Map<Integer, Integer> rentalMap;
    private int houses;
    private final int houseCost;
    private static final int MAX_HOUSES = 5;

    public BuildableImpl(final Map<Integer, Integer> rentalMap, final String name, final int cost, final int houseCost) {
        super(name, cost);
        this.rentalMap = rentalMap;
        this.houses = 0;
        this.houseCost = houseCost;
    }
    
    @Override
    public int getRentalValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRentalValue'");
    }

    /**
     * Return the number of houses on the property.
     * 
     * @return the houseCost
     */

    @Override
    public int getHouseCost() {
        return this.houseCost;
    }

    /**
     * Add a house to the property.
     * 
     * @return the houses
     */

    @Override
    public void buildHouse() {
        if (this.isMortgaged()) {
            throw new IllegalStateException("Cannot build a house on a mortgaged property");
        }

        if (this.houses >= MAX_HOUSES) {
            throw new IllegalStateException("Cannot build more than " + MAX_HOUSES + " houses on a property");
        }
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
