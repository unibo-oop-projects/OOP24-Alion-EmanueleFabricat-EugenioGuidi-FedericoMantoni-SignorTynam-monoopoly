package it.unibo.monoopoly.view.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.unibo.monoopoly.controller.api.MainController;

public class GameBoardPanel extends PanelAdapter{

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;

    public GameBoardPanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
    }

    @Override
    protected void panelInit() {
        setLayout(null);

        final URL imgURL = ClassLoader.getSystemResource("images/MONOOPOLY_GAMEBOARD_IMAGE.jpg");
        ImageIcon icon = new ImageIcon(imgURL);
        Image image = icon.getImage();
        Image scaledImage = image.getScaledInstance(this.mainFrameWidth, this.mainFrameWidth, image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        JLabel gameBoardLabel = new JLabel(scaledIcon);
        gameBoardLabel.setHorizontalAlignment(JLabel.CENTER);
        gameBoardLabel.setVerticalAlignment(JLabel.CENTER);
        gameBoardLabel.setBorder(null);
        gameBoardLabel.setText("");   
        gameBoardLabel.setBounds(0, 0, this.mainFrameWidth, this.mainFrameWidth);

        add(gameBoardLabel);
        setBackground(Color.RED);
        add(new JLabel("MONOPOLY"));
    }

}
