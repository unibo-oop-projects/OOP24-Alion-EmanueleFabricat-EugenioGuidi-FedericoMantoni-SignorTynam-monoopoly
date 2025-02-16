package it.unibo.monoopoly.controller.api;

import it.unibo.monoopoly.controller.impl.DataOutput;

/**
 * The builder of a class that contains all information for the model. 
 */
public interface DataBuilderOutput {
    /**
     * 
     * @param buy
     * @return
     */
    DataBuilderOutput buyProperty(boolean buy);   
    /**
     * 
     * @param cell
     * @return
     */
    DataBuilderOutput cellChoose(int cell);
    /**
     * 
     * @return
     */
    DataOutput build(); 
}
