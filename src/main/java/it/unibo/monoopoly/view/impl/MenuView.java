package it.unibo.monoopoly.view.impl;

import it.unibo.monoopoly.controller.api.MenuController;
import it.unibo.monoopoly.controller.impl.MenuControllerImpl;

/**
 * Initial view shown at the start of application.
 */
public class MenuView extends AbstractView {

    private final PanelAdapter menuPanel;

    /**
     * Construct and initialize thr frame and panels of {@link MenuView}.
     */
    public MenuView(MenuController menuController) {
        super();
        menuPanel = new MenuPanel(menuController, super.getColors());
    }

    /**
     * MAIN ONLY FOR TEST.
     */
    public static void main(final String[] args) {
        new MenuView().display();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PanelAdapter getMainPanel() {
        return this.menuPanel;
    }

}
