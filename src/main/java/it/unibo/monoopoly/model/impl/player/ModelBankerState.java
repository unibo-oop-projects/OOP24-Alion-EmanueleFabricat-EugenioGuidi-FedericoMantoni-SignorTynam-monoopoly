package it.unibo.monoopoly.model.impl.player;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.BankerImpl;

/**
 * Implementation of {@link ModelState} for the banker state,
 * used to pay an amount to the actual {@link Player}.
 */
public class ModelBankerState implements ModelState<Optional<List<Integer>>>{
    private final Turn turn;
    private final Banker banker = new BankerImpl();
    private boolean isIndebted = false;
    /**
     * Constructor of the class,
     * that takes the {@link Turn} reference to perform all necessary state operations,
     * according to the State pattern.
     * 
     * @param turn the reference to perform the operations.
     */
    public ModelBankerState(final Turn turn) {
        this.turn = turn;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void verify() {
        this.isIndebted = turn.getActualPlayer().getMoneyAmount() < 0; 
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void doAction(Optional<List<Integer>> propertyChosen) {
        Cell chosen = this.turn.getGameBoard().getCell(propertyChosen.get().get(0));
        if (chosen instanceof Buildable && ((Buildable)chosen).getHousesNumber() > 0) {
            this.turn.getActualPlayer().receive(((Buildable)chosen).sellHouse());
        } else {
            this.turn.getActualPlayer().receive(((Buyable)chosen).getMortgageValue());
            ((Buyable)chosen).isMortgaged();
        }
        this.verify();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<List<Integer>> getData() {
        if (isIndebted) {
            return cellToIndex(this.banker.selectOperations(this.turn.getActualPlayer()));
        } else {
            return Optional.empty();
        }
    }

    private Optional<List<Integer>> cellToIndex(Optional<List<Buyable>> propertyList) {
        return Optional.of(
                propertyList.get().stream()
                .map(this::propertyIndexOf)
                .toList());
    }

    private Integer propertyIndexOf(Buyable property) {
        return this.turn.getCellsList().stream()
                .filter(cell -> cell instanceof Buyable)
                .toList().indexOf(property);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void closeState() {
        if (isIndebted) {
            this.turn.setState(new ModelBankerState(turn));
        } else {

        }
    }

}
