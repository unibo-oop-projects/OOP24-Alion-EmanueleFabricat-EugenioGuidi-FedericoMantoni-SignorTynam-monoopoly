package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;
import it.unibo.monoopoly.view.panel.api.UpdatablePanel;

public class VisualizePlayerPanel extends AbstractPanel implements UpdatablePanel {

    private static final long serialVersionUID = 1L;

    private final int playersNumber;
    private final int mainFrameHeight;
    private final String firstPlayer;
    private final List<Triple<String, Integer, Color>> initializedList;
    private final List<JTextArea> textList = new LinkedList<>();
    private static final double PERC_RESIZE = 0.035;

    /**
     * comment
     * 
     * @param mainFrameHeight the height of the main frame
     * @param firstPlayer     the name of the player starting the game
     * @param initializedList
     */
    public VisualizePlayerPanel(final int mainFrameHeight, final String firstPlayer,
            final List<Triple<String, Integer, Color>> initializedList) {
        super();
        this.playersNumber = initializedList.size();
        this.mainFrameHeight = mainFrameHeight;
        this.firstPlayer = firstPlayer;
        this.initializedList = initializedList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        setLayout(new GridLayout(playersNumber * 2 + 1, 1));
        this.textList.add(new JTextArea("E' il turno di " + this.firstPlayer));
        for (final Triple<String, Integer, Color> triple : initializedList) {
            this.textList.add(new JTextArea(triple.getLeft()));
            this.textList.getLast().setBackground(triple.getRight());
            this.textList.add(new JTextArea(triple.getMiddle() + " €"));
            this.textList.getLast().setBackground(triple.getRight());
        }
        for (final var text : this.textList) {
            text.setEnabled(false);
            text.setFont(new Font("Arial", Font.PLAIN, (int) (PERC_RESIZE * this.mainFrameHeight)));
            add(text);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(ViewUpdateDTO updateData) {
        this.textList.get(0).setText("E' il turno di " + updateData.actualPlayer());
        for (var entry : updateData.playersMoney().entrySet()) {
            this.textList.stream()
                    .peek(t -> t.getText().equals(entry.getKey()))
                    .map(t -> this.textList.get(this.textList.indexOf(t) + 1))
                    .findFirst().get().setText(entry.getValue() + " €");
        }
        this.textList.stream()
                .filter(t -> this.textList.indexOf(t) % 2 == 1 &&  this.textList.indexOf(t) > 0)
                .filter(t -> !keysList(updateData.playersMoney()).contains(t.getText()))
                .map(t -> this.textList.get(this.textList.indexOf(t) + 1))
                .forEach(t -> {
                    t.setText("BANCAROTTA");
                    t.setBackground(Color.GRAY);
                });
    }

    private List<String> keysList(Map<String, Integer> map) {
        return map.entrySet().stream()
                .map(e -> e.getKey())
                .toList();
    }
}
