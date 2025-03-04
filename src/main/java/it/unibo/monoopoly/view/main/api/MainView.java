package it.unibo.monoopoly.view.main.api;

import java.util.List;

import javax.swing.JPanel;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Represents the main view, contains the frame of the entire game.
 */
public interface MainView extends View {

    /**
     * 
     * @return the istance of the {@link MainController}
     */
    MainController getMainController();

    /**
     * 
     * @return the list of the names of all {@link Cell}s
     */
    List<String> getNameCells();

    /**
     * change the actual state of the view.
     * @param state the {@link ViewState} to set
     */
    void setState(ViewState state);

    void setInteractivePanel(JPanel panel);

    /**
     * 
     * @return the actual {@link ViewState}
     */
    ViewState getViewState();

    /**
     * Update the {@link View}.
     */
    void update();

    /**
     * visualize the end game with the winner.
     * @param player who won.
     */
    void endGame(String player);

}
