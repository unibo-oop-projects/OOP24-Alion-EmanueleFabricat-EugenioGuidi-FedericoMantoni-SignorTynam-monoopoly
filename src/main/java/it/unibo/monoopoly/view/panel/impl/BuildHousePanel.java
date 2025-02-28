package it.unibo.monoopoly.view.panel.impl;

import java.util.List;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import it.unibo.monoopoly.utils.impl.ViewCellGiver;

public class BuildHousePanel extends JPanel {
    private final ViewCellGiver closeMethod;
    private final List<String> cellList;
    private JPanel innerPanel;

    /**
     * comment.
     * 
     * @param closeMethod
     * @param cellList
     */
    public BuildHousePanel(final ViewCellGiver closeMethod, final List<String> cellList) {
        super();
        this.closeMethod = closeMethod;
        this.cellList = cellList;
        this.innerPanel = new JPanel();

        this.setLayout(new BorderLayout());
        this.innerPanel.setLayout(new GridLayout(0, cellList.size()));
        this.add(new JTextArea("Choose a property on which to build a house"), BorderLayout.NORTH);
        for (final String string : cellList) {
            final JButton j = new JButton(string);
            this.innerPanel.add(j, BorderLayout.CENTER);
            j.addActionListener(closeMethod);
        }
        this.add(innerPanel, BorderLayout.CENTER);
        final JButton noChoiceButton = new JButton(ViewCellGiver.NO_CHOICE);
        noChoiceButton.addActionListener(closeMethod);
        this.add(noChoiceButton, BorderLayout.SOUTH);
    }

}
