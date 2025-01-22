package it.unibo.monoopoly.model.api;

/**
 * Interface that implements a benker who help the player decide wich house sell or properties mortagage.
 */
public interface Banker {
    /**
     * Make with the palyer the operationes.
     * 
     * @return the proceeds of the oparationes.
     */
    int makeOperations();
}
