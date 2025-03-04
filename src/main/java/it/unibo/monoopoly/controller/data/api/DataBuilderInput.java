package it.unibo.monoopoly.controller.data.api;

import java.util.Map;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.model.gameboard.api.Dices.Pair;

/**
 * The builder of a class that contains all information for the gui.
 */
public interface DataBuilderInput {
    /**
     * 
     * @param map
     * @return this.
     */
    DataBuilderInput cellMap(Map<Integer, Integer> map);

    /**
     * 
     * @param dices
     * @return this.
     */
    DataBuilderInput dices(Pair dices);

    /**
     * 
     * @param event
     * @return this.
     */
    DataBuilderInput event(Event event);

    /**
     * 
     * @param mode
     * @return this.
     */
    DataBuilderInput mode(boolean mode);

    /**
     * 
     * @param text
     * @return this.
     */
    DataBuilderInput text(String text);

    /**
     * 
     * @param value
     * @return this.
     */
    DataBuilderInput valueToPay(Integer value);

    /**
     * 
     * @return product.
     */
    DataInput build();
}
