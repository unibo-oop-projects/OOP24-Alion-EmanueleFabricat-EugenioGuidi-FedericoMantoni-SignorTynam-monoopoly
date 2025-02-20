package it.unibo.monoopoly.view.state.impl;
import javax.swing.JPanel;

import it.unibo.monoopoly.controller.data.api.DataBuilderOutput;
import it.unibo.monoopoly.controller.data.impl.DataBuilderOutputImpl;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.view.main.impl.MainView;
import it.unibo.monoopoly.view.state.api.ViewState;

public class ViewBuildHouseState implements ViewState {

    private final MainView mainView;
    private boolean canBuild;
    private final DataBuilderOutput dataBuilder;

    public ViewBuildHouseState(MainView mainView) {
        this.mainView = mainView;
        this.dataBuilder = new DataBuilderOutputImpl(); // Assuming correct implementation
    }

    @Override
    public void setMode(Boolean setter) {
        this.canBuild = setter;
    }

    @Override
    public void visualize(DataInput data) {
        if (canBuild) {
            JPanel interactivePanel = new JPanel(); // Creare un pannello con le proprietà selezionabili
            mainView.setInteractivePanel(interactivePanel);

            int chosenCell = 0; // Simulazione scelta utente (da integrare con GUI)
            mainView.getMainController().getControllerState().continueState(dataBuilder.cellChoose(chosenCell).build());
        } else {
            mainView.getMainController().getControllerState().continueState(dataBuilder.build());
        }
    }
}
