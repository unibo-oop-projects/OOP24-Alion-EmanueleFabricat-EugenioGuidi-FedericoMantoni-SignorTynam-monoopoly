package it.unibo.view.state;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import it.unibo.monoopoly.controller.main.api.MainController;
import it.unibo.monoopoly.controller.main.impl.MainControllerImpl;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.main.impl.MainModelImpl;
import it.unibo.monoopoly.model.state.impl.ModelPrisonState;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.main.impl.MainViewImpl;
import it.unibo.monoopoly.view.state.impl.ViewPrisonState;
import it.unibo.monoopoly.controller.state.impl.PrisonControllerState;

public class TestPrisonState extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<String> propertyList = new ArrayList<>();
            propertyList.add("Park Place");
            propertyList.add("Boardwalk");

            List<String> playerList = new ArrayList<>();
            playerList.add("Player 1");
            playerList.add("Player 2");

            MainModel mainModel = new MainModelImpl(propertyList);
            MainController controller = new MainControllerImpl(mainModel, playerList);
            MainView view = new MainViewImpl(controller, propertyList, playerList);

            ModelPrisonState modelStateJail = new ModelPrisonState(mainModel, true);
            PrisonControllerState prisonControllerJail = new PrisonControllerState(controller, 
                    modelStateJail, new ViewPrisonState(view), mainModel.getGameBoard().getCurrentPlayer());
            prisonControllerJail.startState();
            prisonControllerJail.continueState(null);

            ModelPrisonState modelStateRelease = new ModelPrisonState(mainModel, false);
            PrisonControllerState prisonControllerRelease = new PrisonControllerState(controller, 
                    modelStateRelease, new ViewPrisonState(view), mainModel.getGameBoard().getCurrentPlayer());
            prisonControllerRelease.startState();
            prisonControllerRelease.continueState(null);
        });
    }
}
