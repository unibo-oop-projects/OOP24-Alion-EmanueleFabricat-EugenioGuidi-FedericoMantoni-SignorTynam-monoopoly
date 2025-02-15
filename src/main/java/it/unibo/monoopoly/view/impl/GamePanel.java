package it.unibo.monoopoly.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import it.unibo.monoopoly.controller.api.MainController;

public class GamePanel extends PanelAdapter{

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private PanelAdapter gameBoardPanel;
    private PanelAdapter playerPanel;
    JPanel mainCenterPanel = new JPanel();
    JPanel mainEastPanel = new JPanel();
    JPanel mainWestPanel = new JPanel();

    public GamePanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
    }

    @Override
    protected void panelInit() {
        setLayout(new BorderLayout());

        this.gameBoardPanel = new GameBoardPanel(this.mainController, this.mainFrameWidth, this.mainFrameHeight);
        this.playerPanel = new PlayerPanel(this.mainController, this.mainFrameWidth, this.mainFrameHeight);
        this.mainEastPanel.setBackground(Color.GREEN);//devo settare il colore giusto
        this.mainWestPanel.setBackground(Color.GREEN);//devo settare il colore giusto

        add(this.mainCenterPanel, BorderLayout.CENTER);
        add(this.mainEastPanel, BorderLayout.EAST);
        add(this.mainWestPanel, BorderLayout.WEST);

        this.mainCenterPanel.setLayout(new BorderLayout());
        this.mainCenterPanel.add(this.gameBoardPanel, BorderLayout.WEST);
        this.mainCenterPanel.add(this.playerPanel, BorderLayout.EAST);

        Dimension eastWeastDimension = new Dimension(((getWidth() - ((getHeight() * 3) / 2))) / 2 , getHeight());

        this.mainEastPanel.setPreferredSize(eastWeastDimension);
        this.mainWestPanel.setPreferredSize(eastWeastDimension);
        this.gameBoardPanel.setPreferredSize(new Dimension(getHeight(), getHeight()));
        this.playerPanel.setPreferredSize(new Dimension(getHeight() / 2, getHeight()));
        this.mainCenterPanel.setPreferredSize(new Dimension((getHeight() / 2) + getHeight(), getHeight()));

    }

}
