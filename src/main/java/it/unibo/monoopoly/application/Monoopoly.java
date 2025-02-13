package it.unibo.monoopoly.application;

import it.unibo.monoopoly.controller.impl.MenuControllerImpl;

/**
 * Main class that starts the application
 */
public class Monoopoly {

    /**
     * Unused constructor, must be private
     */
    private Monoopoly() {

    }

    public static void main(final String[] args) {
        new MenuControllerImpl();
    }

}
