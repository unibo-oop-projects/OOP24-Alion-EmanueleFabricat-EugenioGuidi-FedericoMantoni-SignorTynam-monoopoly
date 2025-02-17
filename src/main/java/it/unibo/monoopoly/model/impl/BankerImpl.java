package it.unibo.monoopoly.model.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import it.unibo.monoopoly.model.api.Banker;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.gameboard.Buildable;
import it.unibo.monoopoly.model.gameboard.Buyable;
/**
 * Implementation of {@link Banker}.
 */
public class BankerImpl implements Banker {
    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<List<Buyable>> selectOperations(final Player player) {
        if (haveHouse(player.getProperties())) {
            return Optional.of(getPropertiesWithHome(player));
        } else if (haveProperties(player.getProperties())) {
            return Optional.of(getPropertiesMortgageable(player));
        }
        player.inBankrupt(); 
        return Optional.empty();
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
    public List<Buyable> getPropertiesWithHome(final Player player) {
        return unmortgagedList(player.getProperties())
                .map(p -> (Buildable) p)
                .filter(p -> p.getHousesNumber() > 0)
                .map(p -> (Buyable) p)
                .toList();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Buyable> getPropertiesMortgageable(final Player player) {
        return Stream.concat(unmortgagedList(player.getProperties())
                    .filter(p -> !(p instanceof Buildable)),
                unmortgagedList(player.getProperties())
                    .filter(p -> p instanceof Buildable)
                    .map(p -> (Buildable) p)
                    .filter(p -> p.getHousesNumber() == 0)
                    .map(p -> (Buyable) p))
                .toList();
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
