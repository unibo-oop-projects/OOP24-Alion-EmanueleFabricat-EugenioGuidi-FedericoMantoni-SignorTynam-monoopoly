package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.model.player.api.Player;

/**
 * comment.
 */
public class PlayerPanel extends PanelAdapter {
    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private InteractivePanel interactivePanel;
    private VisualizePlayerPanel visualizePlayerPanel;

    /**
     * comment.
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public PlayerPanel(final int mainFrameHeight, final int mainFrameWidth, Map<String, Integer> playersCredit, Map<Color, String> playersColors) {
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
        this.interactivePanel = new InteractivePanel();
        this.visualizePlayerPanel = new VisualizePlayerPanel(this.mainFrameHeight, this.mainFrameWidth, playersCredit, playersColors);
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
        setBorder(new LineBorder(Color.BLACK));
    }
}
