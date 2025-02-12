package it.unibo.monoopoly.model.impl.player;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.NotaryImpl;

/**
 * Implements the {@link Turn} interface.
 */
public class TurnImpl implements Turn {

    private Cell actualCell;
    private final Notary notary = new NotaryImpl();
    private Player actualPlayer;

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
    public Optional<Event> checkAction() {
        if (this.actualCell.isBuyable()) {
            return this.notary.checkProperty(this.actualPlayer, (Buyable) this.actualCell);
        } else {
            return Optional.empty(); //TODO manage others cases
        }
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
    public Player getPhase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPhase'");
    }

    @Override
    public Player getActualPlayer() {
        return this.actualPlayer;
    }

}
