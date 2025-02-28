package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;
import it.unibo.monoopoly.view.panel.api.UpdatablePanel;

/**
 * 
 */
public final class PlayerPanel extends JPanel implements UpdatablePanel {

    private static final long serialVersionUID = 1L;

    private final InteractivePanel interactivePanel;
    private final VisualizePlayerPanel visualizePlayerPanel;

    /**
     * comment.
     * 
     * @param mainFrameHeight the height of main frame
     * @param firstPlayer the name of the player starting the game
     * @param initializedList the starting data of the state of the game
     */
    public PlayerPanel(final int mainFrameHeight, final String firstPlayer,
            final List<Triple<String, Integer, Color>> initializedList) {
        this.interactivePanel = new InteractivePanel();
        this.visualizePlayerPanel = new VisualizePlayerPanel(mainFrameHeight, firstPlayer, initializedList);

        final InteractivePanel interactivePanel = new InteractivePanel();
        setBackground(Color.BLUE);
        setLayout(new GridLayout(2, 1));
        add(visualizePlayerPanel);
        add(interactivePanel);
    }

    /**
     * {@inheritDoc}
     */
    public void setInteractivePanel(final JPanel panel) {
        this.interactivePanel.setInteractivePanel(panel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final ViewUpdateDTO updateData) {
        this.visualizePlayerPanel.update(updateData);
    }
}
