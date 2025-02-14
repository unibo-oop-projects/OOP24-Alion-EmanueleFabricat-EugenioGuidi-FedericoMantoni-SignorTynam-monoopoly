package it.unibo.monoopoly.model.impl.card;

import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.card.Card;
import it.unibo.monoopoly.model.api.card.Deck;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.BuildHouseModelState;
import it.unibo.monoopoly.model.impl.gameboard.ModelMovementState;
import it.unibo.monoopoly.model.impl.player.ModelBankerState;
import it.unibo.monoopoly.utils.Message;

public class ModelCardState implements ModelState<Void, String>{
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

    @Override
    public boolean verify() {
        return true;
    }

    @Override
    public void doAction(Void empty) {
        getDeck().draw();
    }

    @Override
    public String getData() {
        return getDeck().getActualCard().getEffectText();
    }

    @Override
    public void closeState() {
        ModelState<?, ?> nextState  = null;
        switch (getCard().getMessage().typeOfAction()) {
            case Message.Actions.FREE_CARD:
                this.turn.getActualPlayer().addGetOutOfJailCard();
                nextState = new BuildHouseModelState(this.turn.getActualPlayer());
                break;
            case Message.Actions.MOVE:
                nextState = new ModelMovementState(turn, getCard().getMessage().data());
                break;
            case Message.Actions.PRISON:
                this.turn.getActualPlayer().isPrisoned();
                nextState = new ModelMovementState(turn, getCard().getMessage().data());
                break;
            case Message.Actions.PAY:
                nextState = new ModelBankerState(turn, getCard().getMessage().data().get());
                break;
            case Message.Actions.RECEIVE:
                this.turn.getActualPlayer().receive(getCard().getMessage().data().get());
                break;
            default:
                break;
        }
        this.turn.setState(nextState);
    }

}
