package it.unibo.monoopoly.model.api.gameboard;

public interface GameBoard {

    /**
     * method that return the return the cell in the index position.
     * 
     * @param index, index of cell
     * @return the cell in the index position
     */
    Cell getCell(int index);

    /**
     * method that remove a player from the game.
     * 
     */
    void removePlayer();

    /**
     * method that control if the game is ended controlling the number of player remaining.
     * 
     * @return true if the game is ended.
     */
    boolean isGameEnded();

}
