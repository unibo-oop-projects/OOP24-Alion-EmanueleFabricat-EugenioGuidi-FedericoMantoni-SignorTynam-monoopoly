package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class BankruptcyPanel extends PanelAdapter{
    JTextArea message;
    ActionListener closeMethod;
    JButton closeButton;

    public BankruptcyPanel(ActionListener closeMethod) {
        super();
        this.closeMethod = closeMethod;
    }

    @Override
    protected void panelInit() {
        this.setLayout(new BorderLayout());
        this.closeButton = new JButton("Ok");
        this.closeButton.addActionListener(closeMethod);
        this.add(new JTextArea("SEI ANDATO IN BANCAROTTA, PER TE IL GIOCO E' FINITO"), BorderLayout.CENTER);
        this.add(this.closeButton, BorderLayout.SOUTH);
    }

}
