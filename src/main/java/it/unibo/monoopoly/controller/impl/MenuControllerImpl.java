package it.unibo.monoopoly.controller.impl;

import java.util.List;

import it.unibo.monoopoly.controller.api.MainController;
import it.unibo.monoopoly.controller.api.MenuController;
import it.unibo.monoopoly.model.impl.player.TurnImpl;
import it.unibo.monoopoly.view.impl.MenuView;

/**
 * Implementation of {@link MenuController} interface.
 */
public class MenuControllerImpl implements MenuController {

    private MainController mainController;

    /**
     * Constructor of {@link MenuControllerImpl}; start and display the {@link MenuView}.
     */
    public MenuControllerImpl() {
        new MenuView(this).display();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void goGame(final List<String> namePlayers) {
        this.mainController = new MainControllerImpl(new TurnImpl(namePlayers), namePlayers);
        this.mainController.startTurn();
    }

}
