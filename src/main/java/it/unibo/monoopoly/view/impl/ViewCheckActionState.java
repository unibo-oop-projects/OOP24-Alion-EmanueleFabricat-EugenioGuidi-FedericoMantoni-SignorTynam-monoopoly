package it.unibo.monoopoly.view.impl;

import org.apache.commons.lang3.tuple.Pair;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.view.api.View;
import it.unibo.monoopoly.view.api.ViewState;

public class ViewCheckActionState implements ViewState<Event, Pair<Integer, String>>{

    private final View mainView;
    private Event actualEvent;

    public ViewCheckActionState(View mainView) {
        this.mainView = mainView;
    }

    @Override
    public void setMode(Event x) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMode'");
    }

    @Override
    public void visualize(Pair<Integer, String> y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualize'");
    }

}
