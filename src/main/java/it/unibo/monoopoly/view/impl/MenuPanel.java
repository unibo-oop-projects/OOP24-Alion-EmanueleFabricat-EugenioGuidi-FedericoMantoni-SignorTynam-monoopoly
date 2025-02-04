package it.unibo.monoopoly.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;

public class MenuPanel extends PanelAdapter {

    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    public MenuPanel() {
        this.setBackground(GREEN_MONOPOLY);
        this.setLayout(new BorderLayout());
        final JButton start = new JButton("START");
        start.setPreferredSize(getPreferredSize());
        this.add(start, BorderLayout.CENTER);
        
    }

}
