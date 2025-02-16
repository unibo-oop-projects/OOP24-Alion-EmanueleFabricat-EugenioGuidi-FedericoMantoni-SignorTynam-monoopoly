package it.unibo.monoopoly.model.impl.card;

import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.card.Card;
import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.BuildHouseModelState;
import it.unibo.monoopoly.model.impl.gameboard.ModelMovementState;
import it.unibo.monoopoly.model.impl.player.ModelBankerState;
import it.unibo.monoopoly.utils.Message;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.impl.DataOutput;

/**
 * Implementations of {@link ModelState} for the card's phase:
 * the state will draw the next card,
 * return the text and depending on the type of action,
 * it changes the state.
 */
public class ModelCardState implements ModelState {
    private final Turn turn;

    public ModelCardState(final Turn turn) {
        this.turn = turn;
    }

    private Deck getDeck() {
        return this.turn.getDeck();
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
    public void doAction(Optional<DataOutput> data) {
        getDeck().draw();
    }
    /**
     * {@inheritDoc}
     * In this case,
     * depending on the {@link typeOfAction} set the next state.
     */
    @Override
    public void closeState() {
        ModelState nextState  = null;
        switch (getCard().getMessage().typeOfAction()) {
            case Event.FREE_CARD:
                this.turn.getActualPlayer().addGetOutOfJailCard();
                nextState = new BuildHouseModelState(turn);
                break;
            case Event.MOVE_CARD:
                nextState = new ModelMovementState(turn, getCard().getMessage().data());
                break;
            case Event.PRISON:
                this.turn.getActualPlayer().isPrisoned();
                nextState = new ModelMovementState(turn, getCard().getMessage().data());
                break;
            case Event.CARD_PAYMENT:
                nextState = new ModelBankerState(turn, getCard().getMessage().data().get());
                break;
            case Event.RECEIVE_CARD:
                this.turn.getActualPlayer().receive(getCard().getMessage().data().get());
                break;
            default:
                break;
        }
        this.turn.setState(nextState);
    }

}
