package it.unibo.monoopoly.model.state.impl;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.common.Message;
import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.api.Functional;
import it.unibo.monoopoly.model.notary.api.Notary;
import it.unibo.monoopoly.model.notary.impl.NotaryImpl;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;
import it.unibo.monoopoly.model.turn.api.MainModel;

/**
 * State that represent the control of what action will be performed depending on the {@link Cell}.
 */
public class ModelCheckActionState implements ModelState {


    private final MainModel mainModel;
    private final Notary notary = new NotaryImpl();

    private Optional<Event> actualEvent;

    /**
     * Pass the mainModel to the state.
     * @param mainModel the main model
     */
    public ModelCheckActionState(final MainModel mainModel) {
        this.mainModel = mainModel;
    }

    /**
     * {@inheritDoc}
     * 
     * Check if the action to perform is buy a property and set the state correctly to perform the action.
     */
    @Override
    public boolean verify() {
        final boolean needInput = notary.isActionBuy(getActualCell(), getActualPlayer());
        if (needInput) {
            this.actualEvent = Optional.of(Event.BUY_PROPERTY);
        }
        return needInput;
    }

    /**
     * {@inheritDoc}
     * 
     * Perform the action or do nothing if the action it is duty of another state.
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

    /**
     * {@inheritDoc}
     * 
     * The next state is set based of the action to perform or to be performed. 
     */
    @Override
    public void closeState() {
        if (actualEvent.equals(Optional.empty())) {
            this.mainModel.setState(new ModelBankerState(mainModel, 0) /* TODO new ModelBuildHouseState */);
        } else {
            this.mainModel.setState(
                switch (this.actualEvent.get()) {
                    case RENT_PAYMENT -> new ModelBankerState(mainModel,
                        ((Buyable) getActualCell()).getRentalValue());
                    case TAX_PAYMENT -> new ModelBankerState(mainModel,
                        ((Functional) getActualCell()).getAction().get().data().get());
                    case BUY_PROPERTY -> new ModelBankerState(mainModel,
                        ((Buyable) getActualCell()).getCost());
                    case DRAW -> new ModelCardState(mainModel);
                    case PRISON -> new ModelMovementState(mainModel, Optional.empty() /* TODO Call gameboard.getPrisonCell */);
                    default -> throw new IllegalStateException("Card event or unsupported event was insert");
                }
            );
        }
    }

    private void checkFunctionalCell() {
        final Functional functionalCell = (Functional) getActualCell();
        this.actualEvent = functionalCell.getAction().map(Message::typeOfAction);
    }

    private Cell getActualCell() {
        return mainModel.getGameBoard().getCell(getActualPlayer().getActualPosition());
    }

    private Player getActualPlayer() {
        return getActualPlayer();
    }

}
