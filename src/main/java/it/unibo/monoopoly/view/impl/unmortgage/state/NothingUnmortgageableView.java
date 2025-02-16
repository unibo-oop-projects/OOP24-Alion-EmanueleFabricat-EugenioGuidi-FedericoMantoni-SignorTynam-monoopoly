package it.unibo.monoopoly.view.impl.unmortgage.state;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import it.unibo.monoopoly.view.impl.PanelAdapter;

public class NothingUnmortgageableView extends PanelAdapter{
    JTextArea message;
    ActionListener closeMethod;
    JButton closeButton;

    public NothingUnmortgageableView(ActionListener closeMethod) {
        super();
        this.closeMethod = closeMethod;
    }

    @Override
    protected void panelInit() {
        this.setLayout(new BorderLayout());
        this.closeButton = new JButton("Ok");
        this.closeButton.addActionListener(closeMethod);
        this.add(new JTextArea("Non hai proprietà a cui può essere tolta la bancarotta con i tuoi liquidi"), BorderLayout.CENTER);
        this.add(this.closeButton, BorderLayout.SOUTH);
    }

}
