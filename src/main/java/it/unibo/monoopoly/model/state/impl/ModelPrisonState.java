package it.unibo.monoopoly.model.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;

/**
 * comment.
 */
public class ModelPrisonState implements ModelState {
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean verify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void doAction(final DataOutput data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doAction'");
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void closeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeState'");
    }
    /*
     * private final Turn mainModel;
     * private String message;
     * 
     * public ModelPrisonState(Turn mainModel, boolean goToPrison) {
     * this.mainModel = mainModel;
     * 
     * }
     * 
     * @Override
     * public boolean verify() {
     * if (player.isPrisoned()) {
     * message = "You are in prison, you can't move";
     * return true;
     * } else {
     * message = "You are not in prison, you can move";
     * return false;
     * }
     * }
     * 
     * @Override
     * public void doAction(Boolean useCard) {
     * if (!player.isPrisoned()) {
     * message = "You are not in prison, you can move";
     * return;
     * }
     * if (useCard != null && useCard) {
     * if (player.getFreeJailCards() > 0) {
     * boolean used = player.useGetOutOfJailCard();
     * if (used) {
     * message = "You used a get out of jail card";
     * } else {
     * message = "You don't have any get out of jail card";
     * }
     * } else {
     * message = "Cannot use a get out of jail card, you don't have any";
     * }
     * } else {
     * if (player.isPayable(50)) {
     * player.pay(50);
     * message = "You paid 50 and you are out of prison";
     * player.releaseFromPrison();
     * } else {
     * message = "You can't afford to pay, you risk bankruptcy.";
     * }
     * }
     * }
     * 
     * @Override
     * public String getData() {
     * return message;
     * }
     * 
     * @Override
     * public void closeState() {
     * 
     * }
     */
}
