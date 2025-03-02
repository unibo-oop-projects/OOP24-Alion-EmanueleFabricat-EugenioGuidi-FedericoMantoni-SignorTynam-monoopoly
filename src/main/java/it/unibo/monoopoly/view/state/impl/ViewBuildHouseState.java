package it.unibo.monoopoly.view.state.impl;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.data.api.DataBuilderOutput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.utils.impl.ViewCellGiver;
import it.unibo.monoopoly.view.main.api.MainView;
import it.unibo.monoopoly.view.panel.impl.SelectionCellsPanel;
import it.unibo.monoopoly.view.state.api.ViewState;

/**
 * Implementation of the view for the house building state.
 * Handles the interaction with the user for selecting properties to build houses on.
 */
public class ViewBuildHouseState implements ViewState {

    private final MainView mainView;
    private boolean canBuild;
    private final DataBuilderOutput dataBuilder;

    /**
     * Constructs the view state for house building.
     * 
     * @param mainView the main view
     */
    public ViewBuildHouseState(final MainView mainView) {
        this.mainView = mainView;
        this.dataBuilder = new DataBuilderOutputImpl();
    }

    /**
     * Sets whether the player can build houses or not.
     * 
     * @param setter true if the player can build, false otherwise
     */
    @Override
    public void setMode(final Boolean setter) {
        this.canBuild = setter;
    }

    /**
     * Displays the user interface for selecting the property to build the house on.
     * 
     * @param data the data related to the user's selection
     */
    @Override
    public void visualize(final DataInput data) {
        if (canBuild) {
            final JPanel interactivePanel = new SelectionCellsPanel(new ViewCellGiver(mainView), intToTextCell(data.cellList().get()) , "su cui vendere una casa");
            mainView.setInteractivePanel(interactivePanel);
        } else {
            JOptionPane.showMessageDialog(this.mainView.getMainFrame(), "There are no properties to build houses on.", "Build House", JOptionPane.PLAIN_MESSAGE);
            this.mainView.getMainController().getControllerState().continueState(new DataBuilderOutputImpl().build());
        }
        //System.out.println(data.toString());
    }

    private List<String> intToTextCell(final List<Integer> cellList) {
        return cellList.stream().map(this.mainView.getNameCells()::get).toList();
    }
}
