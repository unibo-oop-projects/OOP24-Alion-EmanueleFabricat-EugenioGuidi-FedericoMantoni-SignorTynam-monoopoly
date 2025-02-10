package it.unibo.monoopoly.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class MenuPanel extends PanelAdapter {

    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    public MenuPanel() {
        this.setBackground(GREEN_MONOPOLY);
        this.setLayout(new GridBagLayout());
        final JButton start = new JButton("START");
        final JPanel title = new JPanel(new BorderLayout());
        final JLabel monoopoly = new JLabel("MONOOPOLY");
        final SelectionPanel playerSelection = new SelectionPanel();   
        start.setFont(new Font("Arial", Font.BOLD, 20)); 
        start.setPreferredSize(start.getPreferredSize());
        title.setBackground(Color.RED);
        monoopoly.setFont(new Font("Arial", Font.BOLD, 60));
        monoopoly.setForeground(Color.WHITE);
        monoopoly.setHorizontalAlignment(SwingConstants.CENTER);
        title.add(monoopoly, BorderLayout.CENTER);
        start.addActionListener(e -> {
            start.setVisible(false);
            this.add(playerSelection, getSelectionConstraints());
            playerSelection.display();
            });
        this.add(start, getButtonCostraints());
        this.add(title, getTitleConstraints());
    }

    private GridBagConstraints getButtonCostraints() {
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy=1;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.NONE;
        gbc.weighty=1;
        gbc.ipadx=80;
        gbc.ipady=40;
        return gbc;
    }

    private GridBagConstraints getTitleConstraints() {
        final GridBagConstraints out = new GridBagConstraints();
        out.anchor=GridBagConstraints.NORTH;
        out.fill=GridBagConstraints.NONE;
        out.gridwidth = GridBagConstraints.REMAINDER;
        out.gridx=0;
        out.gridy=0;
        out.weightx=0;
        out.weighty=0;
        out.ipadx=250;
        out.ipady=50;
        out.insets= new Insets(70, 10, 10, 10);
        return out;
    }

    private GridBagConstraints getSelectionConstraints() {
        final GridBagConstraints out = new GridBagConstraints();
        out.anchor=GridBagConstraints.CENTER;
        out.fill=GridBagConstraints.NONE;
        out.gridx=0;
        out.gridy=1;
        out.weighty=1;
        out.insets= new Insets(10, 10, 10, 10);
        return out;
    }

    private Dimension divideDimension(Dimension start) {
        final int heigth = (int) start.getHeight();
        final int width = (int) start.getWidth();
        return new Dimension(width/2, heigth/2);
    }

    private Dimension duplicateDimension(Dimension start) {
        final int heigth = (int) start.getHeight();
        final int width = (int) start.getWidth();
        return new Dimension(width*2, heigth*2);
    }

}
