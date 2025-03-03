package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

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
     * @param cellList
     */
    public SelectionCellsPanel(final ViewCellGiver closeMethod, final List<String> cellList, final String text, final boolean addNoChooseButton) {
        super();
        final JPanel innerPanel = new JPanel();
        this.setLayout(new BorderLayout());
        innerPanel.setLayout(new GridLayout(0, cellList.size()));
        this.add(new JTextArea("Scegli una proprietà " + text), BorderLayout.NORTH);
        for (final String string : cellList) {
            final JButton j = new JButton(string);
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
