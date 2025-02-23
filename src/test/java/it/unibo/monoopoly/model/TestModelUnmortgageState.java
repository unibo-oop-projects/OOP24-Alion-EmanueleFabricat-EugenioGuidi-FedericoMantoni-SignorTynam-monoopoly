package it.unibo.monoopoly.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.model.state.impl.ModelBuildHouseState;
import it.unibo.monoopoly.model.state.impl.ModelUnmortgageState;

public class TestModelUnmortgageState {
    MainModel model;
    private final static int START_AMOUNT = 1500;

    @BeforeEach
    void init() {
        this.model = new MainModelImpl(List.of("Genoveffo"));
    }

    /* */
    @Test
    void testNothingToUnmortgage() {
        ModelUnmortgageState state = new ModelUnmortgageState(model);
        assertEquals(false, state.verify());
        state.closeState();
        assert (this.model.getState() instanceof ModelBuildHouseState);
    }

    /* */
    @Test
    void testUnmortgage() {
        Buildable property = (Buildable) (this.model.getGameBoard().getCell(39));
        ModelUnmortgageState state = new ModelUnmortgageState(model);
        this.model.getGameBoard().getCurrentPlayer().addProperty(property);
        assertEquals(false, state.verify());
        property.setMortgage();
        this.model.getGameBoard().getCurrentPlayer().pay(1500);
        assertEquals(false, state.verify());
        this.model.getGameBoard().getCurrentPlayer().receive(1500);
        assertEquals(true, state.verify());
        state.doAction(new DataBuilderOutputImpl().cellChoose(39).build());
        assertEquals(false, property.isMortgaged());
        state.closeState();
        assert (this.model.getState() instanceof ModelUnmortgageState);
        assertEquals(START_AMOUNT - property.getMortgageValue() * 110 / 100,
                this.model.getGameBoard().getCurrentPlayer().getMoneyAmount());

    }
}
