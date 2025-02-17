package it.unibo.monoopoly.controller.api;


import it.unibo.monoopoly.controller.impl.DataInput;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.state.api.ControllerState;
import it.unibo.monoopoly.view.api.ViewState;

/**
 * The main controller of the application.
 */
public interface MainController {

    /**
     * Start a new game turn.
     */
    void startTurn();

    /**
     * @return the actual {@link ModelState}
     */
    ModelState getModelState();

    /**
     * @return the actual {@link ViewStatus}
     */
    ViewState getViewState();

    /* */
    ControllerState getControllerState();

    /* */
    DataInput getDataInput();
}
