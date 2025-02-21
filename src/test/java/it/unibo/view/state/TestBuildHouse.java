package it.unibo.view.state;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.main.impl.MainViewImpl;
import it.unibo.monoopoly.view.state.impl.ViewBuildHouseState;
import it.unibo.monoopoly.controller.state.impl.ControllerBuildHouseState;
import it.unibo.monoopoly.model.state.impl.ModelBuildHouseState;

public class TestBuildHouse extends JFrame {

    public static void main(String[] strg) {
        List<String> propertyList = new ArrayList<>();
        propertyList.add("Park Place");
        propertyList.add("Boardwalk");

        List<String> playerList = new ArrayList<>();
        playerList.add("Player 1");
        playerList.add("Player 2");

        MainController controller = new MainControllerImpl(new MainModelImpl(propertyList), playerList);
        MainView view = new MainViewImpl(controller, propertyList, playerList);
        ViewBuildHouseState viewState = new ViewBuildHouseState(view);
        ModelBuildHouseState modelState = new ModelBuildHouseState(new MainModelImpl(propertyList));
        ControllerBuildHouseState controllerState = new ControllerBuildHouseState(modelState, viewState);

        controllerState.startState();
        
        // se vogliamo aggiungere una logica di test ulteriore, possiame simulare delle azioni qui, ad esempio, simulando la scelta di una cella da parte dell'utente e chiamando
        // controllerState.continueState().
    }
}
