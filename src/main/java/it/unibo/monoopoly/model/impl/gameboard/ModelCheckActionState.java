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
import it.unibo.monoopoly.model.impl.NotaryImpl;

public class ModelCheckActionState implements ModelState<Optional<Boolean>, Triple<Event, Integer, String>> {

    private final Turn mainModel;
    private final Notary notary = new NotaryImpl();
    private boolean needInput;
    private Optional<Event> actualEvent;

    public ModelCheckActionState(Turn mainModel) {
        this.mainModel = mainModel;
    }

    @Override
    public boolean verify() {
        this.needInput = isActionBuy();
        return this.needInput;
    }

    @Override
    public void doAction(Optional<Boolean> choice) {
        final Player actualPlayer = mainModel.getActualPlayer();
        if (choice.isEmpty()) {
            if (getActualCell().isBuyable()) {
                checkBuyedProperty();
            } else {
                checkFunctionalCell();
            }
        }
    }

    
    @Override
    public Triple<Event, Integer, String> getData() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getData'");
    }
    
    @Override
    public void closeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeState'");
    }
    
    private void checkFunctionalCell() {
        final Functional functionalCell = (Functional) getActualCell();
        this.actualEvent = switch (functionalCell.getAction().typeOfAction()) {
            case PRISON -> Optional.of(Event.PRISON);
            case 

        }
    }

    private void checkBuyedProperty() {
        final Buyable buyableCell = (Buyable) getActualCell();
        if (checkRentPayment(buyableCell)) {
            this.actualEvent = Optional.of(Event.RENT_PAYMENT);
        } else {
            this.actualEvent = Optional.empty();
        }
    }

    private boolean isActionBuy() {
        if (getActualCell().isBuyable()) {
            final Buyable buyableCell = (Buyable) getActualCell();
            return buyableCell.isAvailable() && mainModel.getActualPlayer().isPayable(buyableCell.getCost());
        } else {
            return false;
        }
    }

    private Cell getActualCell() {
        return mainModel.getGameBoard().getCell(mainModel.getActualPlayer().getActualPosition());
    }

    private boolean checkRentPayment(Buyable cell) {
        return !cell.isMortgaged() && !cell.getOwner().get().equals(mainModel.getActualPlayer());
    }

}
