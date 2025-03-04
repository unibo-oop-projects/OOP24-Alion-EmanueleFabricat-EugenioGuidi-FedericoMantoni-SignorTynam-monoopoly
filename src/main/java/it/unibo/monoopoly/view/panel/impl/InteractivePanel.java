package it.unibo.monoopoly.view.panel.impl;


import javax.swing.BoxLayout;
import javax.swing.JPanel;

public final class InteractivePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    public InteractivePanel(final JPanel initPanel) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(initPanel);
    }
}
