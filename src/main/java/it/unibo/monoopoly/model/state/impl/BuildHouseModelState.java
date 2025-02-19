package it.unibo.monoopoly.model.state.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.gameboard.api.Buildable;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.main.api.MainModel;
import it.unibo.monoopoly.model.player.api.Player;
import it.unibo.monoopoly.model.state.api.ModelState;

/**
 * comment.
 */
public class BuildHouseModelState implements ModelState {
    /**
     *
     * {@inheritDoc}
     */
    @Override
    public boolean verify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verify'");
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void doAction(final Optional<DataOutput> data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'doAction'");
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public void closeState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'closeState'");
    }
    /*
     * private List<Buildable> buildableProperties;
     * private String message;
     * private final Turn mainmodel;
     * 
     * public BuildHouseModelState(Turn mainModel) {
     * this.mainmodel = mainModel;
     * }
     * 
     * @Override
     * public boolean verify() {
     * buildableProperties = new ArrayList<>();
     * for (Buyable property : mainmodel.getActualPlayer().getProperties()) {
     * if (property instanceof Buildable) {
     * buildableProperties.add((Buildable) property);
     * }
     * }
     * if (buildableProperties.isEmpty()) {
     * message = "You don't have any property to build on";
     * return false;
     * } else {
     * StringBuilder sb = new
     * StringBuilder("Select the index of the property to build a house on:\n");
     * for (int i = 0; i < buildableProperties.size(); i++) {
     * Buildable b = buildableProperties.get(i);
     * sb.append(i)
     * .append(" -> ")
     * .append(b.toString())
     * .append(" (House cost: ")
     * .append(b.getHouseCost())
     * .append(")\n");
     * }
     * message = sb.toString();
     * return true;
     * }
     * //return false;
     * }
     * 
     * @Override
     * public void doAction(Integer index) {
     * if (buildableProperties == null || buildableProperties.isEmpty()) {
     * message = "You don't have any property to build on";
     * return;
     * }
     * if (index < 0 || index >= buildableProperties.size()) {
     * message = "Invalid index";
     * return;
     * }
     * Buildable property = buildableProperties.get(index);
     * int cost = property.getHouseCost();
     * if (mainmodel.getActualPlayer().isPayable(cost)) {
     * mainmodel.getActualPlayer().pay(cost);
     * property.buildHouse();
     * message = "You built a house on " + property.toString() + ".";
     * } else {
     * message = "You can't afford to build a house on " + property.toString();
     * }
     * }
     * 
     * @Override
     * public String getData() {
     * return message;
     * }
     * 
     * @Override
     * public void closeState() {
     * 
     * }
     */
}
