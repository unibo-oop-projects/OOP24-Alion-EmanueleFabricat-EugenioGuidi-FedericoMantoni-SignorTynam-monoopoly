package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import it.unibo.monoopoly.view.panel.api.PositionsFactory;

/**
 * mettere commento qui, tutti i numeri molotiplicativi vengono percepiti come
 * magic number.
 */
public final class GameBoardPanel extends JPanel {

    public record CirclePosition(double x, double y, Color color) {}
    public record NumberPosition(double x, double y, String number) {}

    private final Map<Color, List<Position>> playersPositions;
    private final Map<Integer, Position> propertyPositions;
    private final Map<Integer, Position> housesPositions;
    private final Map<Color, Position> prisonPositions;
    private final int mainFrameHeight;
    private final Map<Color, String> playersColors;
    private final Image backgroundImage;
    private final PositionsFactory positionsFactory;
    private List<CirclePosition> circlesPositions;
    private List<NumberPosition> numberPositions;


    /**
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public GameBoardPanel(final int mainFrameHeight, final Map<Color, String> players, final List<Color> colors) {
        this.playersColors = players;
        this.mainFrameHeight = mainFrameHeight;
        this.positionsFactory = new PositionsFactoryImpl(mainFrameHeight, colors);
        this.playersPositions = this.positionsFactory.createPlayersPositions();
        this.propertyPositions = this.positionsFactory.createPropertyPositions();
        this.housesPositions = this.positionsFactory.createHousesPositions();
        this.prisonPositions = this.positionsFactory.createPrisonPositions();

        final URL imgURL = ClassLoader.getSystemResource("images/monoopoly_gameboard_image.jpg");
        final ImageIcon icon = new ImageIcon(imgURL);
        this.backgroundImage = icon.getImage();
        this.circlesPositions = new ArrayList<>();
        setPreferredSize(new Dimension(this.mainFrameHeight, this.mainFrameHeight));
        setLayout(new BorderLayout());
    }

    public void update(Map<String, Integer> newPlayersPositions, Map<Integer, Optional<String>> cellsOwners,
                       Map<Integer, Integer> nBuiltHouses, List<String> prisonedPlayers) {
        this.circlesPositions = initializeCirclesPositions(newPlayersPositions, cellsOwners, prisonedPlayers);
        this.numberPositions = initializeNumbersPositions(nBuiltHouses);
        this.repaint();
    }

    private List<NumberPosition> initializeNumbersPositions(Map<Integer, Integer> nBuiltHouses) {
        final List<NumberPosition> newList = new ArrayList<>();
        for(var entry : nBuiltHouses.entrySet()) {
            NumberPosition numberPosition = new NumberPosition(this.housesPositions.get(entry.getKey()).x(), 
                                                               this.housesPositions.get(entry.getKey()).y(), 
                                                               entry.getValue().toString());
            newList.add(numberPosition);
        }

        return newList;
    }

    private List<CirclePosition> initializeCirclesPositions(Map<String, Integer> newPlayersPositions, 
                                                           Map<Integer, Optional<String>> cellsOwners, 
                                                           List<String> prisonedPlayers) {
        final List<CirclePosition> newList = new ArrayList<>();
        for(var entry : this.playersColors.entrySet()) {
            if(newPlayersPositions.containsKey(entry.getValue())){
                CirclePosition circlePosition = new CirclePosition(getX(entry, newPlayersPositions), 
                                                                   getY(entry, newPlayersPositions), 
                                                                   entry.getKey());
                newList.add(circlePosition);
            }
        }
        for(var entry : cellsOwners.entrySet()) {
            if(entry.getValue().isPresent()) {
                CirclePosition circlePosition = new CirclePosition(this.propertyPositions.get(entry.getKey()).x(),
                                                                   this.propertyPositions.get(entry.getKey()).y(),
                                                                   getColorFromString(entry.getValue().get()));
                newList.add(circlePosition);
            }
        }
        for(var prisonedPlayer : prisonedPlayers) {
            Color color = getColorFromString(prisonedPlayer);
            CirclePosition circlePosition = new CirclePosition(this.prisonPositions.get(color).x(), 
                                                               this.prisonPositions.get(color).y(), 
                                                               color);
            newList.add(circlePosition);
        }
        return newList;
    }

    private Color getColorFromString(final String player) {
        return playersColors.entrySet().stream()
                                       .filter(entry -> entry.getValue().equals(player))
                                       .map(Map.Entry::getKey)
                                       .findFirst()
                                       .orElse(null);
    }

    private double getX(final Map.Entry<Color, String> entry, final Map<String, Integer> newPlayersPositions) {
        return this.playersPositions.get(entry.getKey()).get(newPlayersPositions.get(entry.getValue())).x();
    }

    private double getY(final Map.Entry<Color, String> entry, final Map<String, Integer> newPlayersPositions) {
        return this.playersPositions.get(entry.getKey()).get(newPlayersPositions.get(entry.getValue())).y();
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

        for(var circlePosition : this.circlesPositions) {
            g.setColor(circlePosition.color);
            g.fillOval((int) circlePosition.x(), (int) circlePosition.y(), circleDiameter, circleDiameter);
        }
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, numberSize));
        for(var numberPosition : this.numberPositions) {
            g.drawString(numberPosition.number, (int) numberPosition.x(), (int) numberPosition.y());
        }
    }

}
