package it.unibo.monoopoly.view.impl;

import java.awt.Dimension;

import javax.swing.JLabel;

import it.unibo.monoopoly.controller.api.MainController;

public class PlayerPanel extends PanelAdapter{

    private final MainController mainController;
    private final int mainFrameHeight;
    private final int mainFrameWidth;

    public PlayerPanel(final MainController mainController, final int mainFrameHeight, final int mainFrameWidth) {
        this.mainController = mainController;
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
    }

    @Override
    public void resizeText(Dimension screenSize) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'resizeText'");
    }

    @Override
    protected void panelInit() {
        setPreferredSize(new Dimension(this.mainFrameWidth - this.mainFrameHeight, this.mainFrameHeight));
        add(new JLabel("SPERO VADA BENE PLAYER"));
    }

}
