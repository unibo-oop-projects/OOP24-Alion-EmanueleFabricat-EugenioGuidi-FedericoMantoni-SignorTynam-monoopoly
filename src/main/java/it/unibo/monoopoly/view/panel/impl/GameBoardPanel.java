package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import it.unibo.monoopoly.controller.main.api.MainController;

public class GameBoardPanel extends PanelAdapter{

    //List<Point> listaPunti = new ArrayList<>();

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private final Image backgroundImage;

    public GameBoardPanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;

        final URL imgURL = ClassLoader.getSystemResource("images/MONOOPOLY_GAMEBOARD_IMAGE.jpg");
        ImageIcon icon = new ImageIcon(imgURL);
        this.backgroundImage = icon.getImage();
    }

    @Override
    protected void panelInit() {
        setPreferredSize(new Dimension(this.mainFrameHeight, this.mainFrameHeight));
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, this.mainFrameHeight, this.mainFrameHeight, this);

        int circleDiameter = (int)((this.mainFrameHeight * 1.6) / 100);

        int centerX = 22;
        int centerY = 22;
        g.setColor(Color.GREEN);

        g.setFont(new Font("Arial", Font.BOLD, 22));

        g.drawString("3", centerX , centerY);

    }

}
