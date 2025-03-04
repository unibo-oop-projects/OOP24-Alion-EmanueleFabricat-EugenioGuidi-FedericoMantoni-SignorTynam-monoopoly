package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unibo.monoopoly.utils.impl.ViewCellGiver;

/**
 * comment.
 */
public final class SelectionCellsPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * 
     * @param closeMethod
     * @param cellMap
     */
    public SelectionCellsPanel(final ViewCellGiver closeMethod, final Map<String, Integer> cellMap, final String text, final boolean addNoChooseButton) {
        super();
        final JPanel innerPanel = new JPanel();
        this.setLayout(new BorderLayout());
        innerPanel.setLayout(new GridLayout(0, cellMap.size()));
        this.add(new JTextArea("Scegli una proprietà " + text), BorderLayout.NORTH);
        for (final var entry : cellMap.entrySet()) {
            final JButton j = new JButton(entry.getKey() + "\n " + entry.getValue() + " €");
            innerPanel.add(j, BorderLayout.CENTER);
            j.addActionListener(closeMethod);
        }
        this.add(innerPanel, BorderLayout.CENTER);
        if (addNoChooseButton) {
            final JButton noChoiceButton = new JButton(ViewCellGiver.NO_CHOICE);
            noChoiceButton.addActionListener(closeMethod);
            this.add(noChoiceButton, BorderLayout.SOUTH);
        }
    }
}
