package it.unibo.monoopoly.controller.impl;

import java.util.List;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.gameboard.GameBoard;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.view.impl.MainView;

/**
 * Implementation of {@link MainController}.
 */
public class MainControllerImpl implements MainController {

    // private final ControllerState<?> actualState;
    private final MainView mainView;
    private final Turn model;

    /**
     * Construct the main controller and the main view and call the model to start
     * the first turn.
     * 
     * @param model       the model of the application
     * @param playersName the names of the players
     */
    public MainControllerImpl(final Turn model, final List<String> playersName) {
        this.model = model;
        final List<String> cellsNames = model.getGameBoard().getCellsNames();
        this.mainView = new MainView(this, playersName, cellsNames);
        this.mainView.display();
        // this.actualState = new PrisonControllerState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startTurn() {
        // this.actualState.startState();
    }

}
