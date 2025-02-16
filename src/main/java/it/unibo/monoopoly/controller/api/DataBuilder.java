package it.unibo.monoopoly.controller.api;

import java.util.List;

import it.unibo.monoopoly.common.Event;
import it.unibo.monoopoly.model.api.gameboard.Dices.Pair;

/**
 * The builder of a class that contains all information for the gui. 
 */
public interface DataBuilder {
    /**
     * 
     * @param event
     * @return
     */
    DataBuilder event(Event event);
    /**
     * 
     * @param name
     * @return
     */
    DataBuilder nameOfProperty(String name);
    /**
     * 
     * @param name
     * @return
     */
    DataBuilder nameOfPlayer(String name);
    /**
     * 
     * @param dices
     * @return
     */
    DataBuilder dices(Pair dices);
    /**
     * 
     * @param mode
     * @return
     */
    DataBuilder setMode1(boolean mode);
    /**
     * 
     * @param mode
     * @return
     */
    DataBuilder setMode2(boolean mode);
    /**
     * 
     * @param list
     * @return
     */
    DataBuilder cellList(List<Integer> list);
    /**
     * 
     * @return
     */
    DataBuilder build();
}
