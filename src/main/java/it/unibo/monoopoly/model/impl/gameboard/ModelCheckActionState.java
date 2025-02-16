package it.unibo.monoopoly.model.impl.gameboard;

import java.util.Optional;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.Notary;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.Functional;
import it.unibo.monoopoly.model.api.player.Player;
import it.unibo.monoopoly.model.api.player.Turn;
import it.unibo.monoopoly.model.impl.BuildHouseModelState;
import it.unibo.monoopoly.model.impl.NotaryImpl;
import it.unibo.monoopoly.model.impl.card.ModelCardState;
import it.unibo.monoopoly.model.impl.player.ModelBankerState;

/**
 * State that represent the control of what action will be performed depending on the {@link Cell}.
 */
public class ModelCheckActionState implements ModelState<Optional<Boolean>, Optional<Triple<Event, Integer, String>>> {

    private static final String BANK = "Banca";
    private final Turn mainModel;
    private final Notary notary = new NotaryImpl();
    private boolean needInput;
    private boolean isBuyableCell;
    private Optional<Event> actualEvent;

    /**
     * Pass the mainModel to the state.
     * @param mainModel the main model
     */
    public ModelCheckActionState(final Turn mainModel) {
        this.mainModel = mainModel;
    }

    /**
     * {@inheritDoc}
     * 
     * Check if the action to perform is buy a property and set the state correctly to perform the action.
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
     * {@inheritDoc}
     * 
     * Perform the action or do nothing if the action it is duty of another state.
     */
    @Override
    public void doAction(final Optional<Boolean> choice) {
        if (choice.isEmpty()) {
            if (getActualCell().isBuyable()) {
                notary.checkBuyedProperty(getActualPlayer(), getActualCell());
            } else {
                checkFunctionalCell();
            }
        } else if (choice.get()) {
            notary.buyProperty(getActualPlayer(), (Buyable) getActualCell());
        }
    }

    /*
     * TODO Da spostare su Controller
     */
    @Override
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
     * {@inheritDoc}
     * 
     * The next state is set based of the action to perform or to be performed. 
     */
    @Override
    public void closeState() {
        if (actualEvent.equals(Optional.empty())) {
            this.mainModel.setState(new BuildHouseModelState(mainModel));
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

    /*
     * TODO Da spostare su Controller
     */
    private Optional<Triple<Event, Integer, String>> handleFunctionalData() {
        final Functional cell = (Functional) getActualCell();
        return switch (this.actualEvent.get()) {
            case TAX_PAYMENT -> Optional.of(Triple.of(this.actualEvent.get(),
                cell.getAction().get().data().get(), BANK));
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
                Optional.of(Triple.of(this.actualEvent.get(),
                    cell.getRentalValue(), cell.getOwner().get().getName()));
            case BUY_PROPERTY -> Optional.of(Triple.of(Event.BUY_PROPERTY, cell.getCost(), cell.getName()));
            default -> throw new IllegalStateException("A Buyable cell cannot trigger this type of event");
        };
    }

    private void checkFunctionalCell() {
        final Functional functionalCell = (Functional) getActualCell();
        this.actualEvent = functionalCell.getAction().map(m -> m.typeOfAction());
    }

    private Cell getActualCell() {
        return mainModel.getGameBoard().getCell(getActualPlayer().getActualPosition());
    }

    private Player getActualPlayer() {
        return getActualPlayer();
    }

}
