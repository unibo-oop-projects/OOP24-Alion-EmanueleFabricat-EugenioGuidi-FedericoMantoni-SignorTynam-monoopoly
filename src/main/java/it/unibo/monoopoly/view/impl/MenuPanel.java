package it.unibo.monoopoly.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import it.unibo.monoopoly.controller.api.MenuController;

/**
 * Panel showed at the start of the application.
 */
public class MenuPanel extends PanelAdapter {

    private static final int PADX_TITLE = 250;
    private static final int PADY_TITLE = 50;
    private static final int PADX_BUTTON = 80;
    private static final int PADY_BUTTON = 40;
    private static final int FONT_SIZE_TITLE = 60;
    private static final int FONT_SIZE_BUTTON = 20;
    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    private final SelectionPanel playerSelection;


    /**
     * Construct and inizialize the menuPanel.
     */
    public MenuPanel(MenuController controller, Dimension screenSize) {
        this.playerSelection = new SelectionPanel(controller);
        this.setBackground(GREEN_MONOPOLY);
        this.setLayout(new GridBagLayout());
        final JPanel title = new JPanel(new BorderLayout());
        final JButton start = new JButton("START");
        final JLabel monoopoly = new JLabel("MONOOPOLY");
        System.out.println("label" + monoopoly.getSize());
        System.out.println("panel" + title.getSize());
        start.setFont(new Font("Arial", Font.BOLD, FONT_SIZE_BUTTON));
        start.setPreferredSize(start.getPreferredSize());
        title.setBackground(Color.RED);
        monoopoly.setFont(new Font("Arial", Font.BOLD, FONT_SIZE_TITLE));
        monoopoly.setForeground(Color.WHITE);
        monoopoly.setHorizontalAlignment(SwingConstants.CENTER);
        title.add(monoopoly, BorderLayout.CENTER);
        start.addActionListener(e -> {
            start.setVisible(false);
            this.add(playerSelection, getSelectionConstraints());
            playerSelection.display();
        });
        this.add(start, getButtonCostraints());
        this.add(title, getTitleConstraints());
    }

    @Override
    public void resizeText (Dimension frameSize) {
        final var components = List.of(this.getComponents());
        components.get(0).setFont(new Font("Arial", Font.BOLD, (int) frameSize.getWidth()/25));
        ((JPanel) components.get(1)).getComponent(0).setFont(new Font("Arial", Font.BOLD, (int) frameSize.getWidth()/77));
        this.playerSelection.resizeText(frameSize);
    }

    private Font getPersonalizedFont(Component c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonalizedFont'");
    }

    private GridBagConstraints getButtonCostraints() {
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weighty = 1;
        gbc.ipadx = PADX_BUTTON;
        gbc.ipady = PADY_BUTTON;
        return gbc;
    }

    private GridBagConstraints getTitleConstraints() {
        final GridBagConstraints out = new GridBagConstraints();
        out.anchor = GridBagConstraints.NORTH;
        out.fill = GridBagConstraints.NONE;
        out.gridwidth = GridBagConstraints.REMAINDER;
        out.gridx = 0;
        out.gridy = 0;
        out.weightx = 1;
        out.weighty = 1;
        out.ipadx = PADX_TITLE;
        out.ipady = PADY_TITLE;
        out.insets = new Insets(70, 10, 10, 10);
        return out;
    }

    private GridBagConstraints getSelectionConstraints() {
        final GridBagConstraints out = new GridBagConstraints();
        out.anchor = GridBagConstraints.CENTER;
        out.fill = GridBagConstraints.NONE;
        out.gridx = 0;
        out.gridy = 1;
        out.weighty = 1;
        out.insets = new Insets(10, 10, 10, 10);
        return out;
    }

}
