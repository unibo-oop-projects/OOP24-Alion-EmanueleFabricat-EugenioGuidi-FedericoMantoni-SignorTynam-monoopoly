package it.unibo.monoopoly.view.state.impl;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * comment.
 */
public class GameViewState implements ViewState {
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void setMode(Boolean setter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMode'");
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void visualize(DataInput data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualize'");
    }

    /*
     * private String mode;
     * private final MainPanel panel;
     * 
     * public GameViewState(MainPanel panel) {
     * this.panel = panel;
     * }
     * 
     * @Override
     * public void setMode(String x) {
     * this.mode = x;
     * }
     * 
     * @Override
     * public void visualize(String y) {
     * panel.appendText("===== " + mode + " =====");
     * panel.appendText(y);
     * }
     */
}
