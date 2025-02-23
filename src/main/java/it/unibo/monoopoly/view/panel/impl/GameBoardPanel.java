package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.controller.main.api.MainController;

/**
 * mettere commento qui, tutti i numeri molotiplicativi vengono percepiti come
 * magic number.
 */
public class GameBoardPanel extends PanelAdapter {

    /**
     * This record stores the x and y coordinates of a position in the gameBoardPanel.
     */
    public record Position(int x, int y) {}

    private static final List<String> FILES_NAMES = List.of("players_positions.json", 
                                                            "property_positions.json", 
                                                            "houses_positions.json");

    private final Map<Color, Map<Integer, Position>> playersPositions = new HashMap<>();
    private final Map<Integer, Position> propertyPositions = new HashMap<>();
    private final Map<Integer, Position> housesPositions = new HashMap<>();
    private final Map<String, Position> prisonPositions = new HashMap<>();
    private final int mainFrameHeight;
    private final Map<String, Color> playersColors;
    private final Image backgroundImage;

    /**
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public GameBoardPanel(final int mainFrameHeight, final List<Triple<String, Integer, Color>> initializedList) {
        this.mainFrameHeight = mainFrameHeight;
        this.playersColors = initializePlayersColoros(initializedList);

        final URL imgURL = ClassLoader.getSystemResource("images/monoopoly_gameboard_image.jpg");
        final ImageIcon icon = new ImageIcon(imgURL);
        this.backgroundImage = icon.getImage();

        initializePositionsMaps();
    }

    private Map<String, Color> initializePlayersColoros(final List<Triple<String, Integer, Color>> initializedList) {
        return initializedList.stream()
                            .collect(Collectors.toMap(Triple::getLeft, Triple::getRight));
    }

    private void initializePositionsMaps() {

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

        int circleDiameter = (int)(this.mainFrameHeight * 0.025);
        int numberSize = (int)(this.mainFrameHeight * 0.022);

        //cella 0

        int centerX = (int)(0.88 * this.mainFrameHeight);
        int centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        centerX = (int)(0.96 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.96 * this.mainFrameHeight);
        centerY = (int)(0.88 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.88 * this.mainFrameHeight);
        centerY = (int)(0.88 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 1

        centerX = (int)(0.79 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.835 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.835 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.79 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        //propietario
        centerX = (int)(0.814 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter, circleDiameter);

        //case
        centerX = (int)(0.819 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX, centerY);

        //cella 2

        centerX = (int)(0.711 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.711 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 3

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.651 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.657 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 4

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.593 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.593 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 5

        centerX = (int)(0.467 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.467 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.488 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 6

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.43 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.43 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.408 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.414 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 7

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.348 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.348 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 8

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.267 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.267 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.246 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.25 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 9

        centerX = (int)(0.142 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.186 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.186 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.142 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.165 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.17 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 10 prigione

        centerX = (int)(0.045 * this.mainFrameHeight);
        centerY = (int)(0.935 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.935 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.877 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.045 * this.mainFrameHeight);
        centerY = (int)(0.877 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 10 passaggio

        centerX = (int)(0.045 * this.mainFrameHeight);
        centerY = (int)(0.974 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.974 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.004 * this.mainFrameHeight);
        centerY = (int)(0.935 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.004 * this.mainFrameHeight);
        centerY = (int)(0.877 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 11

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.789 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.789 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.814 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.833 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 12

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.712 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.712 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.734 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 13

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.674 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.674 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.65 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.67 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 14

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.593 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.593 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.571 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.592 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 15

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.513 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.513 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.49 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 16

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.384 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.384 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.407 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.426 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 17

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.35 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.35 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.302 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.302 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 18

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.267 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.267 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.243 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.262 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 19

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.187 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.187 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.144 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.144 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.165 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.184 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 20

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.1 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.1 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.01 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.01 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 21

        centerX = (int)(0.144 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.185 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.185 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.144 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.165 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.171 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 22

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.268 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.268 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 23

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.347 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.347 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.327 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.333 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 24

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.428 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.428 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.407 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.413 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 25

        centerX = (int)(0.466 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.466 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.487 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 26

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.592 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.592 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.57 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.576 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 27

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.65 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.656 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 28

        centerX = (int)(0.71 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.71 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.732 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 29

        centerX = (int)(0.791 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.834 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.834 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.791 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.813 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.818 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 30

        centerX = (int)(0.877 * this.mainFrameHeight);
        centerY = (int)(0.101 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.101 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.877 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 31

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.185 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.185 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.143 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.143 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.163 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.184 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 32

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.268 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.268 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.245 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.266 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 33

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.348 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.348 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.305 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.305 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 34

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.387 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.387 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.406 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.424 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 35

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.51 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.51 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.49 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 36

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.592 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.592 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 37

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.673 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.673 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.651 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.672 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 38

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.711 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.711 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 39

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.792 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.792 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.813 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.834 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 2

        centerX = (int)(0.711 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.711 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 3

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.651 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.657 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 4

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.593 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.593 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 5

        centerX = (int)(0.467 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.467 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.488 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 6

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.43 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.43 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.408 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.414 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 7

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.348 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.348 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 8

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.267 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.267 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.246 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.25 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 9

        centerX = (int)(0.142 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.186 * this.mainFrameHeight);
        centerY = (int)(0.96 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.186 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.142 * this.mainFrameHeight);
        centerY = (int)(0.91 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.165 * this.mainFrameHeight);
        centerY = (int)(0.84 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.17 * this.mainFrameHeight);
        centerY = (int)(0.891 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 10 prigione

        centerX = (int)(0.045 * this.mainFrameHeight);
        centerY = (int)(0.935 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.935 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.877 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.045 * this.mainFrameHeight);
        centerY = (int)(0.877 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 10 passaggio

        centerX = (int)(0.045 * this.mainFrameHeight);
        centerY = (int)(0.974 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.974 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.004 * this.mainFrameHeight);
        centerY = (int)(0.935 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.004 * this.mainFrameHeight);
        centerY = (int)(0.877 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 11

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.789 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.789 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.814 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.833 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 12

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.712 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.712 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.734 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 13

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.674 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.674 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.65 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.67 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 14

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.593 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.593 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.571 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.592 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 15

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.513 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.513 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.49 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 16

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.384 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.384 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.407 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.426 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 17

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.35 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.35 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.302 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.302 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 18

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.267 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.267 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.243 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.262 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 19

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.187 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.187 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.068 * this.mainFrameHeight);
        centerY = (int)(0.144 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.144 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.137 * this.mainFrameHeight);
        centerY = (int)(0.165 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.114 * this.mainFrameHeight);
        centerY = (int)(0.184 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 20

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.1 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.1 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.1 * this.mainFrameHeight);
        centerY = (int)(0.01 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.014 * this.mainFrameHeight);
        centerY = (int)(0.01 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 21

        centerX = (int)(0.144 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.185 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.185 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.144 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.165 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.171 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 22

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.268 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.268 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.224 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 23

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.347 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.347 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.305 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.327 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.333 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 24

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.428 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.428 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.385 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.407 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.413 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 25

        centerX = (int)(0.466 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.51 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.466 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.487 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 26

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.592 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.592 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.547 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.57 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.576 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 27

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.673 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.628 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.65 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.656 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 28

        centerX = (int)(0.71 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.754 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.71 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.732 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 29

        centerX = (int)(0.791 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.834 * this.mainFrameHeight);
        centerY = (int)(0.076 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.834 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.791 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.813 * this.mainFrameHeight);
        centerY = (int)(0.137 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.818 * this.mainFrameHeight);
        centerY = (int)(0.13 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 30

        centerX = (int)(0.877 * this.mainFrameHeight);
        centerY = (int)(0.101 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.101 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.877 * this.mainFrameHeight);
        centerY = (int)(0.014 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 31

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.185 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.185 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.143 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.143 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.163 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.184 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 32

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.268 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.268 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.224 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.245 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.266 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 33

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.348 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.348 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.305 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.305 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 34

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.43 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.387 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.387 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.406 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.424 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 35

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.51 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.51 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.47 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.49 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 36

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.592 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.592 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.548 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 37

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.673 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.673 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.63 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.651 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.672 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

        //cella 38

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.755 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.711 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.711 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //cella 39

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.BLUE);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.836 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.965 * this.mainFrameHeight);
        centerY = (int)(0.792 * this.mainFrameHeight);
        g.setColor(Color.GREEN);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        centerX = (int)(0.905 * this.mainFrameHeight);
        centerY = (int)(0.792 * this.mainFrameHeight);
        g.setColor(Color.YELLOW);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //propietario
        centerX = (int)(0.84 * this.mainFrameHeight);
        centerY = (int)(0.813 * this.mainFrameHeight);
        g.setColor(Color.RED);
        g.fillOval(centerX, centerY, circleDiameter,circleDiameter);

        //case
        centerX = (int)(0.874 * this.mainFrameHeight);
        centerY = (int)(0.834 * this.mainFrameHeight);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        g.drawString("5", centerX , centerY);

    }

}
