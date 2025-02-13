package it.unibo.monoopoly.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.api.MainController;

/**
 * Represents the main view component of the application when game starts.
 */
public class MainView extends AbstractView {

    // private final PanelAdapter gamePanel;
    private final MainController controller;
    // private final ViewState<?,?> viewState;
    private final List<Color> colors;
    private final Map<Color, String> players;
    private final List<String> nameCells;

    /**
     * Initialize the {@link JFrame} and all the informations needed to show
     * correctly the state of the game to the user.
     * 
     * @param controller  the main controller of the application
     * @param namePlayers the names of the players
     */
    public MainView(final MainController controller, final List<String> namePlayers, final List<String> nameCells) {
        this.controller = controller;
        this.colors = super.getColors();
        this.players = IntStream.range(0, colors.size()).boxed()
                .collect(Collectors.toMap(colors::get, namePlayers::get));
        this.nameCells = nameCells;
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
