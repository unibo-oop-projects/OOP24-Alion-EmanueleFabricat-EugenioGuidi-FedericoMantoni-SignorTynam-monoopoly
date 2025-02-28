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

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.GamePanel;
import it.unibo.monoopoly.view.panel.impl.PlayerPanel;
import it.unibo.monoopoly.view.state.api.ViewState;
import it.unibo.monoopoly.view.state.impl.ViewPrisonState;

/**
 * Represents the main view component of the application when game starts.
 */
public class MainViewImpl extends AbstractView implements MainView {

    private final GamePanel gamePanel;
    private final MainController controller;
    private ViewState viewState;
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
    public MainViewImpl(final MainController controller, final List<String> namePlayers, final List<String> nameCells) {
        super();
        this.controller = controller;

        final Dimension screeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame().setSize(screeDimension);
        mainFrame().setResizable(false);
        mainFrame().setUndecorated(true);

        this.colors = super.getColors();
        this.players = IntStream.range(0, namePlayers.size()).boxed()
                .collect(Collectors.toMap(colors::get, namePlayers::get));
        this.nameCells = nameCells;
        this.gamePanel = new GamePanel(controller, mainFrame().getHeight(), mainFrame().getWidth(), "1", initPlayerView(), this.players, this.colors);
        this.viewState = new ViewPrisonState(this);
    }

    private List<Triple<String, Integer, Color>> initPlayerView() {
        List<Triple<String, Integer, Color>> l = new LinkedList<>();
        for (var entry: this.players.entrySet()) {
            l.add(Triple.of(entry.getValue(), 0, entry.getKey()));
        }
        return l;
    }

    private JFrame mainFrame() {
        return this.getMainFrame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JPanel getMainPanel() {
        return this.gamePanel;
    }

    /**
     * Return the actual {@link ViewState}.
     * 
     * @return the actual {@link ViewState}.
     */
    @Override
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInteractivePanel(final JPanel panel) {
        ((GamePanel) this.gamePanel).setInteractivePanel(panel); // cast per non creare il metodo nella classe astratta
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setState(ViewState state) {
        this.viewState = state;
    }

    @Override
    public void update() {
        this.gamePanel.updateVisualizePlayerPanel(this.controller.getViewUpdateData());
    }
}
