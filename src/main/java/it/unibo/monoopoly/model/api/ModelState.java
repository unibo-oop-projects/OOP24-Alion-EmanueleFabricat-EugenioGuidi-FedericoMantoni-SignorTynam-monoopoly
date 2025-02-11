package it.unibo.monoopoly.model.api;
/**
 * The model of the pattern State for the model.
 */
public interface ModelState <X>{
    /**
     * Set the state ready to be done.
     */
    void verify();
    /**
     * Execute the state.
     * @param x a possible data  to elaborate.
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
