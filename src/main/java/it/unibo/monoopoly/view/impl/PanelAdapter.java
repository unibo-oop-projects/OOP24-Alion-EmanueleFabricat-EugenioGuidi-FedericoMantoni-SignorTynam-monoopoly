package it.unibo.monoopoly.view.impl;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import it.unibo.monoopoly.view.api.GamePanel;

/**
 * Pattern Adapter to build a JPanel with personalized methods.
 */
public abstract class PanelAdapter extends JPanel implements GamePanel {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor in common for all {@link GamePanel}s used.
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
     * Initialize the {@link GamePanel} and all its components.
     */
    protected abstract void panelInit();

}
