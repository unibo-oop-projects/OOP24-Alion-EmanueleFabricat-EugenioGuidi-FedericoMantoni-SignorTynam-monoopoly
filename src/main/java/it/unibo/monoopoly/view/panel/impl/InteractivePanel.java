package it.unibo.monoopoly.view.panel.impl;

import javax.swing.JPanel;

public class InteractivePanel extends AbstractPanel {

    private static final long serialVersionUID = 1L;

    @Override
    protected void panelInit() {
        setInteractivePanel(new DefaultInteractivePanel());
    }

    public void setInteractivePanel(final JPanel newPanel) {
        final var parent = getParent();
        if(parent != null) {
            parent.remove(this);
            parent.add(newPanel);
            parent.revalidate();
            parent.repaint();
        }
    }
}
