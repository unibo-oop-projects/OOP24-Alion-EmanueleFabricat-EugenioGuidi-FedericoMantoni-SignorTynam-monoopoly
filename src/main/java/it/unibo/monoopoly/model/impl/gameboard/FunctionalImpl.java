package it.unibo.monoopoly.model.impl.gameboard;

import it.unibo.monoopoly.model.api.gameboard.Functional;
import it.unibo.monoopoly.model.api.player.Player;

public class FunctionalImpl extends AbstractCell implements Functional {

    public FunctionalImpl(String name) {
            super(name);
        }
    
        @Override
    public void doAction(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doAction'");
    }

}
