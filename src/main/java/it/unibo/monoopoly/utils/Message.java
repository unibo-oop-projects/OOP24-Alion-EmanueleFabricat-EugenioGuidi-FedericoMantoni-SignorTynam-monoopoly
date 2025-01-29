package it.unibo.monoopoly.utils;

/**
 * Record of utility, it rappresents the message dirrected to {@link Turn}.
 * @param typeOfAction that {@link Turn} have to do.
 * @param data that {@link Turn} have to use to do the opration.
 */
public record Message(Actions typeOfActions, Object data) {   
    public enum Actions {
        PAY,
        MOVE,
        WRITE,
    }

}

