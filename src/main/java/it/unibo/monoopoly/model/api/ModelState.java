package it.unibo.monoopoly.model.api;
/**
 * The model of the pattern State for the model.
 *{@link X} a type of data that is an input, output  or both.
 */
public interface ModelState <X>{
    /**
     * Set the state ready to be execute.
     */
    void verify();
    /**
     * Execute the state.
     * @param x a possible data to process.
     */
    void doAction(X x);
    /**
     * Return a data of the state.
     * @return the data.
     */
    X getData();
    /**
     * ends the state and sets the next one.
     */
    void closeState();

}
