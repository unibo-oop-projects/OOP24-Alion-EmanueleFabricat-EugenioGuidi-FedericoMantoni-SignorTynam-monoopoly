package it.unibo.monoopoly.view.main.impl;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.monoopoly.view.main.api.View;
import it.unibo.monoopoly.view.panel.impl.PanelAdapter;

/**
 * Abstract class that represents a {@link View} used by the application.
 */
public abstract class AbstractView implements View {

    private static final List<Color> COLORS = List.of(Color.BLUE, Color.GREEN, Color.RED, Color.ORANGE);

    private final JFrame mainFrame = new JFrame("MONOOPOLY");

    /**
     * initialize the main frame of a {@link View}.
     */
    public AbstractView() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent k) {
                if (k.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    showConfirmToExit();
                }
            }
        });
    }

    private void showConfirmToExit() {
        if (JOptionPane.showConfirmDialog(this.mainFrame, "Siete sicuri di voler chiudere l'applicazione?",
                "Chiudere applicazione", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
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
