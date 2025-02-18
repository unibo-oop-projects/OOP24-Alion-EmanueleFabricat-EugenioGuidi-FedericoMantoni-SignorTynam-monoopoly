package it.unibo.monoopoly.model.state.api;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataOutput;

/**
 * The model of the pattern State for the model.
 */
public interface ModelState {
    /**
     * Set the state ready to be execute.
     * 
     * @return a boolean the result of check.
     */
    boolean verify();

    /**
     * Execute the state.
     * 
     * @param data
     */
    void doAction(Optional<DataOutput> data);

    /**
     * ends the state and sets the next one.
     */
    void closeState();

}
