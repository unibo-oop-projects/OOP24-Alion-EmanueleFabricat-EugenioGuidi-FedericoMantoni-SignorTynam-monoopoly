package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import it.unibo.monoopoly.model.api.gameboard.Functional;
import it.unibo.monoopoly.utils.Message;

/**
 * Implementation of {@link Functional} interface.
 */
@JsonTypeName("Functional")
public class FunctionalImpl extends AbstractCell implements Functional {

    private final Optional<Message> action;

    /**
     * Constructor of a functional cell.
     * 
     * @param name the name of the cell
     * @param effect the action triggered by the cell, can be null
     */
    public FunctionalImpl(
        @JsonProperty("name")final String name,
        @JsonProperty("effect")final Message effect
    ) {
        super(name);
        this.action = Optional.ofNullable(effect);
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
