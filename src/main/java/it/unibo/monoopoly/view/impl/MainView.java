package it.unibo.monoopoly.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.View;

import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.controller.impl.MainControllerImpl;
import it.unibo.monoopoly.model.impl.player.TurnImpl;
import it.unibo.monoopoly.view.api.ViewState;

/**
 * Represents the main view component of the application when game starts.
 */
public class MainView extends AbstractView {

    private final PanelAdapter gamePanel;
    private final MainController controller;
    // private final ViewState<?,?> viewState;
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
     * @param nameCells the list of names of the cells
     */
    public MainView(final MainController controller, final List<String> namePlayers, final List<String> nameCells) {
        this.controller = controller;

        Dimension screeDimension = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame().setSize(screeDimension);
        mainFrame().setResizable(false);
        mainFrame().setUndecorated(true);
        
        this.colors = super.getColors();
        this.players = IntStream.range(0, namePlayers.size()).boxed()
                .collect(Collectors.toMap(colors::get, namePlayers::get));
        this.nameCells = nameCells;
        this.gamePanel = new GamePanel(controller, mainFrame().getHeight(), mainFrame().getWidth());
        // this.viewState = new ViewPrisonState();
        mainFrame().getContentPane().add(gamePanel);

        mainFrame().setVisible(true);


        //bisogna aggiungere che premendo esc ti permette di uscire dal gioco
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
        //return this.viewState;
        return null;
    }

    @Override
    public MainController getMainController() {
        return this.controller;
    }

    @Override
    public List<String> getNameCells() {
        return this.nameCells;
    }
}
