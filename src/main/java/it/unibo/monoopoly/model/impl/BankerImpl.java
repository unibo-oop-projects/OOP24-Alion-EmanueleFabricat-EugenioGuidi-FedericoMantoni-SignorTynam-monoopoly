package it.unibo.monoopoly.model.impl;

import java.util.List;

import java.util.Set;
import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.utils.Message;
import it.unibo.monoopoly.utils.Message.Actions;
/**
 * Implementation of {@link Banker}.
 */
public class BankerImpl implements Banker {
    /**
     * {@inheritDoc}
     */
    @Override
    public Message selectOperations(final Player player, final int amount) {
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

    private boolean haveHouse(final Set<Buyable> propreties) {
        return propreties.stream()
                .filter(p -> p instanceof Buildable)
                .map(p -> (Buildable) p)
                .anyMatch(p -> p.getHousesNumber() != 0);
    }

    private boolean haveProperties(final Set<Buyable> propreties) {
        return !propreties.isEmpty();
    }

    private List<Buildable> getPropretiesWithHome(final Set<Buyable> propreties) {
        return propreties.stream()
                .filter(p -> p instanceof Buildable)
                .map(p -> (Buildable) p)
                .filter(p -> p.getHousesNumber() > 0)
                .toList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void sellHouse(final Buildable proprety, final Player player) {
        player.receive(proprety.sellHouse());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void mortgageProprety(final Buyable proprety, final Player player) {
        player.receive(proprety.getMortgageValue());
        proprety.setMortgage();
    }

    
}
