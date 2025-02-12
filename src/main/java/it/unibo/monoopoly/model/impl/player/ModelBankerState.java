package it.unibo.monoopoly.model.impl.player;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.BankerImpl;

public class ModelBankerState implements ModelState<Optional<List<Integer>>>{
    private final Turn turn;
    private final Banker banker = new BankerImpl();
    private boolean isIndebted = false;

    public ModelBankerState(final Turn turn) {
        this.turn = turn;
    }

    @Override
    public void verify() {
        this.isIndebted = turn.getActualPlayer().getMoneyAmount() < 0; 
    }

    @Override
    public void doAction(Optional<List<Integer>> propertyChosen) {
        this.isIndebted = turn.getActualPlayer().getMoneyAmount() < 0;
    }

    @Override
    public Optional<List<Integer>> getData() {
        if (isIndebted) {
            return cellToIndex(this.banker.selectOperations(this.turn.getActualPlayer()));
        }
    }

    private Optional<List<Integer>> cellToIndex(Optional<List<Buyable>> propertyList) {
        return Optional.of(
                propertyList.stream()
                .map()
                .toList());
    }

    private Integer propertyIndexOf(Buyable property) {
        return 
    }

    @Override
    public void closeState() {
        if (isIndebted) {
            this.turn.
        }
    }

}
