package it.unibo.monoopoly.controller.data.api;

import it.unibo.monoopoly.controller.data.impl.DataOutput;

/**
 * The builder of a class that contains all information for the model.
 */
public interface DataBuilderOutput {
    /**
     * 
     * @param buy
     * @return this.
     */
    DataBuilderOutput buyProperty(boolean buy);

    /**
     * 
     * @param cell
     * @return this.
     */
    DataBuilderOutput cellChoose(int cell);

    /**
     * 
     * @return product.
     */
    DataOutput build();
}
