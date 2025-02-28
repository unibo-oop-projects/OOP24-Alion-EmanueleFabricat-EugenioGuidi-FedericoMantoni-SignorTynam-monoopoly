package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;

/**
 * 
 */
public final class PlayerPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final InteractivePanel interactivePanel;
    private final VisualizePlayerPanel visualizePlayerPanel;

    /**
     * comment.
     * 
     * @param mainFrameHeight the height of main frame
     * @param firstPlayer the name of the player starting the game
     * @param
     */
    public PlayerPanel(final int mainFrameHeight, final String firstPlayer,
            final List<Triple<String, Integer, Color>> initializedList) {
        this.interactivePanel = new InteractivePanel(new DefaultInteractivePanel());
        this.visualizePlayerPanel = new VisualizePlayerPanel(mainFrameHeight, firstPlayer, initializedList);
        setBackground(Color.BLUE);
        setLayout(new GridLayout(2, 1));
        add(visualizePlayerPanel);
        add(interactivePanel);
    }

    /**
     * {@inheritDoc}
     */
    public void setInteractivePanel(final JPanel panel) {
        this.interactivePanel.remove(0);
        this.interactivePanel.add(panel);
    }
    
    public void updateVisualizePlayerPanel(ViewUpdateDTO updateData) {
        this.visualizePlayerPanel.updateVisualizePlayerPanel(updateData);
    }
}
