package it.unibo.monoopoly.controller.impl;

import java.util.Optional;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.Functional;
import it.unibo.monoopoly.view.api.ViewState;

public class ControllerCheckActionState implements ControllerState {

    private final MainController mainController;
    private final ModelState modelState;
    private final ViewState viewState;
    private final Optional<Event> actualEvent;
    private final Cell actualCell;

    public ControllerCheckActionState (MainController mainController, Optional<Event> event, Cell actualCell) {
        this.mainController = mainController;
        this.modelState = this.mainController.getModelState();
        this.viewState = this.mainController.getViewState();
        this.actualEvent = event;
        this.actualCell = actualCell;
    }

    @Override
    public void startState() {
        if (modelState.verify()) {
            viewState.setMode(new DataBuilderInputImpl()
                .event(Event.BUY_PROPERTY)
                .valueToPay(((Buyable) actualCell).getCost())
                .nameOfProperty(actualCell.getName()).build());
        } else if (actualEvent.isPresent()) {
            modelState.doAction(Optional.empty());
            if (actualEvent.get().equals(Event.RENT_PAYMENT)) {
                viewState.setMode(new DataBuilderInputImpl().event(actualEvent.get())
                    .valueToPay(((Buyable) actualCell).getRentalValue())
                    .nameOfPlayer(((Buyable) actualCell).getOwner().get().getName()).build());
            } else if (actualEvent.get().equals(Event.TAX_PAYMENT)) {
                viewState.setMode(new DataBuilderInputImpl()
                .event(actualEvent.get())
                .valueToPay(((Functional) actualCell).getAction().get().data().get()).build());
            }
        }
        viewState.visualize();
        this.continueState(new DataBuilderOutputImpl().build());
    }

    @Override
    public void continueState(DataOutput dataOutput) {
        if(dataOutput.buyProperty().isPresent()) {
            modelState.doAction(Optional.of(dataOutput));
        }
        modelState.closeState();
    }

}
