package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;
import it.unibo.monoopoly.view.panel.api.UpdatablePanel;

/**
 * The class implements the principal panel {@link UpdateblePanel} that contain
 * the
 * game board panel and player panel.
 */
public final class GamePanel extends JPanel implements UpdatablePanel {

    private static final long serialVersionUID = 1L;
    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private final PlayerPanel playerPanel;
    private final GameBoardPanel gameBoardPanel;
    private final String firstPlayer;
    private final List<Triple<String, Integer, Color>> initializedList;

    /**
     * initialize all the fields needed and set the preferred size based on
     * dimension of frame.
     * 
     * @param mainFrameHeight
     * @param mainFrameWidth
     * @param firstPlayer
     * @param initializedList
     * @param players
     * @param colors
     */
    public GamePanel(final int mainFrameHeight,
            final int mainFrameWidth, final String firstPlayer,
            final List<Triple<String, Integer, Color>> initializedList,
            final Map<String, Color> players, final List<Color> colors) {
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
        this.firstPlayer = firstPlayer;
        this.initializedList = List.copyOf(initializedList);
        this.gameBoardPanel = new GameBoardPanel(mainFrameHeight, players, colors);
        this.playerPanel = new PlayerPanel(this.mainFrameHeight, this.firstPlayer, this.initializedList);

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

        eastPanel.setBackground(GREEN_MONOPOLY);
        westPanel.setBackground(GREEN_MONOPOLY);

        this.setLayout(new BorderLayout());

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(westPanel, BorderLayout.WEST);

        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(this.gameBoardPanel, BorderLayout.WEST);
        centerPanel.add(playerPanel, BorderLayout.CENTER);
    }

    /**
     * @param panel
     */
    public void setInteractivePanel(final JPanel panel) {
        this.playerPanel.setInteractivePanel(panel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final ViewUpdateDTO updateData) {
        this.gameBoardPanel.update(updateData.playerPositions(),
                updateData.cellsOwners(),
                updateData.nBuiltHouses(),
                updateData.prisonedPlayers(),
                updateData.mortgagedProperties());
        this.playerPanel.update(updateData);
    }

}
