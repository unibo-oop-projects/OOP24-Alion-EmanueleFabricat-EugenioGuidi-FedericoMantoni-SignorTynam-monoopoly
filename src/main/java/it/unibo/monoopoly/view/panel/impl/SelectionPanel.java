package it.unibo.monoopoly.view.panel.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import it.unibo.monoopoly.controller.menu.api.MenuController;

/**
 * Panel for handle input of the number and names of players decided by the
 * user.
 */
public final class SelectionPanel extends JPanel {

    private static final int MAX_NAME_LENGTH = 25;
    private static final double NUMBER_LABEL_WEIGHT = 0.4;
    private static final double SPINNER_WEIGHT = 0.3;
    private static final double BUTTON_WEIGHT = 0.3;
    private static final double COLOR_WEIGHT = 0.05;
    private static final double NAME_LABEL_WEIGHT = 0.3;
    private static final double TEXTFIELD_WEIGHT = 0.65;

    private static final Dimension PREFERRED_SIZE_COLOR = new Dimension(40, 20);

    private static final long serialVersionUID = 1L;

    private JPanel namesPanel;
    private final JPanel numberPanel;
    private final List<Color> colors;
    private final List<JTextField> players;
    private transient final MenuController menuController;
    private final Font font = new Font("Arial", Font.BOLD, 15);

    /**
     * Construct and inizialize the SelectionPanel.
     * @param controller the istance of {@link MenuController}, needed to initialize
     *                   the game based on player inputs
     * @param colors the colors used in the game to represent the players
     */
    public SelectionPanel(final MenuController controller, final List<Color> colors) {
        super();
        this.menuController = controller;
        this.colors = new ArrayList<>(colors);
        this.players = new ArrayList<>();

        this.setLayout(new GridBagLayout());
        final JLabel nPlayerTextSelection = new JLabel("Scegli il numero di giocatori");
        nPlayerTextSelection.setFont(this.font);
        final JSpinner spinnerSelection = new JSpinner(new SpinnerNumberModel(4, 2, 4, 1));
        final JButton confirmSelection = new JButton("OK");
        confirmSelection.addActionListener(ev -> {
            try {
                spinnerSelection.commitEdit();
                generateNamesPanel((int) spinnerSelection.getValue());
            } catch (final ParseException ex) {
                JOptionPane.showMessageDialog(this,
                        "Input non valido: " + spinnerSelection.getValue() + " è un numero di giocatori non consentito",
                        "Errore numero giocatori",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
        this.numberPanel = new JPanel(new GridBagLayout());
        this.numberPanel.add(nPlayerTextSelection, getLabelConstraints());
        this.numberPanel.add(spinnerSelection, getSpinnerConstraints());
        this.numberPanel.add(confirmSelection, getButtonConstraints());
        this.add(numberPanel, getBasicConstraints());
    }

    private void generateNamesPanel(final int nPlayers) {
        this.players.clear();
        this.remove(numberPanel);
        this.namesPanel = new JPanel(new GridBagLayout());
        for (int i = 0; i < nPlayers; i++) {
            final GridBagConstraints gbc = getBasicConstraints();
            final JTextField nameField = new JTextField(25);
            players.add(nameField);
            final JLabel nameLabel = new JLabel("Inserisci il nome del player: ");
            final JPanel color = new JPanel();
            color.setPreferredSize(PREFERRED_SIZE_COLOR);
            color.setBackground(colors.get(i));
            nameLabel.setFont(this.font);
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 0;
            gbc.weightx = COLOR_WEIGHT;
            this.namesPanel.add(color, gbc);
            gbc.weightx = NAME_LABEL_WEIGHT;
            this.namesPanel.add(nameLabel, gbc);
            gbc.weightx = TEXTFIELD_WEIGHT;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            this.namesPanel.add(nameField, gbc);
        }

        final JButton back = new JButton("Indietro");
        final JButton confirm = new JButton("Via!");
        back.setFont(font);
        confirm.setFont(font);
        final GridBagConstraints gbc = getBasicConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        this.namesPanel.add(back, gbc);
        gbc.gridx = 2;
        gbc.anchor = GridBagConstraints.EAST;
        this.namesPanel.add(confirm, gbc);
        this.add(namesPanel, getNamesConstraint());
        this.revalidate();
        this.repaint();

        back.addActionListener(e -> {
            this.remove(namesPanel);
            this.add(numberPanel);
            this.revalidate();
            this.repaint();
        });

        confirm.addActionListener(e -> {
            if (legalNames()) {
                ((JFrame) SwingUtilities.getWindowAncestor(this)).dispose();
                this.menuController.goGame(getPlayersNames());
            } else {
                JOptionPane.showMessageDialog(this,
                        "Ogni giocatore deve avere un nome diverso dagli altri e di lunghezza minore di 25 caratteri", "Warning",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

    }

    private List<String> getPlayersNames() {
        return this.players.stream().map(JTextComponent::getText).collect(Collectors.toList());
    }

    private boolean legalNames() {
        return players.stream().map(JTextComponent::getText).allMatch(
                t -> !t.isBlank() && !t.isEmpty() && t.length() < MAX_NAME_LENGTH)
                && players.stream().map(JTextComponent::getText).count()
                == players.stream().map(JTextComponent::getText).distinct().count();
    }

    private GridBagConstraints getNamesConstraint() {
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weighty = 1;
        return gbc;
    }

    private GridBagConstraints getLabelConstraints() {
        final GridBagConstraints gbc = getBasicConstraints();
        gbc.weightx = NUMBER_LABEL_WEIGHT;
        return gbc;
    }

    private GridBagConstraints getSpinnerConstraints() {
        final GridBagConstraints gbc = getBasicConstraints();
        gbc.weightx = SPINNER_WEIGHT;
        return gbc;
    }

    private GridBagConstraints getButtonConstraints() {
        final GridBagConstraints gbc = getBasicConstraints();
        gbc.weightx = BUTTON_WEIGHT;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        return gbc;
    }

    private GridBagConstraints getBasicConstraints() {
        final GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        return gbc;
    }

}
