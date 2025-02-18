package it.unibo.monoopoly.controller.data.api;

import java.util.List;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.controller.data.impl.DataInput;
import it.unibo.monoopoly.model.gameboard.api.Dices.Pair;

/**
 * The builder of a class that contains all information for the gui.
 */
public interface DataBuilderInput {
    /**
     * 
     * @param event
     * @return this.
     */
    DataBuilderInput event(Event event);

    /**
     * 
     * @param name
     * @return this.
     */
    DataBuilderInput nameOfProperty(String name);

    /**
     * 
     * @param name
     * @return this.
     */
    DataBuilderInput nameOfPlayer(String name);

    /**
     * 
     * @param value
     * @return this.
     */
    DataBuilderInput valueToPay(Integer value);

    /**
     * 
     * @param dices
     * @return this.
     */
    DataBuilderInput dices(Pair dices);

    /**
     * 
     * @param mode
     * @return this.
     */
    DataBuilderInput setMode1(boolean mode);

    /**
     * 
     * @param mode
     * @return this.
     */
    DataBuilderInput setMode2(boolean mode);

    /**
     * 
     * @param list
     * @return this.
     */
    DataBuilderInput cellList(List<Integer> list);

    /**
     * 
     * @param text
     * @return this.
     */
    DataBuilderInput cardText(String text);

    /**
     * 
     * @return product.
     */
    DataInput build();
}
