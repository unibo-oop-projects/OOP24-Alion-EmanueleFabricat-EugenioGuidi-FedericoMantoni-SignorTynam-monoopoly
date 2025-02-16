package it.unibo.monoopoly.view.impl;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.view.api.View;
import it.unibo.monoopoly.view.api.ViewState;

public class ViewCheckActionState implements ViewState<Event, Pair<Integer, String>>{

    private final static String[] YES_NO = {"Sì", "No"};
    private final View mainView;
    private Event actualEvent;

    public ViewCheckActionState(View mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(Event actualEvent) {
        this.actualEvent = actualEvent;
    }

    @Override
    public void visualize(Pair<Integer, String> data) {
        switch (actualEvent) {
            case BUY_PROPERTY -> {
            final int choice = JOptionPane.showOptionDialog(mainView.getMainFrame(),
            "Vuoi comprare la proprietà " + data.getRight() + "al costo di " + data.getLeft(),
            "Compra proprietà",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null,
            YES_NO, 1);
            if(choice == 0) {
                mainView.getMainController().getControllerState().continueState(true);
            } else {
                mainView.getMainController().getControllerState().continueState(false);
            }
        }
            default -> throw new IllegalArgumentException("Nothing to visualize in this state");
        }
    }

}
