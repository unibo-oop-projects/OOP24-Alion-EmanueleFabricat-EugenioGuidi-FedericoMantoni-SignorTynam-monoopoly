package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import org.apache.commons.lang3.tuple.Triple;

/**
 * comment.
 */
public class PlayerPanel extends PanelAdapter {

    private static final long serialVersionUID = 1L;

    private final InteractivePanel interactivePanel;
    private final VisualizePlayerPanel visualizePlayerPanel;

    /**
     * comment.
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public PlayerPanel(final int mainFrameHeight, final String firstPlayer,
            final List<Triple<String, Integer, Color>> initializedList) {
        this.interactivePanel = new InteractivePanel();
        this.visualizePlayerPanel = new VisualizePlayerPanel(mainFrameHeight, firstPlayer, initializedList);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        final InteractivePanel interactivePanel = new InteractivePanel();
        setBackground(Color.BLUE);
        setLayout(new GridLayout(2, 1));
        add(visualizePlayerPanel);
        add(interactivePanel);
    }

    public void setInteractivePanel(final JPanel panel) {
        this.interactivePanel.setInteractivePanel(panel);
    }
}
