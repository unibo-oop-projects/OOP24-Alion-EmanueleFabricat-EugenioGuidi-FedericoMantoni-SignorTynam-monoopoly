package it.unibo.monoopoly.model.state.impl;

import java.util.Optional;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.api.Functional;
import it.unibo.monoopoly.model.notary.api.Notary;
import it.unibo.monoopoly.model.notary.impl.NotaryImpl;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.turn.api.Turn;

/**
 * comment.
 */
public class ModelCheckActionState implements ModelState {

    private static final String BANK = "Banca";
    private final Turn mainModel;
    private final Notary notary = new NotaryImpl();
    private boolean needInput;
    private boolean isBuyableCell;
    private Optional<Event> actualEvent;

    /**
     * comment.
     * 
     * @param mainModel
     */
    public ModelCheckActionState(final Turn mainModel) {
        this.mainModel = mainModel;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean verify() {
        this.needInput = notary.isActionBuy(getActualCell(), getActualPlayer());
        this.isBuyableCell = getActualCell().isBuyable();
        if (needInput) {
            this.actualEvent = Optional.of(Event.BUY_PROPERTY);
        }
        return this.needInput;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void doAction(final Optional<DataOutput> data) {
        if (data.get().buyProperty().isEmpty()) {
            if (getActualCell().isBuyable()) {
                notary.checkBuyedProperty(getActualPlayer(), getActualCell());
            } else {
                checkFunctionalCell();
            }
        } else if (data.get().buyProperty().get()) {
            notary.buyProperty(getActualPlayer(), (Buyable) getActualCell());
        }
    }

    /*
     * TODO Da spostare su Controller
     */
    public Optional<Triple<Event, Integer, String>> getData() {
        if (actualEvent.isEmpty()) {
            return Optional.empty();
        } else if (isBuyableCell) {
            return handleBuyableData();
        } else {
            return handleFunctionalData();
        }
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void closeState() {
        if (actualEvent.equals(Optional.empty())) {
            this.mainModel.setState(new ModelBankerState(mainModel, 0));// (new BuildHouseModelState(mainModel)
        } else {
            this.mainModel.setState(
                    switch (this.actualEvent.get()) {
                        case RENT_PAYMENT ->
                            new ModelBankerState(mainModel, ((Buyable) getActualCell()).getRentalValue());
                        case TAX_PAYMENT -> new ModelBankerState(mainModel,
                                ((Functional) getActualCell()).getAction().get().data().get());
                        case BUY_PROPERTY -> new ModelBankerState(mainModel, ((Buyable) getActualCell()).getCost());
                        case DRAW -> new ModelCardState(mainModel);
                        case PRISON -> new ModelMovementState(mainModel, Optional.empty() /*
                                                                                           * TODO Call
                                                                                           * gameboard.getPrisonCell
                                                                                           */);
                        default -> throw new IllegalStateException("Card event or unsupported event was insert");
                    });
        }
    }

    /*
     * TODO Da spostare su Controller
     */
    private Optional<Triple<Event, Integer, String>> handleFunctionalData() {
        final Functional cell = (Functional) getActualCell();
        return switch (this.actualEvent.get()) {
            case TAX_PAYMENT ->
                Optional.of(Triple.of(this.actualEvent.get(), cell.getAction().get().data().get(), BANK));
            case DRAW -> Optional.empty();
            case PRISON -> Optional.empty();
            default -> throw new IllegalStateException("A Functional cell cannot trigger this type of event");
        };
    }

    /*
     * TODO Da spostare su Controller
     */
    private Optional<Triple<Event, Integer, String>> handleBuyableData() {
        final Buyable cell = (Buyable) getActualCell();
        return switch (this.actualEvent.get()) {
            case RENT_PAYMENT ->
                Optional.of(Triple.of(this.actualEvent.get(), cell.getRentalValue(), cell.getOwner().get().getName()));
            case BUY_PROPERTY -> Optional.of(Triple.of(Event.BUY_PROPERTY, cell.getCost(), cell.getName()));
            default -> throw new IllegalStateException("A Buyable cell cannot trigger this type of event");
        };
    }

    private void checkFunctionalCell() {
        final Functional functionalCell = (Functional) getActualCell();
        this.actualEvent = functionalCell.getAction().map(m -> m.typeOfAction());
        if (actualEvent.equals(Optional.of(Event.PRISON))) {
            getActualPlayer().setPrisoned();
        }
    }

    private Cell getActualCell() {
        return mainModel.getGameBoard().getCell(getActualPlayer().getActualPosition());
    }

    private Player getActualPlayer() {
        return getActualPlayer();
    }

}
