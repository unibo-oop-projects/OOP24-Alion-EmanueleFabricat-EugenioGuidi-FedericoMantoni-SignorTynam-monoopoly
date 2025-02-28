package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * comment.
 */
public final class MainPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private final JTextArea textArea;

    /**
     * comment.
     */
    public MainPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        final JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }
    
    /**
     * comment.
     * 
     * @param text
     */
    public void appendText(final String text) {
        textArea.append(text + "\n");
    }
    
    /**
     * comment.
     * 
     * @param text
     */
    public void setText(final String text) {
        textArea.setText(text);
    }

}
