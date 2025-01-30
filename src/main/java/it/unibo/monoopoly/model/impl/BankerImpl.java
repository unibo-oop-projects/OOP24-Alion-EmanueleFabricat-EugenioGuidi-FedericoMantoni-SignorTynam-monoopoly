package it.unibo.monoopoly.model.impl;

import java.util.List;

import java.util.Set;
import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.utils.Message;
import it.unibo.monoopoly.utils.Message.Actions;

public class BankerImpl implements Banker{
    
    @Override
    public Message selectOperations(Player player, int amount) {
        if (player.isPayable(amount)) {
            return new Message(Actions.PAY, amount);
        } else {
            if (haveHouse(player.getProperties())) {
                return new Message(Actions.CHOOSE, getPropretiesWithHome(player.getProperties()));
            } else if (haveProperties(player.getProperties())) {
                return new Message(Actions.CHOOSE, player.getProperties().stream().toList());
            } else {
                return new Message(Actions.BANKRUPTCY, player);
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

    private List<Buildable> getPropretiesWithHome(Set<Buyable> propreties) {
        return propreties.stream()
                .filter(p -> p instanceof Buildable)
                .map(p -> (Buildable)p)
                .filter(p -> p.getHousesNumber() > 0)
                .toList();
    }

    @Override
    public void sellHouse(Buildable proprety, Player player) {
        player.receive(proprety.sellHouse());
    }

    @Override
    public void mortgageProprety(Buyable proprety, Player player) {
        player.receive(proprety.getMortgageValue());
        proprety.setMortgage();
    }

    
}
