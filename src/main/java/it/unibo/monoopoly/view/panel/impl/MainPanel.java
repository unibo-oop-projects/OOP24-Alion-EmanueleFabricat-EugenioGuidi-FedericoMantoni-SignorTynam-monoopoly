package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * comment.
 */
public class MainPanel extends PanelAdapter {

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

    public void setText(final String text) {
        textArea.setText(text);
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'panelInit'");
    }

}
