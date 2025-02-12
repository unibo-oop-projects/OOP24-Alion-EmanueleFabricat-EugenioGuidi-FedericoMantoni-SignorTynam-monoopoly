package it.unibo.monoopoly.model.impl.player;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.ModelState;
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
    }

    @Override
    public void doAction(Optional<List<Integer>> propertyChosen) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doAction'");
    }

    @Override
    public Optional<List<Integer>> getData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }

    @Override
    public void closeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeState'");
    }

}
