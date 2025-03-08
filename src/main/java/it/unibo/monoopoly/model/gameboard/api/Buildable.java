package it.unibo.monoopoly.model.gameboard.api;

/**
 * This interface rapresents a buildable property in the game that implements
 * {@link Buyable}.
 * The class is used to construct and sell houses.
 */
public interface Buildable extends Buyable {

    /**
     * @return the cost of the house.
     */
    int getHouseCost();

    /**
     * build a house if possible.
     */
    void buildHouse();

    /**
     * @return the value of selling a house.
     */
    int sellHouse();

    /**
     * @return the number of house constructed.
     */
    int getHousesNumber();

    /**
     * @return the cost of selling house.
     */
    int getSellHouseCost();

}
