package it.unibo.monoopoly.model.impl.player;

import java.util.Optional;

import it.unibo.monoopoly.model.api.player.Player;

public class PlayerImpl implements Player {

    private final String name;
    private int moneyAmount;
    private int actualPosition;
    private boolean prisoned;

    /**
     * Constructor for the player.
     * @param name              the name of the player.
     * @param moneyAmount       the amount of money the player has.
     * @param actualPosition    the current position of the player.
     * @param prisoned          true if the player is in prison, false otherwise.
     */
    public PlayerImpl(String name, int moneyAmount, int actualPosition, boolean prisoned) {
        this.name = Optional.ofNullable(name).orElseThrow(() -> new IllegalArgumentException("Name cannot be null"));
        this.moneyAmount = validatePositive(moneyAmount, "Money amount cannot be negative");
        this.actualPosition = validatePositive(actualPosition, "Position cannot be negative");
                this.prisoned = prisoned;
    }
    
    /**
     * Validates that the given value is positive.
     * @param value         the value to be validated.
     * @param errorMessage  the error message to be thrown if the value is not positive.
     * @return the value if it is positive.
     * @throws IllegalArgumentException if the value is not positive.
     */
    private int validatePositive(int value, String errorMessage) {
        return Optional.of(value).filter(i -> i >= 0).orElseThrow(() -> new IllegalArgumentException(errorMessage));
    }
        
    @Override
    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    @Override
    public int getMoneyAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMoneyAmount'");
    }

    @Override
    public int getActualPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getActualPosition'");
    }

    @Override
    public boolean isPrisoned() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPrisoned'");
    }

    @Override
    public boolean isPayable(int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPayable'");
    }

    @Override
    public void pay(int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pay'");
    }

    @Override
    public void receive(int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receive'");
    }

}
