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

import it.unibo.monoopoly.utils.api.PositionsFactory;
import it.unibo.monoopoly.utils.impl.Position;
import it.unibo.monoopoly.utils.impl.PositionsFactoryImpl;
import it.unibo.monoopoly.view.panel.api.PositionAllocator;

/**
 * mettere commento qui, tutti i numeri molotiplicativi vengono percepiti come
 * magic number.
 */
public final class GameBoardPanel extends JPanel {
    
    private final int mainFrameHeight;
    private final Image backgroundImage;
    private List<NumberAndCirclePosition> numberAndCirclePositions;
    private final PositionAllocator positionAllocator;

    /**
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public GameBoardPanel(final int mainFrameHeight, final Map<Color, String> players, final List<Color> colors) {
        this.mainFrameHeight = mainFrameHeight;
        this.positionAllocator = new PositionAllocatorImpl(mainFrameHeight, players, colors);

        final URL imgURL = ClassLoader.getSystemResource("images/monoopoly_gameboard_image.jpg");
        final ImageIcon icon = new ImageIcon(imgURL);
        this.backgroundImage = icon.getImage();
        setPreferredSize(new Dimension(this.mainFrameHeight, this.mainFrameHeight));
        setLayout(new BorderLayout());
    }

    public void update(Map<String, Integer> newPlayersPositions, Map<Integer, Optional<String>> cellsOwners,
                       Map<Integer, Integer> nBuiltHouses, List<String> prisonedPlayers) {
        this.numberAndCirclePositions = this.positionAllocator.createListCircleNumberPosition(newPlayersPositions, 
                                                                                              cellsOwners, 
                                                                                              prisonedPlayers,
                                                                                              nBuiltHouses);
        this.repaint();
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

        for(var position : this.numberAndCirclePositions) {
            if(position.isCircle()) {
                g.setColor(position.getColor());
                g.fillOval(position.getX(), position.getY(), circleDiameter, circleDiameter
                );
            }else {
                g.setColor(position.getColor());
                g.setFont(new Font("Arial", Font.BOLD, numberSize));
                g.drawString(position.getNumber(), position.getX(), position.getY());
            }
        }
    }

}
