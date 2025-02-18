package it.unibo.monoopoly.model.state.impl;

import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.banker.api.Banker;
import it.unibo.monoopoly.model.banker.impl.BankerImpl;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.turn.api.MainModel;

/**
 * Implementation of {@link ModelState} for the banker state,
 * used to pay an amount to the actual {@link Player}.
 */
public class ModelBankerState implements ModelState {
    private final MainModel turn;
    private final Banker banker = new BankerImpl();
    private boolean isIndebted;
    private final int amountToPay;
    /**
     * Constructor of the class,
     * that takes the {@link MainModel} reference to perform all necessary state operations,
     * according to the State pattern.
     * 
     * @param turn the reference to perform the operations.
     * @param amountToPay
     */
    public ModelBankerState(final MainModel turn, final int amountToPay) {
        this.turn = turn;
        this.amountToPay = amountToPay;
    }

    private Player getPlayer() {
        return getPlayer();
    }
    /**
     * {@inheritDoc}
     * In this specific case,
     * the method verify if the {@link player} have enough money to pay,
     * and set the relative field.
     */
    @Override
    public boolean verify() {
        if (getPlayer().getMoneyAmount() - this.amountToPay >= 0) {
            getPlayer().pay(amountToPay);
        } else {
            this.isIndebted = true;
        }
        return this.isIndebted;
    }
    /**
     * {@inheritDoc}
     * In this specific case,
     * pay the {@link Player} depending on the property chosen by the player.
     */
    @Override
    public void doAction(final Optional<DataOutput> data) {
        final Cell chosen = this.turn.getGameBoard().getCell(data.get().cellChoose().get());
        if (chosen instanceof Buildable && ((Buildable) chosen).getHousesNumber() > 0) {
            getPlayer().receive(((Buildable) chosen).sellHouse());
        } else {
            getPlayer().receive(((Buyable) chosen).getMortgageValue());
            ((Buyable) chosen).isMortgaged();
        }
        this.verify();
    }
    /**
     * {@inheritDoc}
     * In this specific case,
     * return the {@link List} of {@link Integer} that which correspond to the index of the cell that the player must select,
     * depending on whether houses need to be sold or properties need to be mortgaged.
     */
    public Optional<List<Integer>> getData() {
        if (isIndebted) {
            return cellToIndex(this.banker.selectOperations(getPlayer()));
        } else {
            return Optional.empty();
        }
    }

    private Optional<List<Integer>> cellToIndex(final Optional<List<Buyable>> propertyList) {
        return Optional.of(
                propertyList.get().stream()
                .map(this.turn.getCellsList()::indexOf)
                .toList());
    }
    /**
     * {@inheritDoc}
     * In this specific case,
     * set the new {@link ModelState}:
     * -{@link ModelPrisonState} if the {@link Player} is bankrupt
     * -{@link ModelBankerState} if the payment isn't enough to pay the amount
     * -{@link ModelConstructionState} if the payment is enough to pay the amount
     */
    @Override
    public void closeState() {
        if (getPlayer().isBankrupt()) {
            this.turn.setState(null);
        } else if (isIndebted) {
            this.turn.setState(new ModelBankerState(turn, this.amountToPay));
        } else {
            this.turn.setState(null);
        }
    }
}
