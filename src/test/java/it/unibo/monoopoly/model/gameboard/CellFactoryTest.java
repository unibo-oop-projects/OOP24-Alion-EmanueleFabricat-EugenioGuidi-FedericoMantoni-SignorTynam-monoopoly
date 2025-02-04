package it.unibo.monoopoly.model.gameboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.function.Predicate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unibo.monoopoly.model.api.gameboard.Cell;
import it.unibo.monoopoly.model.api.gameboard.CellFactory;
import it.unibo.monoopoly.model.impl.gameboard.CellFactoryImpl;

public class CellFactoryTest {

    private static final int N_CELLS = 40;
    private static final int N_BUILDABLE = 22;
    private static final int N_FUNCTIONAL = 12;
    private static final int N_BUYABLE = 28;
    private static final int N_COMPANY = 2;
    private static final int N_RAILROAD = 4;

    private final CellFactory factory = new CellFactoryImpl();

    private List<Cell> cells;

    @BeforeEach
    void init() {
        this.cells = factory.createCells();
    }

    @Test
    void testCreation() {
        assertEquals(N_CELLS, cells.size());
        assertEquals(N_BUILDABLE, Math.toIntExact(cells.stream().filter(Cell::isBuildable).count()));
        assertEquals(N_BUYABLE, Math.toIntExact(cells.stream().filter(Cell::isBuyable).count()));
        assertEquals(N_COMPANY, Math.toIntExact(cells.stream().filter(Cell::isCompany).count()));
        assertEquals(N_RAILROAD, Math.toIntExact(cells.stream().filter(Cell::isRailroad).count()));
        assertEquals(N_FUNCTIONAL, Math.toIntExact(cells.stream().filter(Predicate.not(Cell::isBuyable)).count()));
    }

}
