package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.apache.commons.lang3.tuple.Triple;


public class VisualizePlayerPanel extends PanelAdapter {
    private final int playersNumber;
    private final int mainFrameHeight;
    private final String firstPlayer;
    private final List<Triple<String, Integer, Color>> initializedList;
    private final JTextArea name = new JTextArea();
    private final JTextArea amount = new JTextArea();
    private static final double PERC_RESIZE = 0.035; 


    public VisualizePlayerPanel(final int mainFrameHeight,final String firstPlayer, final List<Triple<String, Integer, Color>> initializedList) {
        super();
        this.playersNumber = initializedList.size();
        this.mainFrameHeight = mainFrameHeight;
        this.firstPlayer = firstPlayer;
        this.initializedList = initializedList;
    }

    @Override
    protected void panelInit() {
        setLayout(new GridLayout(playersNumber * 2, 1));
        this.name.setEnabled(false);
        this.amount.setEnabled(false);
        this.name.setFont(new Font("Arial", Font.PLAIN, (int) (PERC_RESIZE * this.mainFrameHeight)));
        this.amount.setFont(new Font("Arial", Font.PLAIN, (int) (PERC_RESIZE * this.mainFrameHeight)));
        for (Triple<String,Integer,Color> triple : initializedList) {
            name.setText(triple.getLeft());
            add(name);
            add(amount);
        }
    }

    /*private void update(final String actualPlayer, final Map<String, Integer> playersCredit,
            final Map<Color, String> playersColors) {
        for (final var entry : playersCredit.entrySet()) {
            final JTextArea text = new JTextArea(entry.getKey() + " \n\nPatrimonio: " + entry.getValue() + " €");
            playersColors.entrySet().stream()
                    .filter(e -> e.getValue().equals(entry.getKey()))
                    .map(Map.Entry::getKey)
                    .findFirst()
                    .ifPresent(text::setBackground);
            text.setFont(new Font("Arial", Font.PLAIN, (int) (0.035 * this.mainFrameHeight)));
            text.setEnabled(false);
            add(text);
        }*/
    }
