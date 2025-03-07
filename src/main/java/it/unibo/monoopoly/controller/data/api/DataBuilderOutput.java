package it.unibo.monoopoly.controller.data.api;

import it.unibo.monoopoly.controller.data.impl.DataOutput;
import it.unibo.monoopoly.model.gameboard.api.Cell;

/**
 * The builder of the {@link DataOutput} that contains all information for the
 * Model.
 */
public interface DataBuilderOutput {
    /**
     * Fluent method that insert a boolean to decide if the property has been bought
     * or not, in the {@link DataOutput}.
     * 
     * @param buy to be inserted.
     * @return this.
     */
    DataBuilderOutput buyProperty(boolean buy);

    /**
     * Fluent method that insert a int that represents the index of the chosen
     * {@link Cell}, in the {@link DataOutput}.
     * 
     * @param cell to be inserted.
     * @return this.
     */
    DataBuilderOutput cellChoose(int cell);

    /**
     * 
     * @return product.
     */
    DataOutput build();
}
