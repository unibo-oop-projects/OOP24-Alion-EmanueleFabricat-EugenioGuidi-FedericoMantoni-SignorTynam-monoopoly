package it.unibo.monoopoly.model.state.impl;

import it.unibo.monoopoly.model.deck.api.Card;
import it.unibo.monoopoly.model.deck.api.Deck;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.state.api.ModelState;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataOutput;

/**
 * Implementations of {@link ModelState} for the card's phase:
 * the state will draw the next card,
 * return the text and depending on the type of action,
 * it changes the state.
 */
public class ModelCardState implements ModelState {
    private final MainModel turn;

    /**
     * 
     * @param turn
     */
    public ModelCardState(final MainModel turn) {
        this.turn = turn;
    }

    private Deck getDeck() {
        return this.turn.getGameBoard().getDeck(); //aspettando la implementazione nella gameboarda
    }

    private Card getCard() {
        return getDeck().getActualCard();
    }

    /**
     * {@inheritDoc}
     * In this specific case,
     * this method is useless.
     */
    @Override
    public boolean verify() {
        return true;
    }

    /**
     * {@inheritDoc}
     * In this specific case,
     * the method draw the next {@link Card}.
     */
    @Override
    public void doAction(final Optional<DataOutput> data) {
        getDeck().draw();
    }

    /**
     * {@inheritDoc}
     * In this case,
     * depending on the {@link typeOfAction} set the next state.
     */
    @Override
    public void closeState() {
        ModelState nextState = null;
        switch (getCard().getMessage().typeOfAction()) {
            case Event.FREE_CARD:
            this.turn.getGameBoard().getCurrentPlayer().addGetOutOfJailCard(); //aspettando la cell list nella gameboarda
                nextState = new ModelBankerState(turn, 0); // da cambiare
                break;
            case Event.MOVE_CARD:
                nextState = new ModelMovementState(turn, getCard().getMessage().data());
                break;
            case Event.PRISON:
                this.turn.getGameBoard().getCurrentPlayer().isPrisoned();
                nextState = new ModelMovementState(turn, getCard().getMessage().data());
                break;
            case Event.CARD_PAYMENT:
                nextState = new ModelBankerState(turn, getCard().getMessage().data().get());
                break;
            case Event.RECEIVE_CARD:
                this.turn.getGameBoard().getCurrentPlayer().receive(getCard().getMessage().data().get());
                break;
            default:
                break;
        }
        this.turn.setState(nextState);
    }

}
