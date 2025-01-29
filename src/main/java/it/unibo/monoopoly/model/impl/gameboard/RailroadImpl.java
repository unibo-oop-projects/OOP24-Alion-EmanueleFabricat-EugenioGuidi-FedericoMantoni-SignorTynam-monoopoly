package it.unibo.monoopoly.model.impl.gameboard;

import it.unibo.monoopoly.model.api.gameboard.Railroad;

/**
 * Implementation of {@link Railroad} interface.
 */
public class RailroadImpl extends AbstractBuyable implements Railroad {

    private static final int BASE_VALUE = 25;

    /**
     * Constructor of a railroad cell.
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
        return BASE_VALUE * (int) Math.pow(2,
            Math.toIntExact(this.getOwner().get().getProperties().stream()
            .filter(p -> p.isRailroad()).count()) - 1);
    }

}
