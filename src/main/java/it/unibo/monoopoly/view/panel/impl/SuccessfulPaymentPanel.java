package it.unibo.monoopoly.view.panel.impl;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

public class SuccessfulPaymentPanel extends PanelAdapter{
    JTextArea message;
    ActionListener closeMethod;
    JButton closeButton;

    public SuccessfulPaymentPanel(ActionListener closeMethod) {
        super();
        this.closeMethod = closeMethod;
    }

    @Override
    protected void panelInit() {
        this.setLayout(new BorderLayout());
        this.closeButton = new JButton("Ok");
        this.closeButton.addActionListener(closeMethod);
        this.add(new JTextArea("Pagamento effetuato con successo"), BorderLayout.CENTER);
        this.add(this.closeButton, BorderLayout.SOUTH);
    }

}
