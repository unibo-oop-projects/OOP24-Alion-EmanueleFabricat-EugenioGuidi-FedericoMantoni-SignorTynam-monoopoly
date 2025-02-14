package it.unibo.monoopoly.model.api;
/**
 * The model of the pattern State for the model.
 * @param <X> the input data type.
 * @param <Y> the output data type.
 */
public interface ModelState<X, Y> {
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
    void doAction(X x);
    /**
     * Return a data of the state.
     * @return the data.
     */
    Y getData();
    /**
     * ends the state and sets the next one.
     */
    void closeState();

}
