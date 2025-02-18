package it.unibo.monoopoly.view.panel.impl;

import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

/**
 * comment.
 */
public class SuccessfulPaymentPanel extends PanelAdapter {
    private JTextArea message;
    private final ActionListener closeMethod;
    private JButton closeButton;

    /**
     * comment.
     * 
     * @param closeMethod
     */
    public SuccessfulPaymentPanel(final ActionListener closeMethod) {
        super();
        this.closeMethod = closeMethod;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        this.setLayout(new BorderLayout());
        this.closeButton = new JButton("Ok");
        this.closeButton.addActionListener(closeMethod);
        this.add(new JTextArea("Pagamento effetuato con successo"), BorderLayout.CENTER);
        this.add(this.closeButton, BorderLayout.SOUTH);
    }

}
