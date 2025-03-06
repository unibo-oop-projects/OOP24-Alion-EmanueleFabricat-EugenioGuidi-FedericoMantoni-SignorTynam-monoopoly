package it.unibo.monoopoly.model.main.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.gameboard.impl.CellFactoryImpl;
import it.unibo.monoopoly.model.gameboard.impl.GameBoardImpl;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.player.impl.PlayerImpl;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.state.impl.ModelPrisonState;

/**
 * Implements the {@link MainModel} interface.
 */
public class MainModelImpl implements MainModel {

    private static final int START_MONEY_AMOUNT = 1500;

    private Optional<Event> actualEvent = Optional.empty();
    private final GameBoard gameBoard;
    private ModelState actualState;

    /**
     * Initialize the model and set the correct state of the game to start the first
     * turn.
     * 
     * @param playersName the list of the name of the players
     */
    public MainModelImpl(final List<String> playersName) {
        final List<Player> players = playersName.stream()
                .map(name -> new PlayerImpl(name, START_MONEY_AMOUNT, 0, false)).collect(Collectors.toList());
        this.gameBoard = new GameBoardImpl(new CellFactoryImpl().createCells(), players);
        this.actualState = new ModelPrisonState(this, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ModelState getState() {
        return this.actualState;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setState(final ModelState state) {
        this.actualState = state;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Event> getEvent() {
        return this.actualEvent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEvent(final Optional<Event> selectOperations) {
        this.actualEvent = selectOperations;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void nextTurn() {
        gameBoard.getNextPlayer(); //TODO Valore di ritorno non usato, si può togliere?
        this.actualState = new ModelPrisonState(this, false);
    }

}
