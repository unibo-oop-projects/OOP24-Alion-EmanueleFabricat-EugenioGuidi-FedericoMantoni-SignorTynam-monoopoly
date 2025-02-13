package it.unibo.monoopoly.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.model.api.player.Player;

public class MainView extends AbstractView {

    // private final PanelAdapter gamePanel;
    private final MainController controller;
    // private final ViewState<?,?> viewState;
    private final List<Color> colors;
    private final Map<Color, String> players;
    //private final List<String> nameCells;

    public MainView(MainController controller, List<String> namePlayers) {
        this.controller = controller;
        this.colors = super.getColors();
        this.players = IntStream.range(0, colors.size()).boxed()
                .collect(Collectors.toMap(colors::get, namePlayers::get));
        // gamePanel = new GamePanel(new MainControllerImpl());
        // this.viewState = new ViewPrisonState();
        // this.getMainFrame.getContentPane().add(gamePanel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PanelAdapter getMainPanel() {
        // TODO To complete when GamePanel will be available.
        throw new UnsupportedOperationException();
        // return (/*this.gamePanel*/);
    }

}
