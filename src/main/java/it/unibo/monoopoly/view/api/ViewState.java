package it.unibo.monoopoly.view.api;
/**
 * The model of the pattern State for the view.
 * @param <X>, @param <Y> types of data that are an input, output or both.
 */
public interface ViewState<X, Y> {
    /**
     * Set the state ready to be execute.
     * @param x a possible data to help the setup.
     */
    void setMode(X x);
    /**
     * Display all the views necessary for the state.
     * @param y a possible data to display.
     */
    void visualize(Y y);

}
