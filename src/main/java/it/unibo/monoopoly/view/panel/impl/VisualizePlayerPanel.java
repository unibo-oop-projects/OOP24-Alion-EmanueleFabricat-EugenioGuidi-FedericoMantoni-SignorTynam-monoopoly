package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import org.apache.commons.lang3.tuple.Triple;


public class VisualizePlayerPanel extends PanelAdapter {
    private final int playersNumber;
    private final int mainFrameHeight;
    private final String firstPlayer;
    private final List<Triple<String, Integer, Color>> initializedList;
    private final List<JTextArea> textList = new LinkedList<>();
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
        setLayout(new GridLayout(playersNumber * 2 + 1, 1));
        this.textList.add(new JTextArea("E' il turno di " + this.firstPlayer));
        for (Triple<String,Integer,Color> triple : initializedList) {
            this.textList.add(new JTextArea(triple.getLeft()));
            this.textList.getLast().setBackground(triple.getRight());
            this.textList.add(new JTextArea(String.valueOf(triple.getMiddle()) + " €"));
            this.textList.getLast().setBackground(triple.getRight());            
        }
        for (var text : this.textList) {
            text.setEnabled(false);
            text.setFont(new Font("Arial", Font.PLAIN, (int) (0.035 * this.mainFrameHeight)));
            add(text);
        }
    }

    public void update(final String actualPlayer, final List<Integer> amounts) {
        this.textList.get(0).setText("E' il turno di " + actualPlayer);
        int i = 1;
        for (; i < amounts.size(); i++) {
            this.textList.get(i + 1).setText(String.valueOf(amounts.get(i)) + " €");
        }
        if (this.textList.size() > amounts.size()) {
            for (; i < this.textList.size(); i++) {
                this.textList.get(i).setBackground(Color.GRAY);
                if (i % 2 == 0) {
                    this.textList.get(i).setText("BANCAROTTA");
                }
            }
        }
    }
}

