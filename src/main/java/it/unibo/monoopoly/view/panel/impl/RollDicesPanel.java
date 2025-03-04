package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public final class RollDicesPanel extends JPanel {

    public RollDicesPanel(final ActionListener actionListener) {
        final JButton rollDiceButton = new JButton("Lancia dadi");
        rollDiceButton.addActionListener(actionListener);
        this.setLayout(new BorderLayout());
        this.add(rollDiceButton, BorderLayout.CENTER);
    }
}
