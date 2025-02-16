package it.unibo.monoopoly.view.impl.banker.state;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import it.unibo.monoopoly.view.impl.PanelAdapter;

public class BankruptcyView extends PanelAdapter{
    JTextArea message;
    ActionListener closeMethod;
    JButton closeButton;

    public BankruptcyView(ActionListener closeMethod) {
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
