package it.unibo.monoopoly.view.main.api;

import java.util.List;

import javax.swing.JPanel;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.view.state.api.ViewState;

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

    void setInteractivePanel(JPanel panel);

    ViewState getViewState();

}
