package it.unibo.monoopoly.controller.main.impl;

import java.util.List;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.api.DataBuilderOutput;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.controller.state.impl.ControllerBankerState;
import it.unibo.monoopoly.controller.state.impl.ControllerCheckActionState;
import it.unibo.monoopoly.controller.state.impl.ControllerMovementState;
import it.unibo.monoopoly.model.state.impl.ModelMovementState;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.state.impl.BuildHouseModelState;
import it.unibo.monoopoly.model.state.impl.ModelCheckActionState;
import it.unibo.monoopoly.model.state.impl.ModelPrisonState;
import it.unibo.monoopoly.model.turn.api.MainModel;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.panel.impl.MainPanel;
import it.unibo.monoopoly.view.state.api.ViewState;
import it.unibo.monoopoly.view.state.impl.GameViewState;

/**
 * Implementation of {@link MainController}.
 */
public class MainControllerImpl implements MainController {

    private final MainView mainView;
    private final MainModel model;
    private ControllerState actualState;
    private DataInput inputData;

    /**
     * Constructor that creates the model (TurnImpl) and the main view.
     * 
     * @param model       the game model (Turn)
     * @param playersName list of players' names
     */
    public MainControllerImpl(final MainModel model, final List<String> playersName) {
        this.model = model;
        final List<String> cellsNames = model.getGameBoard().getCellsNames();
        // Create the main view passing this controller, players' names, and the cells'
        // names
        this.mainView = new MainView(this, playersName, cellsNames);
        this.mainView.display();
        this.actualState = new ControllerBankerState(this, this.getModelState(), this.getViewState());
    }

    /**
     * Starts the turn; as an example, if the current player is in prison the prison
     * state is activated,
     * otherwise the house building state is activated.
     */

     /**
      * {@inheritDoc}
      */
    @Override
    public void nextPhase() {
        /*this.actualState = switch (this.model.getState()) {
            //case ModelPrisontState p -> new ControllerPrisonState(this, getModelState(), getViewState(), this.model.getGameboard());
            //case ModelMovementState m -> new ControllerMovementState(this, getModelState(), getViewState(), this.model.getGameboard().getDices());
            //case ModelCheckActionState ca -> new ControllerCheckActionState(this, getModelState(), getViewState(), model.getGameBoard().getCurrentPlayer());
            //case ModelCardState c -> new ControllerCardState(this, getModelState(), getViewState(), this.model.getGameboard().getDeck());
            //case ModelBankerState b -> new ControllerBankerState(this, getModelState(), getViewState(), this.model.getGameboard());
            //case ModelBuildHouseState bh -> new ControllerBuildHouseState(this, getModelState(), getViewState(), this.model.getGameboard());
            //case ModelUnmortgageTest u -> new ControllerUnmortgageState(this, getModelState(), getViewState(), this.model.getGameboard());
            default -> throw new IllegalArgumentException();
        };*/

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startTurn() {
        /*
         * // Get the MainPanel from the view and create the GameViewState
         * MainPanel mainPanel = (MainPanel) mainView.getMainPanel();
         * GameViewState viewState = new GameViewState(mainPanel);
         * 
         * // If the current player is in prison
         * if (model.getActualPlayer().isPrisoned()) {
         * // Create and start the prison state
         * PrisonModelState prisonState = new PrisonModelState(model.getActualPlayer());
         * PrisonControllerState prisonController = new
         * PrisonControllerState(prisonState, viewState);
         * prisonController.startState();
         * // Here input might come from the UI; for example, we simulate that the
         * player chooses NOT to use the card (false)
         * prisonController.continueState(false);
         * } else {
         * // Otherwise, proceed to the house building state
         * BuildHouseModelState buildState = new
         * BuildHouseModelState(model.getActualPlayer());
         * BuildHouseControllerState buildController = new
         * BuildHouseControllerState(buildState, viewState);
         * buildController.startState();
         * // Simulate input: for example, select index 0 (the first property)
         * buildController.continueState(0);
         * }
         */
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public ModelState getModelState() {
        return this.model.getState();
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public ViewState getViewState() {
        // return this.mainView.getState();
        return null;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public ControllerState getControllerState() {
        return this.actualState;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public DataInput getDataInput() {
        return this.inputData;
    }
}
