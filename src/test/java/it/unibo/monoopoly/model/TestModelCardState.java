package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.banker.api.Banker;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.model.state.impl.ModelBankerState;
import it.unibo.monoopoly.model.state.impl.ModelCardState;
import it.unibo.monoopoly.model.state.impl.ModelMovementState;
import it.unibo.monoopoly.model.state.impl.ModelPrisonState;
import it.unibo.monoopoly.model.state.impl.ModelUnmortgageState;

/**
 * Tester of {@link Banker}.
 */
class TestModelCardState {
    private MainModel model;
    private static final int NUMBER_OF_CARD = 31;

    /**
     * Initialization for the test.
     */
    @BeforeEach
    void init() {
        this.model = new MainModelImpl(List.of("Genoveffo"));
    }

    /* */
    @Test
    void testSetNewState() {
        final ModelCardState state = new ModelCardState(model);
        for (int i = 0; i < NUMBER_OF_CARD; i++) {
            final int startAmount = model.getGameBoard().getCurrentPlayer().getMoneyAmount();
            state.doAction(new DataOutput(Optional.empty(), Optional.empty()));
            state.closeState();
            switch (getActualEvent(model)) {
                case Event.FREE_CARD:
                    assertTrue(1 == model.getGameBoard().getCurrentPlayer().getFreeJailCards()
                            || 2 == model.getGameBoard().getCurrentPlayer().getFreeJailCards());
                    assert (model.getState() instanceof ModelUnmortgageState);
                    break;
                case Event.MOVE_CARD:
                    assert (model.getState() instanceof ModelMovementState);
                    break;
                case Event.PRISON:
                    assert (model.getState() instanceof ModelPrisonState);
                    break;
                case Event.CARD_PAYMENT:
                    assert (model.getState() instanceof ModelBankerState);
                    break;
                case Event.RECEIVE_CARD:
                    assert (startAmount < model.getGameBoard().getCurrentPlayer().getMoneyAmount());
                    assert (model.getState() instanceof ModelUnmortgageState);
                    break;
                default:
                    throw new IllegalStateException(
                            "ModelCardState should not be in a state different from the predetermined ones.");
            }
        }
    }

    private Event getActualEvent(final MainModel model) {
        return model.getGameBoard().getDeck().getActualCard().getMessage().typeOfAction();
    }
}
