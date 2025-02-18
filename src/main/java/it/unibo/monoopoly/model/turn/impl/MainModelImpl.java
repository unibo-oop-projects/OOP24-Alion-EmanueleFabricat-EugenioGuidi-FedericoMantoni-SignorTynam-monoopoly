package it.unibo.monoopoly.model.turn.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.deck.api.Deck;
import it.unibo.monoopoly.model.deck.impl.DeckImpl;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.gameboard.impl.CellFactoryImpl;
import it.unibo.monoopoly.model.gameboard.impl.GameBoardImpl;
import it.unibo.monoopoly.model.notary.api.Notary;
import it.unibo.monoopoly.model.notary.impl.NotaryImpl;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.player.impl.PlayerImpl;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.state.impl.ModelBankerState;
import it.unibo.monoopoly.model.turn.api.MainModel;

/**
 * Implements the {@link MainModel} interface.
 */
public class MainModelImpl implements MainModel {

    private static final int START_MONEY_AMOUNT = 1500;

    private Cell actualCell;
    private Optional<Event> actualEvent = Optional.empty();
    private Player actualPlayer;
    private final GameBoard gameBoard;
    private final Deck deck;
    private final ModelState actualState;

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
        this.deck = new DeckImpl();
        this.actualPlayer = gameBoard.getCurrentPlayer();
        this.actualState = new ModelBankerState(this, START_MONEY_AMOUNT);
        // TODO initialize state
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void movePhase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'movePhase'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void constructPhase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'constructPhase'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int rollDice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rollDice'");
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
    public Player getActualPlayer() {
        return this.actualPlayer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Cell> getCellsList() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCellsList'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setState(final ModelState state) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setState'");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GameBoard getGameBoard() {
        return this.gameBoard;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public Deck getDeck() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeck'");
    }

    @Override
    public Optional<Event> getEvent() {
        return this.actualEvent;
    }

}
