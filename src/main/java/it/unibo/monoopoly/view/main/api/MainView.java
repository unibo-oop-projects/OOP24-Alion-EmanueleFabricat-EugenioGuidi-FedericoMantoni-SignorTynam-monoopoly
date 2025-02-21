package it.unibo.monoopoly.view.main.api;

import java.util.List;

import it.unibo.monoopoly.controller.main.api.MainController;

public interface MainView extends View{

    /**
     * 
     * @return comment.
     */
    MainController getMainController();

    /**
     * 
     * @return comment.
     */
    List<String> getNameCells();

    /**
     * change the actual state of the view.
     */
    void setState();

}
