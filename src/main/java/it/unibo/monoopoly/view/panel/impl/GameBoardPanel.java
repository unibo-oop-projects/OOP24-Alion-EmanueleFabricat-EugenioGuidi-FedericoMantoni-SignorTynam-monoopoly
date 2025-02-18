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

/**
 * mettere commento qui, tutti i numeri molotiplicativi vengono percepiti come
 * magic number.
 */
public class GameBoardPanel extends PanelAdapter {

    // List<Point> listaPunti = new ArrayList<>();

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private final Image backgroundImage;

    /**
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public GameBoardPanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;

        final URL imgURL = ClassLoader.getSystemResource("images/MONOOPOLY_GAMEBOARD_IMAGE.jpg");
        final ImageIcon icon = new ImageIcon(imgURL);
        this.backgroundImage = icon.getImage();
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        setPreferredSize(new Dimension(this.mainFrameHeight, this.mainFrameHeight));
        setLayout(new BorderLayout());
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundImage, 0, 0, this.mainFrameHeight, this.mainFrameHeight, this);

        final int circleDiameter = (int) ((this.mainFrameHeight * 2.5) / 100);

        int centerX = (int) (0.96 * this.mainFrameHeight);
        int centerY = (int) (0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        centerX = (int) (0.88 * this.mainFrameHeight);
        centerY = (int) (0.96 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        centerX = (int) (0.96 * this.mainFrameHeight);
        centerY = (int) (0.91 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        centerX = (int) (0.88 * this.mainFrameHeight);
        centerY = (int) (0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        centerX = (int) (0.814 * this.mainFrameHeight);
        centerY = (int) (0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        final int numberSize = (int) (this.mainFrameHeight * 0.022);

        centerX = (int) (0.819 * this.mainFrameHeight);
        centerY = (int) (0.891 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX, centerY);

    }

}
