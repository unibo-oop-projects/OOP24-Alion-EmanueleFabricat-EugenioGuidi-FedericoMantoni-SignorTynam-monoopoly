package it.unibo.monoopoly.controller.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.api.DataBuilderInput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderInputImpl;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.state.api.ControllerState;
import it.unibo.monoopoly.model.gameboard.api.GameBoard;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.view.state.api.ViewState;

public class PrisonControllerState implements ControllerState {

    private final ModelState modelState;
    private final MainController mainController;
    private final ViewState viewState;
    private final Player player;

    /**
     * Constructs the prison controller state.
     * 
     * @param modelState
     * @param viewState
     * @param mainModel
     */
    public PrisonControllerState(MainController mainController, ModelState modelState, ViewState viewState, Player player) {
        this.modelState = modelState;
        this.viewState = viewState;
        this.player = player;
        this.mainController = mainController;
    }

    /**
     * Starts the state.
     * 
     * <p>
     * If the player must go to jail, the state is visualized and the player is sent
     * to jail. If the player must exit jail, the state is visualized and the player
     * is given the option to use a "Get Out of Jail Free" card or pay €50.
     * </p>
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
            Player currentPlayer = this.player;
            if(currentPlayer.isPrisoned()) {
                boolean hasCard = currentPlayer.getFreeJailCards() > 0;
                viewState.visualize(dataBuilder.mode(hasCard).build());
                modelState.doAction(new DataOutput(Optional.empty(), Optional.empty()));
            }
        }
        this.continueState(new DataBuilderOutputImpl().build());
    }

    /**
     * Continues the state.
     * 
     * @param data
     */
    @Override
    public void continueState(DataOutput data) {
        modelState.closeState();
        mainController.nextPhase();
    }
}
