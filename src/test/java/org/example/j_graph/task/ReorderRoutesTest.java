package org.example.j_graph.task;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class ReorderRoutesTest {

    private ReorderRoutes solution;

    protected abstract ReorderRoutes createSolution();

    @BeforeEach
    void setUp() {
        solution = createSolution();
    }

    @Test
    @DisplayName("All roads already point toward city 0 — no reorders needed")
    void testNoReorderNeeded() {
        assertEquals(0, solution.minReorder(3, new int[][]{{1, 0}, {2, 0}}));
    }

    @Test
    @DisplayName("All roads point away from city 0 — all must be reordered")
    void testAllReorderNeeded() {
        assertEquals(2, solution.minReorder(3, new int[][]{{0, 1}, {0, 2}}));
    }

    @Test
    @DisplayName("LeetCode example 1: mixed directions")
    void testLeetCodeExample1() {
        assertEquals(3, solution.minReorder(6,
                new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

    @Test
    @DisplayName("LeetCode example 2: mixed directions")
    void testLeetCodeExample2() {
        assertEquals(2, solution.minReorder(5,
                new int[][]{{1, 0}, {1, 2}, {3, 2}, {3, 4}}));
    }

    @Test
    @DisplayName("Two cities, road already points to city 0")
    void testTwoCitiesNoReorder() {
        assertEquals(0, solution.minReorder(2, new int[][]{{1, 0}}));
    }

    @Test
    @DisplayName("Two cities, road points away from city 0")
    void testTwoCitiesReorder() {
        assertEquals(1, solution.minReorder(2, new int[][]{{0, 1}}));
    }

    @Test
    @DisplayName("Mixed directions with path through city 5 to city 0")
    void testMixedWithIndirectPath() {
        assertEquals(3, solution.minReorder(6,
                new int[][]{{0, 2}, {0, 3}, {4, 1}, {4, 5}, {5, 0}}));
    }
}
