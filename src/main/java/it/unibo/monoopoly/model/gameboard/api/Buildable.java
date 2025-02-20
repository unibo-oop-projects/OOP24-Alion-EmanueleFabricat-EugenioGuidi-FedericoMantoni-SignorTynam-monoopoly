package it.unibo.monoopoly.model.gameboard.api;

/**
 * This interface rapresents a buildable property in the game.
 * I allows to construct and sell haouses.
 */
public interface Buildable extends Buyable {

    /**
     * 
     * @return the cost of the house
     */
    int getHouseCost();

    /**
     * build a house if possible.
     * 
     */
    void buildHouse();

    /**
     * 
     * @return the value of selling a house
     */
    int sellHouse();

    /**
     * 
     * @return the number of house constructed
     */
    int getHousesNumber();

}
