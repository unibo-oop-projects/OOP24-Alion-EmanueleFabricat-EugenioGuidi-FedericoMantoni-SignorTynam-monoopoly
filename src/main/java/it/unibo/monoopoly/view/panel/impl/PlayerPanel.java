package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

import it.unibo.monoopoly.controller.main.api.MainController;

/**
 * comment.
 */
public class PlayerPanel extends PanelAdapter {

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;

    /**
     * comment.
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public PlayerPanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        setBackground(Color.BLUE);
        add(new JLabel("PLAYER"));
    }

}
