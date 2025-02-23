package it.unibo.monoopoly.view.panel.impl;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;


/**
 * Pattern Adapter to build a JPanel with personalized methods.
 */
public abstract class PanelAdapter extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor in common for all {@link Panel}s used.
     */
    public PanelAdapter() {
        super();
        SwingUtilities.invokeLater(this::init); // Posticipo l'inizializzazione dopo la costruzione del JPanel
    }

    private void init() {
        this.panelInit();
        this.revalidate();
        this.repaint();
    }

    /**
     * Initialize the {@link Panel} and all its components.
     */
    protected abstract void panelInit();

}
