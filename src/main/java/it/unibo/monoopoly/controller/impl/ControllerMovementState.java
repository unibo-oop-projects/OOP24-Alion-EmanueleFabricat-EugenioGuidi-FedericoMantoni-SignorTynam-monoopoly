package it.unibo.monoopoly.controller.impl;

import it.unibo.monoopoly.controller.api.ControllerState;
import it.unibo.monoopoly.controller.api.MainController;

public class ControllerMovementState implements ControllerState{

    private MainController mainController;

    public ControllerMovementState(final MainController mainController) {
        this.mainController = mainController;
    }

    @Override
    public void startState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'startState'");
    }

    @Override
    public void continueState(Object x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'continueState'");
    }

}
