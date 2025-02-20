package it.unibo.monoopoly.view.panel.impl;

import java.awt.Container;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class InteractivePanel extends PanelAdapter{

    @Override
    protected void panelInit() {
        JTextArea startText = new JTextArea("Testo iniziale con magari spiegazione o altro");
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        startText.setFont(new Font("Arial", Font.PLAIN, 50));
        startText.setEnabled(false);
        startText.setLineWrap(true);
        startText.setWrapStyleWord(true);
        add(startText);
    }

    public void setInteractivePanel(JPanel newPanel) {
        Container parent = getParent();
        if (parent != null) {
            parent.remove(this);
            parent.add(newPanel);
            parent.revalidate();
            parent.repaint();
        }
    }
}