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
    ModelState getModelState();
    ModelState getModelState();

    /**
     * @return the actual {@link ViewStatus}
     */
    ViewState getViewState();
    ViewState getViewState();

    /* */
    ControllerState getControllerState();

}
