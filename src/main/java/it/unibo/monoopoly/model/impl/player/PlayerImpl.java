package it.unibo.monoopoly.model.impl.player;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import it.unibo.monoopoly.model.api.gameboard.Buyable;
import it.unibo.monoopoly.model.api.player.Player;

/**
 * Implements the player of the game.
 */

public class PlayerImpl implements Player {

    private final Optional<String> name;
    private int moneyAmount;
    private int actualPosition;
    private boolean prisoned;
    private Set<Buyable> properties;

    /**
     * Constructor for the player.
     * @param name              the name of the player.
     * @param moneyAmount       the amount of money the player has.
     * @param actualPosition    the current position of the player.
     * @param prisoned          true if the player is in prison, false otherwise.
     */
    public PlayerImpl(String name, int moneyAmount, int actualPosition, boolean prisoned) {
        this.name = Optional.ofNullable(Optional.ofNullable(name).orElseThrow(() -> new IllegalArgumentException("Name cannot be null")));
        this.moneyAmount = validatePositive(moneyAmount, "Money amount cannot be negative");
        this.actualPosition = validatePositive(actualPosition, "Position cannot be negative");
        this.prisoned = prisoned;
        this.properties = new HashSet<>();
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
        
    /**
     * Retrieves the name of the player.
     * @return the name of the player.
     */
    @Override
    public Optional<String> getName() {
        return this.name;
    }

    /**
     * Retrieves the amount of money the player has.
     * @return the amount of money the player has.
     */
    @Override
    public int getMoneyAmount() {
        return this.moneyAmount;
    }

    /**
     * Retrieves the current position of the player.
     * @return the current position of the player.
     */
    @Override
    public int getActualPosition() {
        return this.actualPosition;
    }

    /**
     * Checks if the player is in prison.
     * @return true if the player is in prison, false otherwise.
     */
    @Override
    public boolean isPrisoned() {
        return this.prisoned;
    }

    /**
     * Checks if the player can pay a specified amount.
     * @param amount the amount to be paid.
     * @return true if the player can pay, false otherwise.
     */
    @Override
    public boolean isPayable(int amount) {
        return this.moneyAmount >= amount;
    }

    /**
     * Deducts the specified amount from the player's money.
     * @param amount the amount to be deducted.
     */
    @Override
    public void pay(int amount) {
        this.moneyAmount -= validatePositive(amount, "Amount cannot be negative");
    }

    /**
     * Adds the specified amount to the player's money.
     * @param amount the amount to be added.
     */
    @Override
    public void receive(int amount) {
        this.moneyAmount += validatePositive(amount, "Amount cannot be negative");
    }

    /**
     * Adds a property to the player's list of owned properties.
     * 
     * @param property the property to be added.
     * @return true if the property was added, false otherwise.
     */
    @Override
    public boolean addProperty(Buyable property) {
        return this.properties.add(property);
    }

    /**
     * Removes a property from the player's list of owned properties.
     * 
     * @param property the property to be removed.
     * @return true if the property was removed, false otherwise.
     */
    @Override
    public boolean removeProperty(Buyable property) {
        return this.properties.remove(property);
    }

    /**
     * Retrieves the properties owned by the player.
     * 
     * @return the properties owned by the player.
     */
    @Override
    public Set<Buyable> getProperties() {
        return Set.copyOf(this.properties);
    }

}
