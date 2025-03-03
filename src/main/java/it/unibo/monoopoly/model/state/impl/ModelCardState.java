package it.unibo.monoopoly.model.state.impl;

import it.unibo.monoopoly.model.deck.api.Card;
import it.unibo.monoopoly.model.deck.api.Deck;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.state.api.ModelState;

import java.util.Optional;
import java.util.stream.Stream;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataOutput;

/**
 * Implementations of {@link ModelState} for the card's phase:
 * the state will draw the next card,
 * return the text and depending on the type of action,
 * it changes the state.
 */
public class ModelCardState implements ModelState {
    private static final int N_CELLS = 40;
    private final MainModel mainModel;

    /**
     * Constructor of the class that sets the mainModel field.
     * 
     * @param mainModel to set.
     */
    public ModelCardState(final MainModel mainModel) {
        this.mainModel = mainModel;
    }

    private Deck getDeck() {
        return this.mainModel.getGameBoard().getDeck();
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
    public void doAction(final DataOutput data) {
        getDeck().draw();
    }

    /**
     * {@inheritDoc}
     * In this case,
     * depending on the {@link typeOfAction} set the next state.
     */
    @Override
    public void closeState() {
        ModelState nextState = new ModelUnmortgageState(mainModel);
        switch (getCard().getMessage().typeOfAction()) {
            case Event.FREE_CARD:
                this.mainModel.getGameBoard().getCurrentPlayer().addGetOutOfJailCard();
                nextState = new ModelUnmortgageState(mainModel);
                break;
            case Event.MOVE_CARD:
                nextState = new ModelMovementState(mainModel, getCard().getMessage().data());
                break;
            case Event.PRISON:
                nextState = new ModelPrisonState(this.mainModel, true);
                break;
            case Event.CARD_PAYMENT:
                if (getCard().getMessage().data().isPresent()) {
                    nextState = new ModelBankerState(mainModel, getCard().getMessage().data().get(), false);
                    break;
                } else {
                    nextState = new ModelBankerState(mainModel, payForHouse(), false);
                    break;
                }
            case Event.RECEIVE_CARD:
                this.mainModel.getGameBoard().getCurrentPlayer().receive(getCard().getMessage().data().get());
                nextState = new ModelUnmortgageState(mainModel);
                break;
            default:
                throw new IllegalStateException("la carta non dovrebbe non far niente");
        }
        this.mainModel.setState(nextState);
    }

    private int payForHouse() {
        final Integer amount = numberOfHouses() * N_CELLS;
        return amount;
    }

    private int numberOfHouses() {
        return this.mainModel.getGameBoard().getCurrentPlayer().getProperties().stream()
                .filter(c -> c instanceof Buildable)
                .map(c -> (Buildable) c)
                .mapToInt(Buildable::getHousesNumber)
                .sum();
    }
}
