package it.unibo.monoopoly.controller.main.api;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * The main controller of the application.
 */
public interface MainController {

    /**
     * Start a new game turn.
     */
    void startTurn();

    /**
     * 
     * @return comment.
     */
    ControllerState getControllerState();

    /**
     * 
     * @return comment.
     */
    DataInput getDataInput();

    /**
     * 
     * @return the actual {@link Event} from the {@link MainModel}.
     */
    Optional<Event> getActualEvent();

    /**
     * Initialize nextPhase of the game creating the {@link ControllerState}
     * according to the actual {@link ModelState}.
     */
    void nextPhase();

    /**
     * 
     * @return the data to update the {@link MainView}.
     */
    ViewUpdateDTO getViewUpdateData();
}
