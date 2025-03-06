package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import org.apache.commons.lang3.tuple.Triple;

import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.utils.impl.ViewUpdateDTO;
import it.unibo.monoopoly.view.panel.api.UpdatablePanel;
/**
 * {@link JPanel} where the players and their financial situation will be displayed,
 * as well as the current {@link Player}.
 */
public final class VisualizePlayerPanel extends JPanel implements UpdatablePanel {

    private static final long serialVersionUID = 1L;

    private final int playersNumber;
    private final int mainFrameHeight;
    private final String firstPlayer;
    private final List<JTextArea> textList = new LinkedList<>();
    private static final double PERC_RESIZE = 0.035;
    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    /**
     * Constructor of the class.
     * @param mainFrameHeight used to size the text.
     * @param firstPlayer the name of the first {@link Player} that play.
     * @param initializedList the list of players with their respective color, name, and initial money.
     */
    public VisualizePlayerPanel(final int mainFrameHeight, final String firstPlayer,
            final List<Triple<String, Integer, Color>> initializedList) {
        super();
        this.playersNumber = initializedList.size();
        this.mainFrameHeight = mainFrameHeight;
        this.firstPlayer = firstPlayer;
        setLayout(new GridLayout(playersNumber * 2 + 1, 1));
        this.textList.add(new JTextArea("E' il turno di " + this.firstPlayer));
        this.textList.getLast().setBackground(GREEN_MONOPOLY);
        for (final Triple<String, Integer, Color> triple : initializedList) {
            this.textList.add(new JTextArea(triple.getLeft()));
            this.textList.getLast().setBackground(triple.getRight());
            this.textList.add(new JTextArea(triple.getMiddle() + " €"));
            this.textList.getLast().setBackground(triple.getRight());
        }
        for (final var text : this.textList) {
            text.setEnabled(false);
            text.setFont(new Font("Arial", Font.PLAIN, (int) (PERC_RESIZE * this.mainFrameHeight)));
            text.setDisabledTextColor(Color.BLACK);
            text.setBorder(new LineBorder(Color.BLACK));
            add(text);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final ViewUpdateDTO updateData) {
        this.textList.getFirst().setText("E' il turno di " + updateData.actualPlayer());
        this.textList.getFirst().setBackground(GREEN_MONOPOLY);
        for (final var entry : updateData.playersMoney().entrySet()) {
            this.textList.stream()
                    .filter(t -> t.getText().equals(entry.getKey()))
                    .map(t -> this.textList.get(this.textList.indexOf(t) + 1))
                    .findFirst().get().setText(entry.getValue() + " €");
        }
        this.textList.stream()
                .filter(t -> this.textList.indexOf(t) % 2 == 1 && this.textList.indexOf(t) > 0)
                .filter(t -> !keysList(updateData.playersMoney()).contains(t.getText()))
                .map(t -> this.textList.get(this.textList.indexOf(t) + 1))
                .forEach(t -> {
                    t.setText("BANCAROTTA");
                    t.setBackground(Color.GRAY);
                });
    }

    private List<String> keysList(final Map<String, Integer> map) {
        return map.entrySet().stream()
                .map(Entry::getKey)
                .toList();
    }
}
