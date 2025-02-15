package it.unibo.monoopoly.controller.api;

import it.unibo.monoopoly.model.api.ModelState;
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
    <X, Y>ModelState<X, Y> getModelState();

    /**
     * @return the actual {@link ViewStatus}
     */
    <X, Y>ViewState<X, Y> getViewState();

    /* */
    <X>ControllerState<X> getControllerState();

}
