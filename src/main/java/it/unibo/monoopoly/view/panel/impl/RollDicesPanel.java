package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class RollDicesPanel extends JPanel {

    private static final int TEXT_SIZE = 15;

    public RollDicesPanel(final ActionListener actionListener, final int mainFrameHeight) {
        final JButton rollDiceButton = new JButton("Lancia dadi");
        rollDiceButton.setFont(new Font("Arial", Font.PLAIN, mainFrameHeight/TEXT_SIZE));
        rollDiceButton.addActionListener(actionListener);
        this.setLayout(new BorderLayout());
        this.add(rollDiceButton, BorderLayout.CENTER);
    }
}
