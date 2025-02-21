package it.unibo.monoopoly.view.main.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.View;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.view.panel.impl.GamePanel;
import it.unibo.monoopoly.view.panel.impl.PanelAdapter;
import it.unibo.monoopoly.view.panel.impl.PlayerPanel;
import it.unibo.monoopoly.view.state.api.ViewState;
import it.unibo.monoopoly.view.state.impl.ViewCheckActionState;

/**
 * Represents the main view component of the application when game starts.
 */
public class MainView extends AbstractView {

    private final PanelAdapter gamePanel;
    private final MainController controller;
    private final ViewState viewState;
    private final List<Color> colors;
    private final Map<Color, String> players;
    private final List<String> nameCells;
    // private final PanelAdapter mainPanel;

    /**
     * Initialize the {@link JFrame} and all the informations needed to show
     * correctly the state of the game to the user.
     * 
     * @param controller  the main controller of the application
     * @param namePlayers the names of the players
     * @param nameCells   the list of names of the cells
     */
    public MainView(final MainController controller, final List<String> namePlayers, final List<String> nameCells) {
        this.controller = controller;

        final Dimension screeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame().setSize(screeDimension);
        mainFrame().setResizable(false);
        mainFrame().setUndecorated(true);

        this.colors = super.getColors();
        this.players = IntStream.range(0, namePlayers.size()).boxed()
                .collect(Collectors.toMap(colors::get, namePlayers::get));
        this.nameCells = nameCells;
        this.gamePanel = new GamePanel(controller, mainFrame().getHeight(), mainFrame().getWidth(), startPlayersCredit(), this.players);
        this.viewState = new ViewCheckActionState(this); //TODO change to ViewPrisonState
    }

    private JFrame mainFrame() {
        return this.getMainFrame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PanelAdapter getMainPanel() {
        return this.gamePanel;
    }

    /**
     * Return the actual {@link ViewState}.
     * 
     * @return the actual {@link ViewState}.
     */
    public ViewState getViewState() {
        return this.viewState;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public MainController getMainController() {
        return this.controller;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public List<String> getNameCells() {
        return this.nameCells;
    }

    private Map<String, Integer> startPlayersCredit() {
        Map<String, Integer> startMap = new HashMap<>();
        this.players.entrySet().stream()
                .forEach(s -> startMap.put(s.getValue(), 1500));
        return startMap;
    }

    public void setInteractivePanel(JPanel panel) {
        ((GamePanel) this.gamePanel).setInteractivePanel(panel); //cast per non creare il metodo nella classe astratta
    }
}
