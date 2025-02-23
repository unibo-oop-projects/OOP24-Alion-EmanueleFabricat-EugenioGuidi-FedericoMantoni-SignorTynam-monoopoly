package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.model.banker.api.Banker;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.model.state.impl.ModelBankerState;
import it.unibo.monoopoly.model.state.impl.ModelMovementState;
import it.unibo.monoopoly.model.state.impl.ModelUnmortgageState;

/**
 * Tester of {@link Banker}.
 */
public class TestModelBankerState {
    private static final int BUILDABLE_CELL1 = 39;
    private static final int BUILDABLE_CELL2 = 37;
    private static final int START_AMOUNT = 1500;
    private MainModel model;
    private ModelBankerState state;

    /**
     * Initialization for the test.
     */
    @BeforeEach
    void init() {
        this.model = new MainModelImpl(List.of("Genoveffo"));
    }

    /**
     * 
     */
    @Test
    void testOperationSuccess() {
        ModelBankerState state = new ModelBankerState(this.model, START_AMOUNT, false);
        assertEquals(false, state.verify());
        state.doAction(new DataBuilderOutputImpl().build());
        assertEquals(0, this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());
        state.closeState();
        assertInstanceOf(ModelUnmortgageState.class, this.model.getState());
    }

    /* */
    @Test
    void testOperationSellHouse() {
        Buildable property = (Buildable) (this.model.getGameBoard().getCell(BUILDABLE_CELL1));
        property.buildHouse();
        final int sellHouseAmount = property.sellHouse();
        this.model.getGameBoard().getCurrentPlayer().addProperty(property);
        property.buildHouse();
        ModelBankerState state = new ModelBankerState(this.model, START_AMOUNT + 200, false);
        assertEquals(true, state.verify());
        assertEquals(Optional.of(Event.SELL_HOUSE), this.model.getEvent());
        state.doAction(new DataBuilderOutputImpl().cellChoose(BUILDABLE_CELL1).build());
        assertEquals(sellHouseAmount + START_AMOUNT, this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());
        state.closeState();
        assert (this.model.getState() instanceof ModelBankerState);
        property.buildHouse();
        assertEquals(true, this.model.getState().verify());
        assertEquals(Optional.of(Event.SELL_HOUSE), this.model.getEvent());
        state.doAction(new DataBuilderOutputImpl().cellChoose(BUILDABLE_CELL1).build());
        assertEquals(0, this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());
    }

    /* */
    @Test
    void testOperationMortgage() {
        Buildable property = (Buildable) (this.model.getGameBoard().getCell(BUILDABLE_CELL1));
        Buildable property2 = (Buildable) (this.model.getGameBoard().getCell(BUILDABLE_CELL2));
        final int mortgageAmount1 = property.getMortgageValue();
        this.model.getGameBoard().getCurrentPlayer().addProperty(property);
        this.model.getGameBoard().getCurrentPlayer().addProperty(property2);
        ModelBankerState state = new ModelBankerState(this.model, START_AMOUNT + 200, false);
        assertEquals(true, state.verify());
        assertEquals(Optional.of(Event.MORTGAGE_PROPERTY), this.model.getEvent());
        state.doAction(new DataBuilderOutputImpl().cellChoose(BUILDABLE_CELL1).build());
        assertEquals(true, property.isMortgaged());
        assertEquals(mortgageAmount1 + START_AMOUNT, this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());
        property.removeMortgage();
        state.closeState();
        assertInstanceOf(ModelBankerState.class, this.model.getState());
        assertEquals(true, this.model.getState().verify());
        assertEquals(Optional.of(Event.MORTGAGE_PROPERTY), this.model.getEvent());
        state.doAction(new DataBuilderOutputImpl().cellChoose(BUILDABLE_CELL1).build());
        assertEquals(START_AMOUNT - 1700 + mortgageAmount1 + mortgageAmount1,
                this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());
    }

    /* */
    @Test
    void testOperationBankrupt() {
        ModelBankerState state = new ModelBankerState(this.model, START_AMOUNT + 100, false);
        assertEquals(true, state.verify());
        state.doAction(new DataBuilderOutputImpl().build());
        assertEquals(START_AMOUNT, this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());
        assertEquals(Optional.of(Event.BANKRUPT), this.model.getEvent());
    }

    /* */
    @Test
    void testOperationInPrison() {
        ModelBankerState state = new ModelBankerState(this.model, START_AMOUNT, true);
        assertEquals(false, state.verify());
        state.doAction(new DataBuilderOutputImpl().build());
        assertEquals(0, this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());
        state.closeState();
        assertInstanceOf(ModelMovementState.class, this.model.getState());
    }
}
