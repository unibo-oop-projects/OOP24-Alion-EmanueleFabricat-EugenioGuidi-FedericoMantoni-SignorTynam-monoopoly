package it.unibo.monoopoly.model.api.gameboard;

public interface Buildable extends Buyable{

    /**
     * method that return the cost of the next house.
     * 
     * @return the cost of the house
     */
    public int getHouseCost();

    /**
     * method that build house.
     * 
     */
    public void buildHouse();

    /**
     * method that return the value of selling a house.
     * 
     * @return the value of selling a house
     */
    public int sellHouse();

    /**
     * method that return the number of house constructed.
     * 
     * @return the number of house constructed
     */
    public int getHousesNumber();

}
