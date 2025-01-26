package it.unibo.monoopoly.model.impl.player;

import java.util.Optional;

import it.unibo.monoopoly.model.api.player.Player;

public class PlayerImpl implements Player {

    private final String name;
    private int moneyAmount;
    private int actualPosition;
    private boolean prisoned;

    public PlayerImpl(String name, int moneyAmount, int actualPosition, boolean prisoned) {
        this.name = Optional.ofNullable(name).orElseThrow(() -> new IllegalArgumentException("Name cannot be null"));
        this.moneyAmount = validatePositive(moneyAmount, "Money amount cannot be negative");
        this.actualPosition = validatePositive(actualPosition, "Position cannot be negative");
                this.prisoned = prisoned;
    }
        
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
