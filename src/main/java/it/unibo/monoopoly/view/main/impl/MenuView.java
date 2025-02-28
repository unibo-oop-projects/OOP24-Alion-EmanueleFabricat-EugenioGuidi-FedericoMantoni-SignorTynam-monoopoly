package it.unibo.monoopoly.view.main.impl;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Toolkit;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.menu.api.MenuController;
import it.unibo.monoopoly.view.panel.impl.MenuPanel;

/**
 * Initial view shown at the start of application.
 */
public class MenuView extends AbstractView {

    private final JPanel menuPanel;

    /**
     * Construct and initialize thr frame and panels of {@link MenuView}.
     * 
     * @param menuController the controller of the application
     */
    public MenuView(final MenuController menuController) {
        super();
        final Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.getMainFrame().setSize((int) screenDimension.getWidth() / 2, (int) screenDimension.getHeight() / 2);
        this.getMainFrame().setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getMainFrame().setMinimumSize(new Dimension(600, 600));
        menuPanel = new MenuPanel(menuController, super.getColors());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JPanel getMainPanel() {
        return this.menuPanel;
    }

}
