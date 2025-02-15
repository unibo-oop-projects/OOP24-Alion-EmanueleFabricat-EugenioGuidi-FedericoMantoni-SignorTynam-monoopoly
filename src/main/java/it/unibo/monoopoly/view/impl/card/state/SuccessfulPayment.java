package it.unibo.monoopoly.view.impl.card.state;

import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;

import it.unibo.monoopoly.view.impl.PanelAdapter;

public class SuccessfulPayment extends PanelAdapter{
    JTextArea message;

    public SuccessfulPayment() {
        super();
    }

    @Override
    protected void panelInit() {
        this.setLayout(new BorderLayout());
        this.add(new JTextArea("Pagamento effetuato con successo"), BorderLayout.CENTER);
        this.add(new JButton("Ok"), BorderLayout.SOUTH);
    }

}
