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
import it.unibo.monoopoly.model.main.api.MainModel;  // Assumendo che MainModel sia la classe concreta

public class ControllerBuildHouseState implements ControllerState {

    private final ModelState modelState;
    private final ViewState viewState;
    private boolean canBuild;

    public ControllerBuildHouseState(ModelState modelState, ViewState viewState) {
        this.modelState = modelState;
        this.viewState = viewState;
    }

    @Override
    public void startState() {
        canBuild = modelState.verify();
        viewState.setMode(canBuild);

        // Assumiamo che ModelState sia effettivamente un MainModel, quindi lo facciamo castare
        GameBoard gameBoard = null;
        
        if (modelState instanceof MainModel) {  // Controlla se modelState è di tipo MainModel
            gameBoard = ((MainModel) modelState).getGameBoard();  // Ottieni il GameBoard da MainModel
        }

        if (gameBoard != null) {
            List<Integer> buildableCells = canBuild ? gameBoard.getCurrentPlayer().getProperties().stream()
                    .filter(p -> p instanceof Buildable) // Assicura che sia una proprietà buildabile
                    .map(p -> (Buildable) p) // Cast a Buildable
                    .filter(p -> p.getHousesNumber() < 5 && !p.isMortgaged()) // Usa il metodo getHousesNumber() e isMortgaged()
                    .map(gameBoard.getCellsList()::indexOf)
                    .collect(Collectors.toList()) : List.of();

            DataBuilderInput dataBuilder = new DataBuilderInputImpl();
            viewState.visualize(dataBuilder.cellList(buildableCells).build());
        }
    }

    @Override
    public void continueState(DataOutput data) {
        modelState.doAction(data);
        modelState.closeState();
    }
}
