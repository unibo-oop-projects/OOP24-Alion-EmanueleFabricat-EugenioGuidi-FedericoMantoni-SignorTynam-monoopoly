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
 * {@link JPanel} used to show and select a cell.
 */
public final class SelectionCellsPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);
    private static final int RESIZE_PERCENT = 60;

    /**
     * Constructor of the class.
     * @param mainFrameHeight use to set the size of the text.
     * @param closeMethod the {@link ActionListener} to attach to the {@link JButton}.
     * @param cellMap contain the entry name of the player -> amount.
     * @param text to finish the title text.
     * @param addNoChooseButton to decide if the {@link JButton} noChoiceButton have to display or not.
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
            j.setFont(new Font("Arial", Font.PLAIN, mainFrameHeight / RESIZE_PERCENT));
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
