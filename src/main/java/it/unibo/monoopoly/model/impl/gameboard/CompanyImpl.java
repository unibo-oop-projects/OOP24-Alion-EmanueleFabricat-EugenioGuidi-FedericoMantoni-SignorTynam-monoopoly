package it.unibo.monoopoly.model.impl.gameboard;

import it.unibo.monoopoly.model.api.card.Dice;
import it.unibo.monoopoly.model.api.gameboard.Company;

/**
 * Implements the {@link Company} interface.
 */
public class CompanyImpl extends AbstractBuyable implements Company {

    private Dice dice;

    /**
     * Constructor that will be replaced by CellFactory.
     * @param name the name of the cell
     * @param cost the cost of the cell
     */
    public CompanyImpl(final String name, final int cost) {
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void rollAndCalculate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateRent'");
    }

}
