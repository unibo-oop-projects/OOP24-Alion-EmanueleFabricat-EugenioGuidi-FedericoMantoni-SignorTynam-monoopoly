package it.unibo.monoopoly.model.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;

/**
 * The state of the model when a player is in jail.
 * @link ModelState
 */
public class ModelPrisonState implements ModelState {

    private final MainModel model;
    private final boolean goInJail;
    private boolean usedCard;

    /**
     * Constructs a ModelPrisonState.
     * 
     * @param model    the main game model
     * @param goInJail a boolean flag indicating whether the player must go to jail
     */
    public ModelPrisonState(MainModel model, boolean goInJail) {
        this.model = model;
        this.goInJail = goInJail;
        this.usedCard = false;
    }

    /**
     * Verifies the state.
     * 
     * @return true if the player must go to jail, false if the player can get out of jail
     */
    @Override
    public boolean verify() {
        return goInJail;
    }

    /**
     * Performs the state action.
     * <p>
     * If the player must go to jail, they are imprisoned.
     * Otherwise, if the player has at least one "Get Out of Jail Free" card,
     * the card is used and the player is released from jail.
     * If the player has no cards, they must pay €50 to exit jail.
     * </p>
     * 
     * @param data the DataOutput containing mode information (e.g., whether a card was used)
     */
    @Override
    public void doAction(DataOutput data) {
        Player currentPlayer = model.getGameBoard().getCurrentPlayer();
        if (goInJail) {
            currentPlayer.setPrisoned();
        } else if (currentPlayer.isPrisoned()) {
            if (currentPlayer.getFreeJailCards() > 0) {
                usedCard = true;
                currentPlayer.useGetOutOfJailCard();
                model.getGameBoard().getDeck().addPrisonCard();
            }
        }
    }

    /**
     * Closes the state.
     * <p>
     * If the player must go to jail, the next turn is started.
     * Otherwise, if the player used a card, the model state is set to ModelMovementState.
     * If the player did not use a card, the model state is set to ModelBankerState with a payment of €50.
     * </p>
     */
    @Override
    public void closeState() {
        if (goInJail) {
            model.nextTurn();
        } else if (this.model.getGameBoard().getCurrentPlayer().isPrisoned()) {
            this.model.getGameBoard().getCurrentPlayer().releaseFromPrison();
            if (usedCard) {
                model.setState(new ModelMovementState(model, Optional.empty()));
            } else {
                model.setState(new ModelBankerState(model, 50, true));
            }
        } else {
            model.setState(new ModelMovementState(this.model, Optional.empty()));
        }
    }
}
