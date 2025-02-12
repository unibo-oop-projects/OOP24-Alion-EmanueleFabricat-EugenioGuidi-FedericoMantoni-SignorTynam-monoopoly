package it.unibo.monoopoly.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import it.unibo.monoopoly.controller.api.MenuController;

/**
 * Panel showed at the start of the application.
 */
public class MenuPanel extends PanelAdapter {

    private static final String ARIAL_FONT = "Arial";
    private static final long serialVersionUID = 1L;
    private static final int MARGIN_TOP_TITLE = 70;
    private static final int BUTTON_RATIO = 77;
    private static final int TITLE_RATIO = 25;
    private static final int PADX_TITLE = 250;
    private static final int PADY_TITLE = 50;
    private static final int PADX_BUTTON = 80;
    private static final int PADY_BUTTON = 40;
    private static final int FONT_SIZE_TITLE = 60;
    private static final int FONT_SIZE_BUTTON = 20;
    private static final Color GREEN_MONOPOLY = new Color(0xecfcf4);

    private final SelectionPanel playerSelection;

    private JPanel title;
    private JButton start;
    private JLabel monoopoly;

    /**
     * Construct and inizialize the MenuPanel.
     * 
     * @param controller the istance of {@link MenuController}, needed to initialize
     *                   the game based on player inputs
     */
    public MenuPanel(final MenuController controller) {
        super();
        this.playerSelection = new SelectionPanel(controller);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void panelInit() {
        this.title = new JPanel(new BorderLayout());
        this.start = new JButton("START");
        this.monoopoly = new JLabel("MONOOPOLY");
        this.setBackground(GREEN_MONOPOLY);
        this.setLayout(new GridBagLayout());
        this.start.setFont(new Font(ARIAL_FONT, Font.BOLD, FONT_SIZE_BUTTON));
        this.start.setPreferredSize(start.getPreferredSize());
        this.title.setBackground(Color.RED);
        this.monoopoly.setFont(new Font(ARIAL_FONT, Font.BOLD, FONT_SIZE_TITLE));
        this.monoopoly.setForeground(Color.WHITE);
        this.monoopoly.setHorizontalAlignment(SwingConstants.CENTER);
        this.title.add(monoopoly, BorderLayout.CENTER);
        this.start.addActionListener(e -> {
            start.setVisible(false);
            this.add(playerSelection, getSelectionConstraints());
            playerSelection.display();
        });
        this.add(start, getButtonCostraints());
        this.add(title, getTitleConstraints());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resizeText(final Dimension frameSize) {
        this.monoopoly.setFont(new Font(ARIAL_FONT, Font.BOLD, (int) frameSize.getWidth() / TITLE_RATIO));
        this.start.setFont(new Font(ARIAL_FONT, Font.BOLD, (int) frameSize.getWidth() / BUTTON_RATIO));
        this.playerSelection.resizeText(frameSize);
    }

    /*private Font getPersonalizedFont(final Component c) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonalizedFont'");
    }*/

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
        out.insets = new Insets(MARGIN_TOP_TITLE, 10, 10, 10);
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
