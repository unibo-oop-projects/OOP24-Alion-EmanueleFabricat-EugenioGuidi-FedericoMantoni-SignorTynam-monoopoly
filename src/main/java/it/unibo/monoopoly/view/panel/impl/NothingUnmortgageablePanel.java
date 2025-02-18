package it.unibo.monoopoly.view.panel.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

/**
 * comment.
 */
public class NothingUnmortgageablePanel extends PanelAdapter {
    private JTextArea message;
    private ActionListener closeMethod;
    private JButton closeButton;

    /**
     * comment.
     * 
     * @param closeMethod
     */
    public NothingUnmortgageablePanel(final ActionListener closeMethod) {
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
        this.add(new JTextArea("Non hai proprietà a cui può essere tolta la bancarotta con i tuoi liquidi"),
                BorderLayout.CENTER);
        this.add(this.closeButton, BorderLayout.SOUTH);
    }

}
