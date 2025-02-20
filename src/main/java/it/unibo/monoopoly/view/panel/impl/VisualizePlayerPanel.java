package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JTextArea;

import it.unibo.monoopoly.controller.main.api.MainController;

public class VisualizePlayerPanel extends PanelAdapter{
    private final int playersNumber;
    private final int mainFrameHeight;
    private final int mainFrameWidth;
    private Map<String, Integer> playersCredit;
    private Map<Color, String> playersColors;


    public VisualizePlayerPanel(final int mainFrameHeight, final int mainFrameWidth, Map<String, Integer> playersCredit, Map<Color, String> playersColors) {
        this.playersNumber = playersCredit.size();
        this.mainFrameHeight = mainFrameHeight;
        this.mainFrameWidth = mainFrameWidth;
        this.playersCredit = playersCredit;
        this.playersColors = playersColors;
        update(playersCredit, playersColors);
    }

    @Override
    protected void panelInit() {
        setLayout(new GridLayout(playersNumber, 1));
        System.out.println(this.mainFrameHeight);
    }

    private void update(Map<String, Integer> playersCredit, Map<Color, String> playersColors) {
        for (var entry : playersCredit.entrySet()) {
            JTextArea l = new JTextArea(entry.getKey() + " \n\nPatrimonio: " + entry.getValue() + " €" + mainFrameHeight);
            l.setForeground(Color.BLACK);
            playersColors.entrySet().stream()
                    .filter(e -> e.getValue().equals(entry.getKey()))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .ifPresent(l::setBackground);
            l.setOpaque(true);
            l.setFont(new Font("Arial", Font.PLAIN, (int)(0.035*this.mainFrameHeight)));
            l.setEnabled(false);
            add(l);
        }
    }
}
