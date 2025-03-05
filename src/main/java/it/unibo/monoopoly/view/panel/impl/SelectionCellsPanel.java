package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import it.unibo.monoopoly.utils.impl.ViewCellGiver;

/**
 * comment.
 */
public final class SelectionCellsPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    /**
     * 
     * @param closeMethod
     * @param cellMap
     */
    public SelectionCellsPanel(final int mainFrameHeight, final ViewCellGiver closeMethod,
            final Map<String, Integer> cellMap, final String text, final boolean addNoChooseButton) {
        super();
        final JPanel innerPanel = new JPanel();
        final JTextArea title = new JTextArea("Scegli una proprietà " + text);
        final Font font = new Font("Arial", Font.PLAIN, mainFrameHeight / 45);
        title.setLineWrap(true);
        title.setWrapStyleWord(true);
        title.setFont(font);
        title.setEnabled(false);
        title.setDisabledTextColor(Color.BLACK);
        title.setBorder(new LineBorder(Color.BLACK));
        title.setBackground(GREEN_MONOPOLY);
        this.setLayout(new BorderLayout());
        innerPanel.setLayout(
                new GridLayout(cellMap.size() / 2 + cellMap.size() % 2, cellMap.size() > 2 ? 2 : cellMap.size()));
        this.add(title, BorderLayout.NORTH);
        for (final var entry : cellMap.entrySet()) {
            final JButton j = new JButton(entry.getKey() + "\n " + entry.getValue() + " €");
            j.setFont(new Font("Arial", Font.PLAIN, mainFrameHeight / 60));
            innerPanel.add(j, BorderLayout.CENTER);
            j.addActionListener(closeMethod);
        }
        this.add(innerPanel, BorderLayout.CENTER);
        if (addNoChooseButton) {
            final JButton noChoiceButton = new JButton(ViewCellGiver.NO_CHOICE);
            noChoiceButton.setFont(font);
            noChoiceButton.addActionListener(closeMethod);
            this.add(noChoiceButton, BorderLayout.SOUTH);
        }
    }
}
