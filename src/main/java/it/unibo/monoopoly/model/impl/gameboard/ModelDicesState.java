package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Dices;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;

/**
 * Implementation of {@link ModelState} for the Dices state,
 * used to move the actual {@link Player}.
 */
public class ModelDicesState implements ModelState<Optional<Integer>, Pair>{

    private static final int PASS_GO_REWARD = 200;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void verify() {}

    @Override
    public void doAction(final Optional<Integer> cellIndex) {
        if(cellIndex.isEmpty()) {
            this.dices.rollDices();
            if(checkPassGo()) {
                this.turn.getActualPlayer().receive(PASS_GO_REWARD);
                movePlayer((getPlayerPosition() + this.dices.getResult()) % this.turn.getCellsList().size());
            } else {
                movePlayer(getPlayerPosition() + this.dices.getResult());
            }
        } else {
            if(this.turn.getActualPlayer().isPrisoned()) {
                movePlayer(cellIndex.get());
            }
        }
    }

    private int getPlayerPosition() {
        return this.turn.getActualPlayer().getActualPosition();
    }

    private void movePlayer(final int cellIndex) {
        this.turn.getActualPlayer().changePosition(cellIndex);
    }

    private boolean checkPassGo() {
        return getPlayerPosition() + this.dices.getResult() >= this.turn.getCellsList().size();
    }

    @Override
    public Pair getData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }

    @Override
    public void closeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeState'");
    }

}
