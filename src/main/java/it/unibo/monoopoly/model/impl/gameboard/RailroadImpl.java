package it.unibo.monoopoly.model.impl.gameboard;

import it.unibo.monoopoly.model.api.gameboard.Railroad;

/**
 * Implementation of {@link Railroad} interface.
 */
public class RailroadImpl extends AbstractBuyable implements Railroad {

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
    public int getRentalValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getRentalValue'");
    }

}
