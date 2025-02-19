package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class VisualizePlayerPanel extends PanelAdapter{
    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private final int playersNumber;

    public VisualizePlayerPanel(int mainFrameHeight, int mainFrameWidth, Map<String, Integer> playersCredit, Map<Color, String> playersColors) {
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
        update(playersCredit, playersColors);
        this.playersNumber = playersCredit.size();
    }

    @Override
    protected void panelInit() {
        setLayout(new GridLayout(playersNumber, 1));
    }

    private void update(Map<String, Integer> playersCredit, Map<Color, String> playersColors) {
        for (var entry : playersCredit.entrySet()) {
            JTextArea l = new JTextArea("\n" + entry.getKey() + " \nPatrimonio: " + entry.getValue() + " €");
            l.setForeground(Color.BLACK);
            playersColors.entrySet().stream()
                    .filter(e -> e.getValue().equals(entry.getKey()))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .ifPresent(l::setBackground);
            l.setOpaque(true);
            l.setFont(new Font("Arial", Font.PLAIN, 50));
            l.setEnabled(false);
            add(l);
        }
    }
}
