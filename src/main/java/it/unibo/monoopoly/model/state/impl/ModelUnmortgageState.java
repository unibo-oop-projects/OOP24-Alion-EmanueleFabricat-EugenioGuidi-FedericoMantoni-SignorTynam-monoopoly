package it.unibo.monoopoly.model.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;

/**
 * Implementation of {@link ModelState} for the unmortgage property,
 * used to to release a mortgage on a property of the actual {@link Player},
 * if it has any,
 * for simplicity, one can only release the mortgage if they have liquid funds.
 */
public class ModelUnmortgageState implements ModelState {
    private boolean makeState;
    private final MainModel mainModel;
    private DataOutput dataOutput;

    /**
     * Constructor of the class,
     * that takes the {@link MainModel} reference to perform all necessary state
     * operations,
     * according to the State pattern.
     * 
     * @param mainModel the reference to perform the operations.
     */
    public ModelUnmortgageState(final MainModel mainModel) {
        this.mainModel = mainModel;
    }

    /**
     * {@inheritDoc}
     * In this specific case,
     * the method verify if the {@link player} has any property to unmortgage,
     * and set the relative field.
     */
    @Override
    public boolean verify() {
        this.makeState = havePropertyToUnmortgage();
        return this.makeState;
    }

    private boolean havePropertyToUnmortgage() {
        return this.mainModel.getGameBoard().getCurrentPlayer().getProperties().stream()
                .filter(this::isPayable)
                .anyMatch(c -> c.isMortgaged());
    }

    /**
     * {@inheritDoc}
     * In this specific case,
     * the method release a mortgage to the selected property.
     */
    @Override
    public void doAction(final DataOutput data) {
        this.dataOutput = data;
        if (data.cellChoose().isPresent()) {
            buyableFromIndex(data.cellChoose()).removeMortgage();
            this.mainModel.getGameBoard().getCurrentPlayer().pay(
                    buyableFromIndex(data.cellChoose()).getMortgageValue() * 110 / 100);
        }
    }

    private Buyable buyableFromIndex(final Optional<Integer> selectedCell) {
        return (Buyable)(this.mainModel.getGameBoard().getCell(selectedCell.get()));
    }

    private boolean isPayable(final Buyable property) {
        final int toPay = property.getMortgageValue() * 110 / 100;
        return this.mainModel.getGameBoard().getCurrentPlayer().isPayable(toPay);
    }

    /**
     * {@inheritDoc}
     * In this specific case,
     * set the new {@link ModelState}:
     * {@link ModelUnmortgageState} if the actual {@link Player} have properties to
     * unmortgage,
     * or wouldn't unmortgage
     * {@link BuildHouseModelState} otherwise.
     */
    @Override
    public void closeState() {
        if (makeState && dataOutput.cellChoose().isPresent()) {
            this.mainModel.setState(new ModelUnmortgageState(mainModel));
        } else {
            this.mainModel.setState(new ModelBuildHouseState(mainModel));
        }
    }

}
