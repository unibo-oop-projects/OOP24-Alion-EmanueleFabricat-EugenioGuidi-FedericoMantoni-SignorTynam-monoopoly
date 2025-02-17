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
     * @return
     */
    DataBuilderInput event(Event event);
    /**
     * 
     * @param name
     * @return
     */
    DataBuilderInput nameOfProperty(String name);
    /**
     * 
     * @param name
     * @return
     */
    DataBuilderInput nameOfPlayer(String name);
    /**
     * 
     * @param value
     * @return
     */
    DataBuilderInput valueToPay(Integer value);
    /**
     * 
     * @param dices
     * @return
     */
    DataBuilderInput dices(Pair dices);
    /**
     * 
     * @param mode
     * @return
     */
    DataBuilderInput setMode1(boolean mode);
    /**
     * 
     * @param mode
     * @return
     */
    DataBuilderInput setMode2(boolean mode);
    /**
     * 
     * @param list
     * @return
     */
    DataBuilderInput cellList(List<Integer> list);
    /**
     * 
     * @param text
     * @return
     */
    DataBuilderInput cardText(String text);
    /**
     * 
     * @return
     */
    DataInput build();
}
