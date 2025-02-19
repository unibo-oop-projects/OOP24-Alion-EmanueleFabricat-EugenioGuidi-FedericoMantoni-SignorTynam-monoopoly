package it.unibo.monoopoly.view.panel.impl;

import javax.swing.JTextArea;

public class InteractivePanel extends PanelAdapter{

    @Override
    protected void panelInit() {
        add(new JTextArea("ciao"));
    }

}
