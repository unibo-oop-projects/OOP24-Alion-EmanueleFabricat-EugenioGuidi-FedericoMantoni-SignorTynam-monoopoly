package it.unibo.monoopoly.model.impl.gameboard;

import it.unibo.monoopoly.model.api.gameboard.Railroad;

/**
 * Implementation of {@link Railroad} interface.
 */
public class RailroadImpl extends AbstractBuyable implements Railroad {

    private static final int BASE_VALUE = 25;

    /**
     * To replace by CellFactory.
     * @param name
     * @param cost
     */
    public RailroadImpl(final String name, final int cost) {
            super(name, cost);
        }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateRentalValue() {
        return (int) Math.pow(2,
            Math.toIntExact(this.getOwner().get().getProperties().stream()
            .filter(p -> p.isRailroad()).count())-1)*BASE_VALUE;
    }

}
