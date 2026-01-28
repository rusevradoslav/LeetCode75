package org.example.b_two_pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContainerWithMostWaterTest {

    private ContainerWithMostWater containerWithMostWater;

    @BeforeEach
    void setUp() {
        containerWithMostWater = new ContainerWithMostWater();
    }

    @Test
    @DisplayName("Example 1: height=[1,8,6,2,5,4,8,3,7] returns 49")
    void maxArea_example1() {
        assertEquals(49, containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    @DisplayName("Example 2: height=[1,1] returns 1")
    void maxArea_example2() {
        assertEquals(1, containerWithMostWater.maxArea(new int[]{1, 1}));
    }

    @Test
    @DisplayName("Two elements with different heights")
    void maxArea_twoElementsDifferentHeights() {
        assertEquals(5, containerWithMostWater.maxArea(new int[]{5, 10}));
    }

    @Test
    @DisplayName("All elements are zero")
    void maxArea_allZeros() {
        assertEquals(0, containerWithMostWater.maxArea(new int[]{0, 0, 0, 0}));
    }

    @Test
    @DisplayName("One element is zero")
    void maxArea_oneZero() {
        assertEquals(0, containerWithMostWater.maxArea(new int[]{0, 5}));
    }

    @Test
    @DisplayName("All elements are the same height")
    void maxArea_allSameHeight() {
        assertEquals(20, containerWithMostWater.maxArea(new int[]{5, 5, 5, 5, 5}));
    }

    @Test
    @DisplayName("Maximum values at the ends")
    void maxArea_maxAtEnds() {
        assertEquals(40000, containerWithMostWater.maxArea(new int[]{10000, 1, 1, 1, 10000}));
    }

    @Test
    @DisplayName("Ascending order")
    void maxArea_ascendingOrder() {
        assertEquals(6, containerWithMostWater.maxArea(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    @DisplayName("Descending order")
    void maxArea_descendingOrder() {
        assertEquals(6, containerWithMostWater.maxArea(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    @DisplayName("Mountain pattern with peak in middle")
    void maxArea_mountainPattern() {
        assertEquals(12, containerWithMostWater.maxArea(new int[]{1, 3, 5, 7, 5, 3, 1}));
    }

    @Test
    @DisplayName("Valley pattern with lowest in middle")
    void maxArea_valleyPattern() {
        assertEquals(42, containerWithMostWater.maxArea(new int[]{7, 5, 3, 1, 3, 5, 7}));
    }

    @Test
    @DisplayName("Alternating high and low")
    void maxArea_alternatingPattern() {
        assertEquals(40, containerWithMostWater.maxArea(new int[]{10, 1, 10, 1, 10}));
    }

    @Test
    @DisplayName("Best container is not at the ends")
    void maxArea_bestNotAtEnds() {
        assertEquals(100, containerWithMostWater.maxArea(new int[]{1, 100, 100, 1}));
    }

    @Test
    @DisplayName("Single tall line in the middle")
    void maxArea_singleTallMiddle() {
        assertEquals(8, containerWithMostWater.maxArea(new int[]{2, 2, 100, 2, 2}));
    }

    @Test
    @DisplayName("Maximum constraint values")
    void maxArea_maxConstraintValues() {
        assertEquals(10000, containerWithMostWater.maxArea(new int[]{10000, 10000}));
    }

    @Test
    @DisplayName("Large array performance test")
    void maxArea_largeArray() {
        int[] height = new int[100000];
        for (int i = 0; i < 100000; i++) {
            height[i] = 10000;
        }
        assertEquals(999990000, containerWithMostWater.maxArea(height));
    }
}