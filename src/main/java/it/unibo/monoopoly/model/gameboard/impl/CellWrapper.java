package it.unibo.monoopoly.model.gameboard.impl;

import java.util.Optional;

import it.unibo.monoopoly.common.Message;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.gameboard.api.Cell;
import it.unibo.monoopoly.model.gameboard.api.Company;
import it.unibo.monoopoly.model.gameboard.api.Functional;
import it.unibo.monoopoly.model.player.api.Player;

public class CellWrapper implements Functional, Company  {

    private Cell cell;

    public CellWrapper(final Cell cell) {
        this.cell = cell;
    }

    @Override
    public String getName() {
        return cell.getName();
    }

    @Override
    public boolean isBuyable() {
        return cell.isBuyable();
    }

    @Override
    public boolean isBuildable() {
        return cell.isBuildable();
    }

    @Override
    public boolean isRailroad() {
        return cell.isRailroad();
    }

    @Override
    public boolean isCompany() {
        return cell.isCompany();
    }

    @Override
    public boolean isAvailable() {
        if (cell.isBuyable()) {
            return ((Buyable) cell).isAvailable();
        } else throw new IllegalStateException("Cannot call this method on a not Buyable cell");
    }

    @Override
    public boolean isMortgaged() {
        if (cell.isBuyable()) {
            return ((Buyable) cell).isMortgaged();
        } else throw new IllegalStateException("Cannot call this method on a not Buyable cell");
    }

    @Override
    public Optional<Player> getOwner() {
        if (cell.isBuyable()) {
            return ((Buyable) cell).getOwner();
        } else throw new IllegalStateException("Cannot call this method on a not Buyable cell");
    }

    @Override
    public int getCost() {
        if (cell.isBuyable()) {
            return ((Buyable) cell).getCost();
        } else throw new IllegalStateException("Cannot call this method on a not Buyable cell");
    }

    @Override
    public void setOwner(Optional<Player> ownerPlayer) {
        throw new UnsupportedOperationException("This method is not supported by the proxy");
    }

    @Override
    public int getRentalValue() {
        if (cell.isBuyable()) {
            return ((Buyable) cell).getRentalValue();
        } else throw new IllegalStateException("Cannot call this method on a not Buyable cell");
    }

    @Override
    public int getMortgageValue() {
        if (cell.isBuyable()) {
            return ((Buyable) cell).getMortgageValue();
        } else throw new IllegalStateException("Cannot call this method on a not Buyable cell");
    }

    @Override
    public void setMortgage() {
        throw new UnsupportedOperationException("This method is not supported by the proxy");
    }

    @Override
    public void removeMortgage() {
        throw new UnsupportedOperationException("This method is not supported by the proxy");
    }

    @Override
    public int getUnmortgageValue() {
        if (cell.isBuyable()) {
            return ((Buyable) cell).getUnmortgageValue();
        } else throw new IllegalStateException("Cannot call this method on a not Buyable cell");
    }

    @Override
    public void rollAndCalculate() {
        throw new UnsupportedOperationException("This method is not supported by the proxy");
    }

    @Override
    public Optional<Message> getAction() {
        if (!cell.isBuyable()) {
            return ((Functional) cell).getAction();
        } else throw new IllegalStateException("Cannot call this method on a not Functional cell");
    }

    @Override
    public boolean hasAction() {
        if (!cell.isBuyable()) {
            return ((Functional) cell).hasAction();
        } else throw new IllegalStateException("Cannot call this method on a not Functional cell");
    }

    

}
