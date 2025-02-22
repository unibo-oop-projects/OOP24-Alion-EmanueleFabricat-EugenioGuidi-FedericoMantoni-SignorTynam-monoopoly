package it.unibo.monoopoly.controller.main.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.api.DataBuilderOutput;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.controller.state.impl.ControllerBankerState;
import it.unibo.monoopoly.controller.state.impl.ControllerBuildHouseState;
import it.unibo.monoopoly.controller.state.impl.ControllerCardState;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.controller.state.impl.ControllerCheckActionState;
import it.unibo.monoopoly.controller.state.impl.ControllerMovementState;
import it.unibo.monoopoly.controller.state.impl.ControllerUnmortgageState;
import it.unibo.monoopoly.model.state.impl.ModelMovementState;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.state.impl.BuildHouseModelState;
import it.unibo.monoopoly.model.state.impl.ModelBankerState;
import it.unibo.monoopoly.model.state.impl.ModelBuildHouseState;
import it.unibo.monoopoly.model.state.impl.ModelCardState;
import it.unibo.monoopoly.model.state.impl.ModelCheckActionState;
import it.unibo.monoopoly.model.state.impl.ModelPrisonState;
import it.unibo.monoopoly.model.state.impl.ModelUnmortgageState;
import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.main.impl.MainViewImpl;
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
        this.mainView = new MainViewImpl(this, playersName, cellsNames);
        this.mainView.display();
        // this.actualState = new ControllerBankerState(this, this.model.getState(),
        // this.mainView.getViewState(), model.getGameBoard(), Event.SELL_HOUSE);
        this.actualState = new ControllerCheckActionState(this, this.model.getState(), this.mainView.getViewState(),
                this.model.getGameBoard());
        this.actualState.startState();
        // this.nextPhase();
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
        // TODO add call to update view
        this.actualState = switch (this.model.getState()) {
            // case ModelPrisontState p -> new ControllerPrisonState(this, model.getState(),
            // mainView.getViewState(), this.model.getGameboard());
            // case ModelMovementState m -> new ControllerMovementState(this,
            // model.getState(), mainView.getViewState(),
            // this.model.getGameBoard().getDices());
            case final ModelCheckActionState ca ->
                new ControllerCheckActionState(this, model.getState(), mainView.getViewState(), model.getGameBoard());
            // case ModelCardState c -> new ControllerCardState(this, model.getState(),
            // mainView.getViewState(), this.model.getGameBoard().getDeck());
            // case ModelBankerState b -> new ControllerBankerState(this, model.getState(),
            // mainView.getViewState(), this.model.getGameBoard());
            // case ModelBuildHouseState bh -> new ControllerBuildHouseState(this,
            // model.getState(), mainView.getViewState(), this.model.getGameBoard());
            case final ModelUnmortgageState u -> new ControllerUnmortgageState(this, model.getState(),
                    mainView.getViewState(), this.model.getGameBoard());
            default -> throw new IllegalArgumentException("Implementation of ModelState not supported");
        };
        this.actualState.startState();
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
     * {@inheritDoc}
     */
    @Override
    public Optional<Event> getActualEvent() {
        return this.model.getEvent();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewUpdateDTO getViewUpdateData() {
        return new ViewUpdateDTO(
                model.getGameBoard().getPlayersList().stream()
                        .collect(Collectors.toMap(Player::getName, Player::getActualPosition)),
                model.getGameBoard().getCellsList().stream().filter(Cell::isBuyable)
                        .collect(Collectors.toMap(this::cellToIndex,
                                c -> ((Buyable) c).getOwner().map(Player::getName))),
                model.getGameBoard().getCellsList().stream().filter(Cell::isBuildable)
                        .collect(Collectors.toMap(this::cellToIndex, c -> ((Buildable) c).getHousesNumber())),
                model.getGameBoard().getPlayersList().stream().filter(Player::isPrisoned).map(Player::getName).toList(),
                model.getGameBoard().getPlayersList().stream()
                        .collect(Collectors.toMap(Player::getName, Player::getMoneyAmount)),
                model.getGameBoard().getCurrentPlayer().getName());
    }

    private int cellToIndex(final Cell cell) {
        return this.model.getGameBoard().getCellsList().indexOf(cell);
    }
}
