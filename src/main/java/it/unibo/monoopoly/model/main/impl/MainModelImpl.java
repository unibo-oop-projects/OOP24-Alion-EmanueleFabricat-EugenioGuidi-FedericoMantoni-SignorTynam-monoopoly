package it.unibo.monoopoly.model.main.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.deck.api.Deck;
import it.unibo.monoopoly.model.deck.impl.DeckImpl;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.gameboard.impl.CellFactoryImpl;
import it.unibo.monoopoly.model.gameboard.impl.GameBoardImpl;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.notary.api.Notary;
import it.unibo.monoopoly.model.notary.impl.NotaryImpl;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.player.impl.PlayerImpl;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.state.impl.ModelBankerState;
import it.unibo.monoopoly.model.state.impl.ModelCheckActionState;

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
                .map(name -> new PlayerImpl(name, START_MONEY_AMOUNT, 1, false)).collect(Collectors.toList());
        this.gameBoard = new GameBoardImpl(new CellFactoryImpl().createCells(), players);
        //this.deck = new DeckImpl();
        // this.actualPlayer = gameBoard.getCurrentPlayer();
        this.actualState = new ModelBankerState(this, START_MONEY_AMOUNT, false);
        // TODO initialize state : new ModelPrisonState(this, false);
        this.setState(new ModelCheckActionState(this));
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
    public void setEvent(Event selectOperations) {
        this.actualEvent = Optional.of(selectOperations);
    }

    @Override
    public void nextTurn() {
        gameBoard.getNextPlayer(); //TODO Valore di ritorno non usato, si può togliere?
        //this.actualState = new ModelPrisonState(this, false) 
    }

}
