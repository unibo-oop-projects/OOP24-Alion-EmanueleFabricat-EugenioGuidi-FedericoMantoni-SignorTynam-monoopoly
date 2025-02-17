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

public class GamePanel extends PanelAdapter{

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;

    public GamePanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
    }

    @Override
    protected void panelInit() {
        GameBoardPanel gameBoardPanel = new GameBoardPanel(this.mainController, this.mainFrameHeight, this.mainFrameWidth);
        PlayerPanel playerPanel = new PlayerPanel(this.mainController, this.mainFrameHeight, this.mainFrameWidth);
        JPanel eastPanel = new JPanel();
        JPanel westPanel = new JPanel();
        JPanel centerPanel = new JPanel();

        int centerHeight = this.mainFrameHeight;
        int centerWidth = centerHeight + (centerHeight / 2);
        int eastWestHeight = this.mainFrameHeight;
        int eastWestWidth = (this.mainFrameWidth - centerWidth) / 2;

        eastPanel.setPreferredSize(new Dimension(eastWestWidth, eastWestHeight));
        westPanel.setPreferredSize(new Dimension(eastWestWidth, eastWestHeight));
        centerPanel.setPreferredSize(new Dimension(centerWidth, centerHeight));

        eastPanel.setBackground(Color.GREEN);
        westPanel.setBackground(Color.GREEN);

        this.setLayout(new BorderLayout());

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(gameBoardPanel, BorderLayout.WEST);
        centerPanel.add(playerPanel, BorderLayout.CENTER);

    }

}
