package org.example.b_two_pointers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveZeroesTest {

    private MoveZeroes moveZeroes;

    @BeforeEach
    void setUp() {
        moveZeroes = new MoveZeroes();
    }

    @Test
    @DisplayName("Example 1: moves zeros to end while preserving order")
    void moveZeroes_standardCase() {
        int[] input = {0, 1, 0, 3, 12};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, input);
    }

    @Test
    @DisplayName("Example 2: single zero remains unchanged")
    void moveZeroes_singleZero() {
        int[] input = {0};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{0}, input);
    }

    @Test
    @DisplayName("Single non-zero element remains unchanged")
    void moveZeroes_singleNonZero() {
        int[] input = {5};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{5}, input);
    }

    @Test
    @DisplayName("All zeros: array remains unchanged")
    void moveZeroes_allZeros() {
        int[] input = {0, 0, 0, 0};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{0, 0, 0, 0}, input);
    }

    @Test
    @DisplayName("No zeros: array remains unchanged")
    void moveZeroes_noZeros() {
        int[] input = {1, 2, 3, 4, 5};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, input);
    }

    @Test
    @DisplayName("Zeros already at end: array remains unchanged")
    void moveZeroes_zerosAlreadyAtEnd() {
        int[] input = {1, 2, 3, 0, 0};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{1, 2, 3, 0, 0}, input);
    }

    @Test
    @DisplayName("Zeros at beginning: moves all to end")
    void moveZeroes_zerosAtBeginning() {
        int[] input = {0, 0, 0, 1, 2};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{1, 2, 0, 0, 0}, input);
    }

    @Test
    @DisplayName("Alternating zeros and non-zeros")
    void moveZeroes_alternating() {
        int[] input = {0, 1, 0, 2, 0, 3, 0, 4};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{1, 2, 3, 4, 0, 0, 0, 0}, input);
    }

    @Test
    @DisplayName("Handles negative numbers correctly")
    void moveZeroes_negativeNumbers() {
        int[] input = {-1, 0, 0, -3, 12};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{-1, -3, 12, 0, 0}, input);
    }

    @Test
    @DisplayName("Two elements: swaps correctly")
    void moveZeroes_twoElements() {
        int[] input = {0, 1};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{1, 0}, input);
    }

    @Test
    @DisplayName("Null array: handles gracefully without exception")
    void moveZeroes_nullArray() {
        assertDoesNotThrow(() -> moveZeroes.moveZeroes(null));
    }

    @Test
    @DisplayName("Empty array: handles gracefully")
    void moveZeroes_emptyArray() {
        int[] input = {};

        moveZeroes.moveZeroes(input);

        assertArrayEquals(new int[]{}, input);
    }
}