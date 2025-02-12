package it.unibo.monoopoly.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import it.unibo.monoopoly.view.api.View;

/**
 * Abstract class that represents a {@link View} used by the application.
 */
public abstract class AbstractView implements View {

    private static final List<Color> COLORS = List.of(Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE, Color.YELLOW,
            Color.PINK);

    private final JFrame mainFrame = new JFrame("MONOOPOLY");

    /**
     * initialize the main frame of a {@link View}.
     */
    public AbstractView() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(screenSize.width / 2, screenSize.height / 2);
        mainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        mainFrame.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(final ComponentEvent e) {
                getMainPanel().resizeText(mainFrame.getSize());
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void display() {
        this.getMainFrame().add(this.getMainPanel());
        this.mainFrame.setVisible(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final JFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * 
     * @return the list of colors used in the game.
     */
    protected static List<Color> getColors() {
        return COLORS;
    }

    /**
     * 
     * @return all {@link JPanel}s contained in the main frame of the view
     */
    abstract PanelAdapter getMainPanel();


}
