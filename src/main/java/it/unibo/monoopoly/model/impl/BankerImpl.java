package it.unibo.monoopoly.model.impl;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;
/**
 * Implementation of {@link Banker}.
 */
public class BankerImpl implements Banker {
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Event> selectOperations(final Player player, final int amount) {
        if (player.isPayable(amount)) {
            player.pay(amount);
            return Optional.empty();
        } else {
            if (haveHouse(player.getProperties())) {
                return Event.SELL_HOUSE;
            } else if (haveProperties(player.getProperties())) {
                return Event.MORTGAGE_PROPERTY;
            }
        }
        player.inBankrupt(); 
        return Optional.empty();
    }

    private Stream<Buildable> buildableList(final Set<Buyable> properties) {
        return properties.stream()
                .filter(p -> p instanceof Buildable)
                .filter(p -> !p.isMortgaged())
                .map(p -> (Buildable) p);
    }

    private boolean haveHouse(final Set<Buyable> properties) {
        return buildableList(properties)
                .anyMatch(p -> p.getHousesNumber() != 0);
    }

    private boolean haveProperties(final Set<Buyable> properties) {
        return buildableList(properties)
                .count() > 0;
    }
    /**
     * {@inheritDoc}
     */
    public List<Buildable> getPropertiesWithHome(Player player) {
        return buildableList(player.getProperties())
                .filter(p -> p.getHousesNumber() > 0)
                .toList();
    }
    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public List<Buildable> getPropertiesMortgageable(Player player) {
        return buildableList(player.getProperties()).toList();
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
