package it.unibo.monoopoly.model.player.impl;

import java.util.Set;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unibo.monoopoly.model.gameboard.api.Buyable;
import it.unibo.monoopoly.model.player.api.Player;

/**
 * Proxy of {@link PlayerImpl}.
 */
public class PlayerWrapper implements Player {

    private final Player player;

    /**
     * Constructor of the proxy.
     * 
     * @param player the real Player.
     */
    @SuppressFBWarnings(value = "EI_EXPOSE_REP", justification = "Suppressing according to pattern Proxy")
    public PlayerWrapper(final Player player) {
        this.player = player;
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return String.valueOf(this.player.getName());
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public int getMoneyAmount() {
        return this.player.getMoneyAmount();
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public int getActualPosition() {
        return this.player.getActualPosition();
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public boolean isPrisoned() {
        return this.player.isPrisoned();
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public void changePosition(final int position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changePosition'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public boolean isPayable(final int amount) {
        return this.player.isPayable(amount);
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public void pay(final int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pay'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public void receive(final int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receive'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public boolean addProperty(final Buyable property) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProperty'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public boolean removeProperty(final Buyable property) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeProperty'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public Set<Buyable> getProperties() {
        return Set.copyOf(this.player.getProperties());
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public void inBankrupt() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inBankrupt'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public boolean isBankrupt() {
        return this.player.isBankrupt();
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public void addGetOutOfJailCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addGetOutOfJailCard'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public int getFreeJailCards() {
        return this.player.getFreeJailCards();
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public boolean useGetOutOfJailCard() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'useGetOutOfJailCard'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public void setPrisoned() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPrisoned'");
    }

    /**
     * Proxy version.
     * {@inheritDoc}
     */
    @Override
    public void releaseFromPrison() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'releaseFromPrison'");
    }

}
