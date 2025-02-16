package it.unibo.monoopoly.controller.impl;

import java.util.List;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.ModelPrisonState;
import it.unibo.monoopoly.model.impl.BuildHouseModelState;
import it.unibo.monoopoly.view.api.ViewState;
import it.unibo.monoopoly.view.impl.GameViewState;
import it.unibo.monoopoly.view.impl.MainPanel;
import it.unibo.monoopoly.view.impl.MainView;

/**
 * Implementation of {@link MainController}.
 */
public class MainControllerImpl implements MainController {

    //private final MainView mainView;
    private final Turn model;
    private ControllerState actualState;

    /**
     * Constructor that creates the model (TurnImpl) and the main view.
     * @param model the game model (Turn)
     * @param playersName list of players' names
     */
    public MainControllerImpl(final Turn model, final List<String> playersName) {
        this.model = model;
        final List<String> cellsNames = model.getGameBoard().getCellsNames();
        // Create the main view passing this controller, players' names, and the cells' names
        /*this.mainView = new MainView(this, playersName, cellsNames);
        this.mainView.display();*/
        this.actualState =  new ControllerBankerState(this);
    }

    /**
     * Starts the turn; as an example, if the current player is in prison the prison state is activated,
     * otherwise the house building state is activated.
     */

    /**
     * {@inheritDoc}
     */
    @Override
    public void startTurn() {
        /*// Get the MainPanel from the view and create the GameViewState
        MainPanel mainPanel = (MainPanel) mainView.getMainPanel();
        GameViewState viewState = new GameViewState(mainPanel);
        
        // If the current player is in prison
        if (model.getActualPlayer().isPrisoned()) {
            // Create and start the prison state
            PrisonModelState prisonState = new PrisonModelState(model.getActualPlayer());
            PrisonControllerState prisonController = new PrisonControllerState(prisonState, viewState);
            prisonController.startState();
            // Here input might come from the UI; for example, we simulate that the player chooses NOT to use the card (false)
            prisonController.continueState(false);
        } else {
            // Otherwise, proceed to the house building state
            BuildHouseModelState buildState = new BuildHouseModelState(model.getActualPlayer());
            BuildHouseControllerState buildController = new BuildHouseControllerState(buildState, viewState);
            buildController.startState();
            // Simulate input: for example, select index 0 (the first property)
            buildController.continueState(0);
        }*/
    }

    @Override
    public <X, Y> ModelState<X, Y> getModelState() {
        return this.model.getState();
    }

    @Override
    public <X, Y>ViewState<X, Y> getViewState() {
        //return this.mainView.getState();
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <X>ControllerState<X> getControllerState() {
        return this.actualState;
    }

    
}