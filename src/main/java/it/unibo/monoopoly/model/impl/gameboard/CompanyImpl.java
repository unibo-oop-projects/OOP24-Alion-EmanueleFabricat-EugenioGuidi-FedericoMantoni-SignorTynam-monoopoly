package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import it.unibo.monoopoly.model.api.gameboard.Company;
import it.unibo.monoopoly.model.api.gameboard.Dices;

/**
 * Implements the {@link Company} interface.
 */
public class CompanyImpl extends AbstractBuyable implements Company {

    private static final int MULTIPLIER_1 = 4;
    private static final int MULTIPLIER_2 = 10;

    private final Dices dice;
    private Optional<Integer> actualRentalValue;

    /**
     * Constructor of a company cell.
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
        if (!isAvailable()) {
            this.dice.rollDices();
            final int multiplier = this.hasAnotherCompany() ? MULTIPLIER_2 : MULTIPLIER_1;
            this.actualRentalValue = Optional.of(multiplier * this.dice.getResult());
        } else {
            throw new IllegalStateException("The property must be owned by a player");
        }

    }

    private boolean hasAnotherCompany() {
        return Math.toIntExact(
            this.getOwner().get().getProperties().stream()
            .filter(p -> p.isCompany()).count()) == 2;
    }

}
