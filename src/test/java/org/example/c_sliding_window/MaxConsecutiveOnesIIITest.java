package org.example.c_sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxConsecutiveOnesIIITest {

    private MaxConsecutiveOnesIII maxConsecutiveOnesIII;

    @BeforeEach
    void setUp() {
        maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();
    }

    @Test
    @DisplayName("Example 1: nums=[1,1,1,0,0,0,1,1,1,1,0], k=2 returns 6")
    void longestOnes_example1() {
        assertEquals(6, maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    @DisplayName("Example 2: nums=[0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k=3 returns 10")
    void longestOnes_example2() {
        assertEquals(10, maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    @Test
    @DisplayName("All ones, k=0")
    void longestOnes_allOnes() {
        assertEquals(5, maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 1, 1}, 0));
    }

    @Test
    @DisplayName("All zeros, k=0")
    void longestOnes_allZerosKZero() {
        assertEquals(0, maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 0, 0, 0}, 0));
    }

    @Test
    @DisplayName("All zeros, k equals length")
    void longestOnes_allZerosKEqualsLength() {
        assertEquals(5, maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 0, 0, 0}, 5));
    }

    @Test
    @DisplayName("All zeros, k greater than length")
    void longestOnes_allZerosKGreaterThanLength() {
        assertEquals(5, maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 0, 0, 0}, 10));
    }

    @Test
    @DisplayName("Single element one")
    void longestOnes_singleOne() {
        assertEquals(1, maxConsecutiveOnesIII.longestOnes(new int[]{1}, 0));
    }

    @Test
    @DisplayName("Single element zero with k=0")
    void longestOnes_singleZeroKZero() {
        assertEquals(0, maxConsecutiveOnesIII.longestOnes(new int[]{0}, 0));
    }

    @Test
    @DisplayName("Single element zero with k=1")
    void longestOnes_singleZeroKOne() {
        assertEquals(1, maxConsecutiveOnesIII.longestOnes(new int[]{0}, 1));
    }

    @Test
    @DisplayName("Alternating ones and zeros")
    void longestOnes_alternating() {
        assertEquals(5, maxConsecutiveOnesIII.longestOnes(new int[]{1, 0, 1, 0, 1, 0, 1}, 2));
    }

    @Test
    @DisplayName("Zeros at the beginning")
    void longestOnes_zerosAtBeginning() {
        assertEquals(5, maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 1, 1, 1}, 2));
    }

    @Test
    @DisplayName("Zeros at the end")
    void longestOnes_zerosAtEnd() {
        assertEquals(5, maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 0, 0}, 2));
    }

    @Test
    @DisplayName("Zeros in the middle")
    void longestOnes_zerosInMiddle() {
        assertEquals(5, maxConsecutiveOnesIII.longestOnes(new int[]{1, 0, 0, 1, 1}, 2));
    }

    @Test
    @DisplayName("k equals zero with mixed array")
    void longestOnes_kZeroMixedArray() {
        assertEquals(3, maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 0, 1, 1}, 0));
    }

    @Test
    @DisplayName("Large k covers entire array")
    void longestOnes_largeK() {
        assertEquals(7, maxConsecutiveOnesIII.longestOnes(new int[]{0, 1, 0, 1, 0, 1, 0}, 100));
    }

    @Test
    @DisplayName("Two separate groups of ones")
    void longestOnes_twoGroups() {
        assertEquals(3, maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 0, 0, 0, 1, 1}, 1));
    }

    @Test
    @DisplayName("Best window at the end")
    void longestOnes_bestWindowAtEnd() {
        assertEquals(4, maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 0, 1, 1, 1, 1}, 0));
    }

    @Test
    @DisplayName("Best window at the beginning")
    void longestOnes_bestWindowAtBeginning() {
        assertEquals(4, maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 1, 0, 0, 0}, 0));
    }
}