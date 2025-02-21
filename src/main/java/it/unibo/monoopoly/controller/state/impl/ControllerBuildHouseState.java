package it.unibo.monoopoly.controller.state.impl;

import java.util.List;
import java.util.stream.Collectors;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;
import it.unibo.monoopoly.model.main.api.MainModel;

/**
 * Implementation of the controller for the house building state.
 * Coordinates the interactions between the model and the view.
 */
public class ControllerBuildHouseState implements ControllerState {

    private final ModelState modelState;
    private final ViewState viewState;
    private boolean canBuild;

    /**
     * Constructs the controller for the house building state.
     * 
     * @param modelState the model state
     * @param viewState the view state
     */
    public ControllerBuildHouseState(ModelState modelState, ViewState viewState) {
        this.modelState = modelState;
        this.viewState = viewState;
    }

    /**
     * Starts the house building state.
     * Verifies if building is possible and sets the mode in the view.
     */
    @Override
    public void startState() {
        canBuild = modelState.verify();
        viewState.setMode(canBuild);

        GameBoard gameBoard = null;
        
        if (modelState instanceof MainModel) { 
            gameBoard = ((MainModel) modelState).getGameBoard();
        }

        if (gameBoard != null) {
            List<Integer> buildableCells = canBuild ? gameBoard.getCurrentPlayer().getProperties().stream()
                    .filter(p -> p instanceof Buildable)
                    .map(p -> (Buildable) p)
                    .filter(p -> p.getHousesNumber() < 5 && !p.isMortgaged())
                    .map(gameBoard.getCellsList()::indexOf)
                    .collect(Collectors.toList()) : List.of();

            DataBuilderInput dataBuilder = new DataBuilderInputImpl();
            viewState.visualize(dataBuilder.cellList(buildableCells).build());
        }
    }

    /**
     * Continues the execution of the state by performing the action corresponding to the user's choice.
     * 
     * @param data the data related to the cell chosen by the user
     */
    @Override
    public void continueState(DataOutput data) {
        modelState.doAction(data);
        modelState.closeState();
    }
}
