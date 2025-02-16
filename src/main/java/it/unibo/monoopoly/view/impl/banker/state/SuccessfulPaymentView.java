package it.unibo.monoopoly.view.impl.banker.state;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import it.unibo.monoopoly.view.impl.PanelAdapter;

public class SuccessfulPaymentView extends PanelAdapter{
    JTextArea message;
    ActionListener closeMethod;
    JButton closeButton;

    public SuccessfulPaymentView(ActionListener closeMethod) {
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
