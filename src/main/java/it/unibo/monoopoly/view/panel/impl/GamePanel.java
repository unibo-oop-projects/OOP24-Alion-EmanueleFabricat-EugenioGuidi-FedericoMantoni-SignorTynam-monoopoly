package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.main.api.MainController;

/**
 * comment.
 */
public class GamePanel extends PanelAdapter {

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
    public GamePanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
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
        final GameBoardPanel gameBoardPanel = new GameBoardPanel(this.mainController, this.mainFrameHeight,
                this.mainFrameWidth);
        final PlayerPanel playerPanel = new PlayerPanel(this.mainController, this.mainFrameHeight, this.mainFrameWidth);
        final JPanel eastPanel = new JPanel();
        final JPanel westPanel = new JPanel();
        final JPanel centerPanel = new JPanel();

        final int centerHeight = this.mainFrameHeight;
        final int centerWidth = centerHeight + (centerHeight / 2);
        final int eastWestHeight = this.mainFrameHeight;
        final int eastWestWidth = (this.mainFrameWidth - centerWidth) / 2;

        eastPanel.setPreferredSize(new Dimension(eastWestWidth, eastWestHeight));
        westPanel.setPreferredSize(new Dimension(eastWestWidth, eastWestHeight));
        centerPanel.setPreferredSize(new Dimension(centerWidth, centerHeight));

        eastPanel.setBackground(Color.BLACK);
        westPanel.setBackground(Color.BLACK);

        this.setLayout(new BorderLayout());

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(gameBoardPanel, BorderLayout.WEST);
        centerPanel.add(playerPanel, BorderLayout.CENTER);

    }

}
