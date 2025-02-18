package it.unibo.monoopoly.view.state.api;

import it.unibo.monoopoly.controller.data.impl.DataInput;

/**
 * The model of the pattern State for the view.
 */
public interface ViewState {
    /**
     * Set the state ready to be execute.
     * 
     * @param dataInput a possible data to help the setup.
     */
    void setMode(Boolean setter);

    /**
     * Display all the views necessary for the state.
     */
    void visualize(DataInput data);

}
