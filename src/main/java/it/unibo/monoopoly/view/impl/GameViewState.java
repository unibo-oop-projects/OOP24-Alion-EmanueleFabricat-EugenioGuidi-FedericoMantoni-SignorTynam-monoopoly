package it.unibo.monoopoly.view.impl;

import it.unibo.monoopoly.view.api.ViewState;

public class GameViewState implements ViewState<String, String> {
    private String mode;
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
}
