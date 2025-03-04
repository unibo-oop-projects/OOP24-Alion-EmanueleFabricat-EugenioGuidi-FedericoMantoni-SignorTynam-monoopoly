package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import it.unibo.monoopoly.view.panel.api.PositionAllocator;

/**
 * mettere commento qui, tutti i numeri molotiplicativi vengono percepiti come
 * magic number.
 */
public final class GameBoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final int mainFrameHeight;
    private final Image backgroundImage;
    private List<NumberAndCirclePosition> numberAndCirclePositions;
    private final PositionAllocator positionAllocator;

    /**
     * 
     * @param mainFrameHeight
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

    public void update(final Map<String, Integer> newPlayersPositions, final Map<Integer, Optional<String>> cellsOwners,
                       final Map<Integer, Integer> nBuiltHouses, final List<String> prisonedPlayers,
                       final List<Integer> mortgagedProperties) {
        this.numberAndCirclePositions = this.positionAllocator.createListCircleNumberPosition(newPlayersPositions, 
                                                                                              cellsOwners, 
                                                                                              prisonedPlayers,
                                                                                              nBuiltHouses,
                                                                                              mortgagedProperties);
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
        final int circleDiameter = (int) (this.mainFrameHeight * 0.025);
        final int numberSize = (int) (this.mainFrameHeight * 0.022);

        for (final var position : this.numberAndCirclePositions) {
            if (position.isCircle()) {
                g.setColor(position.getColor());
                g.fillOval(position.getX(), position.getY(), circleDiameter, circleDiameter);
            } else {
                g.setColor(position.getColor());
                g.setFont(new Font("Arial", Font.BOLD, numberSize));
                g.drawString(position.getNumber(), position.getX(), position.getY());
            }
        }
    }

}
