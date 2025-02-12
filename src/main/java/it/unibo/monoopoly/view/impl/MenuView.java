package it.unibo.monoopoly.view.impl;

import java.util.Set;

import it.unibo.monoopoly.controller.impl.MenuControllerImpl;

public class MenuView extends AbstractView {

    private final PanelAdapter menuPanel;

    public MenuView() {
        super();
        menuPanel = new MenuPanel(new MenuControllerImpl());
        this.getMainFrame().add(menuPanel);
    }

    public static void main(String[] args) {
        new MenuView().display();
    }

    @Override
    public Set<PanelAdapter> getAllPanels() {
        return Set.of(menuPanel);
    }

}
