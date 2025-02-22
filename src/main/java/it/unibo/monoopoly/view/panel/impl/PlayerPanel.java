package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JPanel;

/**
 * comment.
 */
public class PlayerPanel extends PanelAdapter {
    private final int mainFrameHeight;
    private InteractivePanel interactivePanel;
    private VisualizePlayerPanel visualizePlayerPanel;

    /**
     * comment.
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public PlayerPanel(final int mainFrameHeight, Map<String, Integer> playersCredit, Map<Color, String> playersColors) {
        this.mainFrameHeight = mainFrameHeight;
        this.interactivePanel = new InteractivePanel();
        this.visualizePlayerPanel = new VisualizePlayerPanel(mainFrameHeight, playersCredit, playersColors);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        InteractivePanel interactivePanel = new InteractivePanel();
        setBackground(Color.BLUE);
        setLayout(new GridLayout(2,1));
        add(visualizePlayerPanel);
        add(interactivePanel);
    }

    public void setInteractivePanel(JPanel panel) {
        this.interactivePanel.setInteractivePanel(panel);
    }
}
