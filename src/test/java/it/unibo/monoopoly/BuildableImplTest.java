package it.unibo.monoopoly;

import org.junit.jupiter.api.BeforeEach;

import it.unibo.monoopoly.model.impl.gameboard.BuildableImpl;

public class BuildableImplTest {

    private BuildableImpl property;

    @BeforeEach
    public void initialization() {
        this.property = new BuildableImpl(100);
    }

}
