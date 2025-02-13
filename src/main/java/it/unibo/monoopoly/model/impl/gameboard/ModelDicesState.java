package it.unibo.monoopoly.model.impl.gameboard;

import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.api.gameboard.Dices;

/**
 * Implementation of {@link ModelState} for the Dices state,
 * used to move the actual {@link Player}.
 */
public class ModelDicesState implements ModelState<Void, Integer>{

    private final Turn turn;
    private final Dices dices = new DicesImpl();

    /**
     * Creates a new instance of {@link ModelDicesState}.
     * This state is used to move the current {@link Player} based on the dice result.
     * @param turn used to associate the dices roll state with the specific 
     * next state to execute.
     */
    public ModelDicesState(final Turn turn) {
        this.turn = turn;
    }

    @Override
    public void verify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }

    @Override
    public void doAction(Void empty) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doAction'");
    }

    @Override
    public Integer getData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }

    @Override
    public void closeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeState'");
    }

}
