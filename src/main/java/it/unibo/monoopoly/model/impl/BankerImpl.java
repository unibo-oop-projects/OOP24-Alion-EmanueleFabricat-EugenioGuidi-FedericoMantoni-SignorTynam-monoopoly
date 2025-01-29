package it.unibo.monoopoly.model.impl;

import java.util.Set;

import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.utils.Message;

public class BankerImpl implements Banker{
    
    @Override
    public Message selectOperations(Player player, int amount) {
        if (player.isPayable(amount)) {

        } else {
            if (haveHouse(player.getProperties())) {

            } else if (haveProperties(player.getProperties())) {
                
            }
        }
    }

    private boolean haveHouse(Set<Buyable> propreties) {
        return propreties.stream()
                .filter(p -> p instanceof Buildable)
                .map(p -> (Buildable)p)
                .anyMatch(p -> p.getHousesNumber() != 0);
    }

    private boolean haveProperties(Set<Buyable> propreties) {
        return !propreties.isEmpty();
    }

}
