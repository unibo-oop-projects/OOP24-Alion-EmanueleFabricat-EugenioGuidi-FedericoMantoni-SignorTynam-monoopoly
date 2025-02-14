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
public class ModelMovementState implements ModelState<Optional<Integer>, Pair>{

    private static final int PASS_GO_REWARD = 200;

    private final Turn turn;
    private final Dices dices = new DicesImpl();

    /**
     * Creates a new instance of {@link ModelMovementState}.
     * This state is used to move the current {@link Player} based on the dice result.
     * @param turn used to associate the dices roll state with the specific 
     * next state to execute.
     */
    public ModelMovementState(final Turn turn) {
        this.turn = turn;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean verify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }

    @Override
    public void doAction(final Optional<Integer> cellIndex) {
        if(cellIndex.isEmpty()) {
            moveWithDices();
        } else {
            moveWithCards(cellIndex.get());
        }
    }

    private void moveWithDices() {
        this.dices.rollDices();
        if(hasPassedGo()) {
            getPlayer().receive(PASS_GO_REWARD);
            movePlayer((getPlayerPosition() + diceResult()) % numberOfCells());
        } else {
            movePlayer(getPlayerPosition() + diceResult());
        }
    }

    private void moveWithCards(int cellIndex) {
        if(cellIndex >= 0){
            if(!getPlayer().isPrisoned()) {
                if(cellIndex < getPlayer().getActualPosition()) {
                    getPlayer().receive(PASS_GO_REWARD);
                }
            }
            movePlayer(cellIndex);
        } else {
            if(getPlayerPosition() + cellIndex < 0) {
                movePlayer(getPlayerPosition() + cellIndex + numberOfCells());
            } else {
                movePlayer(getPlayerPosition() + cellIndex);
            }
        }
    }

    private int diceResult() {
        return this.dices.getResult();
    }

    private int numberOfCells() {
        return this.turn.getCellsList().size();
    }

    private int getPlayerPosition() {
        return getPlayer().getActualPosition();
    }

    private Player getPlayer() {
        return this.turn.getActualPlayer();
    }

    private void movePlayer(final int cellIndex) {
        getPlayer().changePosition(cellIndex);
    }

    private boolean hasPassedGo() {
        return getPlayerPosition() + diceResult() >= numberOfCells();
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
