package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Company;
import it.unibo.monoopoly.model.api.gameboard.Dices;

/**
 * Implements the {@link Company} interface.
 */
public class CompanyImpl extends AbstractBuyable implements Company {

    private final Dices dice;
    private Optional<Integer> actualRentalValue;

    /**
     * Constructor that will be replaced by CellFactory.
     * @param name the name of the cell
     * @param cost the cost of the cell
     */
    public CompanyImpl(final String name, final int cost) {
            super(name, cost);
            this.dice = new DicesImpl();
            this.actualRentalValue = Optional.empty();
        }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateRentalValue() {
        return this.actualRentalValue.orElseThrow(() ->
            new IllegalStateException("Rental value need to be first calculated for Companies"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rollAndCalculate() {
        this.dice.rollDices();
        final int multiplier = this.hasAnotherCompany() ? 10 : 4;
        this.actualRentalValue=multiplier*this.dice.getResult();
    }

    private boolean hasAnotherCompany() {
        return Math.toIntExact(
            this.getOwner().get().getProperties().stream()
            .filter(p -> p.isCompany()).count()) == 2;
    }

}
