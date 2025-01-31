package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Functional;
import it.unibo.monoopoly.utils.Message;

/**
 * Implementation of {@link Functional} interface.
 */
public class FunctionalImpl extends AbstractCell implements Functional {

    private final Optional<Message> action;

    /**
     * Constructor of a cell 
     * @param name the name of the cell
     * @param action the action triggered by the cell
     */
    public FunctionalImpl(final String name, final Message action) {
            super(name);
            this.action = Optional.ofNullable(action);
        }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Message getAction() {
        return this.action.get();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasAction() {
        return this.action.isPresent();
    }

}
