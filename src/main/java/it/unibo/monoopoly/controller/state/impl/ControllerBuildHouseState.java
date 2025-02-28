package it.unibo.monoopoly.controller.state.impl;

import java.util.List;
import java.util.stream.Collectors;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementation of the controller for the house building state.
 * Coordinates the interactions between the model and the view.
 */
public class ControllerBuildHouseState implements ControllerState {

    private static final int MAX_HOUSES = 5;
    private final ModelState modelState;
    private final ViewState viewState;
    private final MainController mainController;
    private final GameBoard gameBoard;
    private boolean canBuild;

    /**
     * Constructs the controller for the house building state.
     * 
     * @param modelState the model state
     * @param viewState the view state
     */
    public ControllerBuildHouseState(final MainController mainController, final ModelState modelState, final ViewState viewState, final GameBoard gameBoard) {
        this.modelState = modelState;
        this.viewState = viewState;
        this.mainController = mainController;
        this.gameBoard = gameBoard;
    }

    /**
     * Starts the house building state.
     * Verifies if building is possible and sets the mode in the view.
     */
    @Override
    public void startState() {
        canBuild = modelState.verify();
        viewState.setMode(canBuild);
        if (this.gameBoard != null) {
            final List<Integer> buildableCells = canBuild 
                ? this.gameBoard.getCurrentPlayer().getProperties().stream()
                    .filter(p -> p instanceof Buildable)
                    .map(p -> (Buildable) p)
                    .filter(p -> p.getHousesNumber() < MAX_HOUSES && !p.isMortgaged())
                    .filter(p -> this.gameBoard.getCurrentPlayer().isPayable(p.getHouseCost()))
                    .map(this.gameBoard.getCellsList()::indexOf)
                    .collect(Collectors.toList())
                : List.of();
            final DataBuilderInput dataBuilder = new DataBuilderInputImpl();
            viewState.visualize(dataBuilder.cellList(buildableCells).build());
        }
    }

    /**
     * Continues the execution of the state by performing the action corresponding to the user's choice.
     * 
     * @param data the data related to the cell chosen by the user
     */
    @Override
    public void continueState(final DataOutput data) {
        if (canBuild) {
            modelState.doAction(data);
        }
        modelState.closeState();
        mainController.nextPhase();
    }
}
