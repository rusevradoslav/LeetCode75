package org.example.c_sliding_window;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaximumAverageSubarray1Test {

    private MaximumAverageSubarray1 maximumAverageSubarray1;

    @BeforeEach
    void setUp() {
        maximumAverageSubarray1 = new MaximumAverageSubarray1();
    }

    @Test
    @DisplayName("Example 1: nums=[1,12,-5,-6,50,3], k=4 returns 12.75")
    void findMaxAverage_example1() {
        assertEquals(12.75, maximumAverageSubarray1.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 0.00001);
    }

    @Test
    @DisplayName("Example 2: nums=[5], k=1 returns 5.0")
    void findMaxAverage_example2() {
        assertEquals(5.0, maximumAverageSubarray1.findMaxAverage(new int[]{5}, 1), 0.00001);
    }

    @Test
    @DisplayName("Single element array")
    void findMaxAverage_singleElement() {
        assertEquals(7.0, maximumAverageSubarray1.findMaxAverage(new int[]{7}, 1), 0.00001);
    }

    @Test
    @DisplayName("k equals array length")
    void findMaxAverage_kEqualsLength() {
        assertEquals(3.0, maximumAverageSubarray1.findMaxAverage(new int[]{1, 2, 3, 4, 5}, 5), 0.00001);
    }

    @Test
    @DisplayName("All elements are the same")
    void findMaxAverage_allSameElements() {
        assertEquals(5.0, maximumAverageSubarray1.findMaxAverage(new int[]{5, 5, 5, 5, 5}, 3), 0.00001);
    }

    @Test
    @DisplayName("All negative numbers")
    void findMaxAverage_allNegative() {
        assertEquals(-1.5, maximumAverageSubarray1.findMaxAverage(new int[]{-5, -4, -3, -2, -1}, 2), 0.00001);
    }

    @Test
    @DisplayName("Mixed positive and negative numbers")
    void findMaxAverage_mixedNumbers() {
        assertEquals(4.5, maximumAverageSubarray1.findMaxAverage(new int[]{-1, 4, 5, 1, -2}, 2), 0.00001);
    }

    @Test
    @DisplayName("Maximum at the beginning")
    void findMaxAverage_maxAtBeginning() {
        assertEquals(9.0, maximumAverageSubarray1.findMaxAverage(new int[]{9, 9, 1, 1, 1}, 2), 0.00001);
    }

    @Test
    @DisplayName("Maximum at the end")
    void findMaxAverage_maxAtEnd() {
        assertEquals(9.0, maximumAverageSubarray1.findMaxAverage(new int[]{1, 1, 1, 9, 9}, 2), 0.00001);
    }

    @Test
    @DisplayName("Maximum in the middle")
    void findMaxAverage_maxInMiddle() {
        assertEquals(9.0, maximumAverageSubarray1.findMaxAverage(new int[]{1, 1, 9, 9, 1, 1}, 2), 0.00001);
    }

    @Test
    @DisplayName("k equals 1 returns max element")
    void findMaxAverage_kEqualsOne() {
        assertEquals(50.0, maximumAverageSubarray1.findMaxAverage(new int[]{1, 12, -5, 50, 3}, 1), 0.00001);
    }

    @Test
    @DisplayName("Two elements, k=2")
    void findMaxAverage_twoElements() {
        assertEquals(2.5, maximumAverageSubarray1.findMaxAverage(new int[]{2, 3}, 2), 0.00001);
    }

    @Test
    @DisplayName("Large values")
    void findMaxAverage_largeValues() {
        assertEquals(10000.0, maximumAverageSubarray1.findMaxAverage(new int[]{10000, 10000, 10000}, 2), 0.00001);
    }

    @Test
    @DisplayName("Descending order")
    void findMaxAverage_descendingOrder() {
        assertEquals(4.5, maximumAverageSubarray1.findMaxAverage(new int[]{5, 4, 3, 2, 1}, 2), 0.00001);
    }

    @Test
    @DisplayName("Ascending order")
    void findMaxAverage_ascendingOrder() {
        assertEquals(4.5, maximumAverageSubarray1.findMaxAverage(new int[]{1, 2, 3, 4, 5}, 2), 0.00001);
    }
}