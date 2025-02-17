package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainPanel extends PanelAdapter {
    
    private final JTextArea textArea;

    public MainPanel() {
        setLayout(new BorderLayout());
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void appendText(String text) {
        textArea.append(text + "\n");
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    @Override
    protected void panelInit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'panelInit'");
    }

}
