package it.unibo.monoopoly.model.impl;

import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.player.Player;

public class BankerImpl implements Banker{
    
    @Override
    public int selectOperations(Player player, int amount) {
        if (player.isPayable(amount)) {
            
        } else {
            makeChoose(haveHouse(player.getProperties()) || haveProperties(player.getProperties()));
        }
    }

}
