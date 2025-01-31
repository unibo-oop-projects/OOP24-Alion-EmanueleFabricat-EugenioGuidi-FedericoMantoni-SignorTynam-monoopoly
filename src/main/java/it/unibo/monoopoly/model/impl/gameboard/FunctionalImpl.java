package it.unibo.monoopoly.model.impl.gameboard;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import it.unibo.monoopoly.model.api.gameboard.Functional;
import it.unibo.monoopoly.model.api.player.Player;

@JsonTypeName("Functional")
public class FunctionalImpl extends AbstractCell implements Functional {

    public FunctionalImpl(@JsonProperty("name") String name) {
            super(name);
        }
    
        @Override
    public void doAction(Player player) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doAction'");
    }

}
