package it.unibo.monoopoly.controller.api;
/**
 * The model of the pattern State for the controller.
 */
public interface ControllerState<X> {
    /**
     * Launch the state, calling all the other state method in the right order.
     * {@link X} a type of data that is an input, output  or both.
     */
    void startState();
    /**
     * Continue the state until the end, calling all the remaining state method in the right order.
     * @param x a possible data to process.
     */
    void continueState(X x);
}
