package it.unibo.monoopoly.model.api;
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
     * @param x a possible data to process.
     */
    void doAction();
    /**
     * ends the state and sets the next one.
     */
    void closeState();

}
