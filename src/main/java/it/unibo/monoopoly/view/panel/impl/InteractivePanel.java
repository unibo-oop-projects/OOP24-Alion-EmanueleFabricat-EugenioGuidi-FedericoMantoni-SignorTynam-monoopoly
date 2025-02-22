package it.unibo.monoopoly.view.panel.impl;

import javax.swing.JPanel;

public class InteractivePanel extends PanelAdapter{

    @Override
    protected void panelInit() {
        setInteractivePanel(new DefaultInteractivePanel());
    }

    public void setInteractivePanel(JPanel newPanel) {
        var parent = getParent();
        parent.remove(this);
        parent.add(newPanel);
        parent.revalidate();
        parent.repaint();
    }
}