package it.unibo.monoopoly.controller.api;
/**
 * The model of the pattern State for the controller.
 * @param <X> a type of data that is an input for the status.
*/
public interface ControllerState<X> {
    /**
     * Launch the state, calling all the other state method in the right order.
     */
    void startState();
    /**
     * Continue the state until the end, calling all the remaining state method in the right order.
     * @param x a possible data to process.
     */
    void continueState(X x);
}
