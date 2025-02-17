package it.unibo.monoopoly.model.impl.player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.GameBoard;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.NotaryImpl;
import it.unibo.monoopoly.model.impl.card.DeckImpl;
import it.unibo.monoopoly.model.impl.gameboard.CellFactoryImpl;
import it.unibo.monoopoly.model.impl.gameboard.GameBoardImpl;

/**
 * Implements the {@link Turn} interface.
 */
public class TurnImpl implements Turn {

    private static final int START_MONEY_AMOUNT = 1500;

    private Cell actualCell;
    private Optional<Event> actualEvent = Optional.empty();
    private Player actualPlayer;
    private final GameBoard gameBoard;
    private final Deck deck;
    private ModelState actualState;

    /**
     * Initialize the model and set the correct state of the game to start the first turn.
     * @param playersName the list of the name of the players
     */
    public TurnImpl(final List<String> playersName) {
        final List<Player> players = playersName.stream()
                .map(name -> new PlayerImpl(name, START_MONEY_AMOUNT, 0)).collect(Collectors.toList());
        this.gameBoard = new GameBoardImpl(new CellFactoryImpl().createCells(), players);
        this.deck = new DeckImpl();
        this.actualPlayer = gameBoard.getCurrentPlayer();
        this.actualState = new ModelBankerState(this, START_MONEY_AMOUNT);
        //TODO initialize state
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
    public void setState(ModelState state) {
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
