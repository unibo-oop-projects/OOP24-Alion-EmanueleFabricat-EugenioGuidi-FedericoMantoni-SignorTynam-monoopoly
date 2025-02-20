package it.unibo.monoopoly.model.state.impl;

import java.util.Set;
import java.util.stream.Collectors;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;

public class ModelBuildHouseState implements ModelState {

    private final MainModel model;
    private boolean canBuild;

    public ModelBuildHouseState(MainModel model) {
        this.model = model;
    }

    @Override
    public boolean verify() {
        Player currentPlayer = model.getGameBoard().getCurrentPlayer();
        Set<Buildable> buildableProperties = currentPlayer.getProperties().stream()
                .filter(p -> p instanceof Buildable) // Filtra solo le proprietà buildabili
                .map(p -> (Buildable) p) // Cast a Buildable
                .filter(p -> p.getHousesNumber() < 5 && !p.isMortgaged()) // Usa isMortgaged() e getHousesNumber()
                .collect(Collectors.toSet());
        canBuild = !buildableProperties.isEmpty();
        return canBuild;
    }

    @Override
    public void doAction(DataOutput data) {
        if (canBuild && data.cellChoose().isPresent()) {
            int cellIndex = data.cellChoose().get();
            Buildable property = (Buildable) model.getGameBoard().getCell(cellIndex);
            if (property.getHousesNumber() < 5 && !property.isMortgaged()) {
                property.buildHouse();
            }
        }
    }

    @Override
    public void closeState() {
        if (!canBuild) {
            // model.nextTurn();
        } else {
            model.setState(new ModelBuildHouseState(model));
        }
    }
}
