package it.unibo.monoopoly.model.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;

public class ModelPrisonState implements ModelState {

    private final MainModel model;
    private final boolean goInJail;
    private boolean usedCard;

    public ModelPrisonState(MainModel model, boolean goInJail) {
        this.model = model;
        this.goInJail = goInJail;
        this.usedCard = false;
    }

    @Override
    public boolean verify() {
        return goInJail;
    }

    @Override
    public void doAction(DataOutput data) {
        Player currentPlayer = model.getGameBoard().getCurrentPlayer();
        if (goInJail) {
            currentPlayer.setPrisoned();
        } else {
            if (currentPlayer.getFreeJailCards() > 0) {
                usedCard = true;
                currentPlayer.useGetOutOfJailCard();
                model.getGameBoard().getDeck().addPrisonCard();
            }
            currentPlayer.releaseFromPrison();
        }
    }

    @Override
    public void closeState() {
        if (goInJail) {
            model.nextTurn();
        } else {
            if (usedCard) {
                model.setState(new ModelMovementState(model, Optional.empty()));
            } else {
                model.setState(new ModelBankerState(model, 50, true));
            }
        }
    }
}
