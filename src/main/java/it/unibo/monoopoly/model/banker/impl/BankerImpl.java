package it.unibo.monoopoly.model.banker.impl;

import java.util.Set;
import java.util.stream.Stream;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.banker.api.Banker;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.player.api.Player;
/**
 * Implementation of {@link Banker}.
 */
public class BankerImpl implements Banker {
    /**
     * {@inheritDoc}
     */
    @Override
    public Event selectOperations(final Player player) {
        if (haveHouse(player.getProperties())) {
            return Event.SELL_HOUSE;
        } else if (haveProperties(player.getProperties())) {
            return Event.MORTGAGE_PROPERTY;
        }
        player.inBankrupt(); 
        return Event.BANKRUPT;
    }

    private Stream<Buyable> unmortgagedList(final Set<Buyable> properties) {
        return properties.stream()
                .filter(p -> p instanceof Buildable)
                .filter(p -> !p.isMortgaged());
    }

    private boolean haveHouse(final Set<Buyable> properties) {
        return unmortgagedList(properties)
                .map(p -> (Buildable) p)
                .anyMatch(p -> p.getHousesNumber() != 0);
    }

    private boolean haveProperties(final Set<Buyable> properties) {
        return unmortgagedList(properties)
                .count() > 0;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void sellHouse(final Buildable property, final Player player) {
        player.receive(property.sellHouse());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void mortgageProperty(final Buyable property, final Player player) {
        player.receive(property.getMortgageValue());
        property.setMortgage();
    }
}
