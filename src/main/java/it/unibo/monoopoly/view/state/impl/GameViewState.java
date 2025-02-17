package it.unibo.monoopoly.view.state.impl;

import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.state.api.ViewState;

public class GameViewState implements ViewState {

    @Override
    public void setMode(DataInput dataInput) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMode'");
    }

    @Override
    public void visualize() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visualize'");
    }
/*      private String mode;
    private final MainPanel panel;

    public GameViewState(MainPanel panel) {
        this.panel = panel;
    }

    @Override
    public void setMode(String x) {
        this.mode = x;
    }

    @Override
    public void visualize(String y) {
        panel.appendText("===== " + mode + " =====");
        panel.appendText(y);
    }
*/
}
