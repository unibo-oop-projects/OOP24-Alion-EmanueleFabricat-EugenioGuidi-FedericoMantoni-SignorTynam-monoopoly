package it.unibo.monoopoly.controller.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

public class PrisonControllerState implements ControllerState {

    private final ModelState modelState;
    private final ViewState viewState;
    private final MainModel mainModel;

    /**
     * Constructs the prison controller state.
     * 
     * @param modelState
     * @param viewState
     * @param mainModel
     */
    public PrisonControllerState(ModelState modelState, ViewState viewState, MainModel mainModel) {
        this.modelState = modelState;
        this.viewState = viewState;
        this.mainModel = mainModel;
    }

    /**
     * Starts the state.
     * 
     */
    @Override
    public void startState() {
        boolean goToJail = modelState.verify();
        viewState.setMode(goToJail);

        DataBuilderInput dataBuilder = new DataBuilderInputImpl();
        if (goToJail) {
            viewState.visualize(dataBuilder.build());
            modelState.doAction(new DataOutput(Optional.empty(), Optional.empty()));
        } else {
            Player currentPlayer = mainModel.getGameBoard().getCurrentPlayer();
            boolean hasCard = currentPlayer.getFreeJailCards() > 0;
            viewState.visualize(dataBuilder.mode(hasCard).build());
            modelState.doAction(new DataOutput(Optional.empty(), Optional.empty()));
        }
    }

    /**
     * Continues the state.
     * 
     * @param data
     */
    @Override
    public void continueState(DataOutput data) {
        modelState.closeState();
    }
}
