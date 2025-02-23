package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;
import it.unibo.monoopoly.view.panel.api.UpdatablePanel;

/**
 * comment.
 */
public class GamePanel extends PanelAdapter implements UpdatablePanel {

    private static final long serialVersionUID = 1L;
    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private PlayerPanel playerPanel; 
    private final String firstPlayer;
    private final List<Triple<String, Integer, Color>> initializedList;
    /**
     * comment.
     * 
     * @param mainController
     * @param mainFrameHeight
     * @param mainFrameWidth
     */
    public GamePanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth,
            final String firstPlayer, final List<Triple<String, Integer, Color>> initializedList) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
        this.firstPlayer = firstPlayer;
        this.initializedList = initializedList;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        final GameBoardPanel gameBoardPanel = new GameBoardPanel(this.mainFrameHeight,
                this.initializedList);
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
        centerPanel.add(gameBoardPanel, BorderLayout.WEST);
        centerPanel.add(playerPanel, BorderLayout.CENTER);

    }

    public void setInteractivePanel(final JPanel panel) {
        this.playerPanel.setInteractivePanel(panel);
    }

    @Override
    public void update(ViewUpdateDTO updateData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }



    /*private Color getColorPlayer(String name) {
        return this.playersColors.entrySet().stream()
                .filter(e -> e.getValue().equals(name))
                .map(e -> e.getKey())
                .findFirst()
                .get();
    }*/
}
