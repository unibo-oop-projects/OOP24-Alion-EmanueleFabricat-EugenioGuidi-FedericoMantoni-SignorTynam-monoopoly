package it.unibo.monoopoly.model.impl;

import java.util.ArrayList;
import java.util.List;

import it.unibo.monoopoly.model.api.ModelState;
import it.unibo.monoopoly.model.api.gameboard.Buildable;
import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

public class BuildHouseModelState implements ModelState<Integer, String> {
    private final Player player;
    private List<Buildable> buildableProperties;
    private String message;

    public BuildHouseModelState(Player player) {
        this.player = player;
    }

    @Override
    public void verify() {
        buildableProperties = new ArrayList<>();
        for (Buyable property : player.getProperties()) {
            if (property instanceof Buildable) {
                buildableProperties.add((Buildable)property);
            }
        }

        if (buildableProperties.isEmpty()) {
            message = "You don't have any property to build on";
        } else {
            StringBuilder sb = new StringBuilder("Select the index of the property to build a house on:\n");
            for (int i = 0; i < buildableProperties.size(); i++) {
                Buildable b = buildableProperties.get(i);
                sb.append(i).append(" -> ").append(b.toString()).append(" (House cost: ").append(b.getHouseCost()).append(")\n");
            }
            message = sb.toString();
        }
    }

    @Override
    public void doAction(Integer index) {
        if (buildableProperties == null || buildableProperties.isEmpty()) {
            message = "You don't have any property to build on";
            return;
        }

        if (index < 0 || index >= buildableProperties.size()) {
            message = "Invalid index";
            return;
        }

        Buildable property = buildableProperties.get(index);
        int cost = property.getHouseCost();
        if (player.isPayable(cost)) {
            player.pay(cost);
            property.buildHouse();
            message = "You built a house on " + property.toString() + ".";
        } else {
            message = "You can't afford to build a house on " + property.toString();
        }
    }

    @Override
    public String getData() {
        return message;
    }

    @Override
    public void closeState() {
        
    }
}
