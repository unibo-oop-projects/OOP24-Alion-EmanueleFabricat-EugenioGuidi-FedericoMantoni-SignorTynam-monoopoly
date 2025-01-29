package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Map;

import it.unibo.monoopoly.model.api.gameboard.Buildable;

/**
 * Represents a buildable property in the game.
 */

public class BuildableImpl extends AbstractBuyable implements Buildable{

    private final Map<Integer, Integer> rentalMap;
    private int houses;
    private final int houseCost;
    private static final int MAX_HOUSES = 5;

    /**
     * Create a new buildable property.
     * 
     * @param rentalMap the map of rent values for the property
     * @param name the name of the property
     * @param cost the cost of the property
     * @param houseCost the cost of building a house on the property
     */
    public BuildableImpl(final Map<Integer, Integer> rentalMap, final String name, final int cost, final int houseCost) {
        super(name, cost);
        this.rentalMap = rentalMap;
        this.houses = 0;
        this.houseCost = houseCost;
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
     * @throws IllegalStateException if the property is mortgaged or there are already 5 houses on the property
     */

    @Override
    public void buildHouse() {
       this.checkMortgageAndHouseLimit(true);
       this.houses++;
    }

    /**
    * Remove a house from the property.
    * 
    * @return the houses
    * @throws IllegalStateException if the property is mortgaged or there are no houses on the property
    */
     
    @Override
    public int sellHouse() {
       this.checkMortgageAndHouseLimit(false);
       this.houses--;
       return this.getHouseCost() / 2;
    }
     
    /**
     * Verify if the property is mortgaged and if it is possible to build or sell houses.
     * @param isBuilding true if the operation is building a house, false if it is selling a house
     * @throws IllegalStateException if the property is mortgaged or there are already 5 houses on the property
     */
    private void checkMortgageAndHouseLimit(boolean isBuilding) {
        if (this.isMortgaged()) {
            throw new IllegalStateException("Cannot " + (isBuilding ? "build" : "sell") + " a house on a mortgaged property");
        }
     
        if (isBuilding) {
            if (this.houses >= MAX_HOUSES) {
                throw new IllegalStateException("Cannot build more than " + MAX_HOUSES + " houses on a property");
            }
        } else {
            if (this.houses <= 0) {
                throw new IllegalStateException("Cannot sell a house if there are no houses on the property");
            }
        }
    }
     
    /**
     * Return the number of houses on the property.
     * 
     * @return the houses
     */

    @Override
    public int getHousesNumber() {
        return this.houses;
    }

    @Override
    public int calculateRentalValue() {
        return this.rentalMap.get(this.houses);
    }
}
