package it.unibo.monoopoly.model.api;

import it.unibo.monoopoly.controller.impl.DataOutput;

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
     */
    void doAction(DataOutput data);
    /**
     * ends the state and sets the next one.
     */
    void closeState();

}
