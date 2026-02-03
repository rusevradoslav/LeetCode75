package org.example.e_hash_map_set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualRowAndColumnPairsTest {

    private EqualRowAndColumnPairs solution;

    @BeforeEach
    void setUp() {
        solution = new EqualRowAndColumnPairs();
    }

    @Test
    @DisplayName("Example 1: 3x3 grid with 1 matching pair")
    void example1_oneMatchingPair_returnsOne() {
        int[][] grid = {
                {3, 2, 1},
                {1, 7, 6},
                {2, 7, 7}
        };
        assertEquals(1, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("Example 2: 4x4 grid with 3 matching pairs")
    void example2_threeMatchingPairs_returnsThree() {
        int[][] grid = {
                {3, 1, 2, 2},
                {1, 4, 4, 5},
                {2, 4, 2, 2},
                {2, 4, 2, 2}
        };
        assertEquals(3, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("1x1 grid → always 1 pair")
    void singleElement_alwaysMatches_returnsOne() {
        int[][] grid = {{5}};
        assertEquals(1, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("2x2 identity matrix → 2 pairs")
    void identityMatrix2x2_diagonalMatches_returnsTwo() {
        int[][] grid = {
                {1, 0},
                {0, 1}
        };
        assertEquals(2, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("All same values → n² pairs")
    void allSameValues_allMatch_returnsNSquared() {
        int[][] grid = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        assertEquals(9, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("No matching pairs → returns 0")
    void noMatchingPairs_returnsZero() {
        int[][] grid = {
                {1, 2},
                {3, 4}
        };
        assertEquals(0, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("Duplicate rows matching same column → counts each")
    void duplicateRowsMatchingSameColumn_countsEach() {
        int[][] grid = {
                {1, 1},
                {1, 1}
        };
        assertEquals(4, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("Symmetric matrix → row i matches column i")
    void symmetricMatrix_multipleMatches() {
        int[][] grid = {
                {1, 2, 3},
                {2, 2, 2},
                {3, 2, 1}
        };
        assertEquals(3, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("Same elements different order → no match")
    void sameElementsDifferentOrder_noMatch() {
        int[][] grid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        assertEquals(0, solution.equalPairs(grid));
    }

    @Test
    @DisplayName("4x4 grid with column matching single row → returns 3")
    void grid4x4_columnMatchesSingleRow_returnsThree() {
        int[][] grid = {
                {3, 1, 2, 2},
                {1, 4, 4, 4},
                {2, 4, 2, 2},
                {2, 5, 2, 2}
        };
        assertEquals(3, solution.equalPairs(grid));
    }
}