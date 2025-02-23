package it.unibo.monoopoly.view.panel.impl;

import javax.swing.JPanel;

public class InteractivePanel extends PanelAdapter {

    private static final long serialVersionUID = 1L;

    @Override
    protected void panelInit() {
        setInteractivePanel(new DefaultInteractivePanel());
    }

    public void setInteractivePanel(final JPanel newPanel) {
        final var parent = getParent();
        parent.remove(this);
        parent.add(newPanel);
        parent.revalidate();
        parent.repaint();
    }
}
