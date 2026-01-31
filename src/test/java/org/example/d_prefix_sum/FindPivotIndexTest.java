package org.example.d_prefix_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexTest {

    private FindPivotIndex solution;

    @BeforeEach
    void setUp() {
        solution = new FindPivotIndex();
    }

    @Test
    @DisplayName("Example 1: nums=[1,7,3,6,5,6] → pivot at index 3")
    void example1_pivotInMiddle_returnsThree() {
        assertEquals(3, solution.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        assertEquals(3, solution.pivotIndexOptimized(new int[]{1, 7, 3, 6, 5, 6}));
    }

    @Test
    @DisplayName("Example 2: nums=[1,2,3] → no pivot exists, returns -1")
    void example2_noPivotExists_returnsNegativeOne() {

        assertEquals(-1, solution.pivotIndex(new int[]{1, 2, 3}));
        assertEquals(-1, solution.pivotIndexOptimized(new int[]{1, 2, 3}));
    }

    @Test
    @DisplayName("Example 3: nums=[2,1,-1] → pivot at index 0 (left sum is 0)")
    void example3_pivotAtStart_returnsZero() {

        assertEquals(0, solution.pivotIndex(new int[]{2, 1, -1}));
        assertEquals(0, solution.pivotIndexOptimized(new int[]{2, 1, -1}));
    }

    @Test
    @DisplayName("Single element → pivot at index 0")
    void singleElement_alwaysPivot_returnsZero() {
        assertEquals(0, solution.pivotIndex(new int[]{5}));
        assertEquals(0, solution.pivotIndexOptimized(new int[]{5}));
    }

    @Test
    @DisplayName("Two elements equal → no pivot")
    void twoEqualElements_noPivot_returnsNegativeOne() {
        assertEquals(-1, solution.pivotIndex(new int[]{1, 1}));
        assertEquals(-1, solution.pivotIndexOptimized(new int[]{1, 1}));
    }

    @Test
    @DisplayName("Pivot at last index (right sum is 0)")
    void pivotAtEnd_rightSumZero_returnsLastIndex() {
        assertEquals(2, solution.pivotIndex(new int[]{-1, 1, 0}));
        assertEquals(2, solution.pivotIndexOptimized(new int[]{-1, 1, 0}));
    }

    @Test
    @DisplayName("All zeros → returns leftmost (index 0)")
    void allZeros_multipleValidPivots_returnsLeftmost() {
        assertEquals(0, solution.pivotIndex(new int[]{0, 0, 0, 0}));
        assertEquals(0, solution.pivotIndexOptimized(new int[]{0, 0, 0, 0}));
    }

    @Test
    @DisplayName("Negative numbers with valid pivot")
    void negativeNumbers_validPivot_returnsCorrectIndex() {
        assertEquals(2, solution.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0}));
        assertEquals(2, solution.pivotIndexOptimized(new int[]{-1, -1, -1, -1, -1, 0}));
    }

    @Test
    @DisplayName("Multiple valid pivots → returns leftmost")
    void multiplePivots_returnsLeftmost() {
        assertEquals(0, solution.pivotIndex(new int[]{0, 0, 0}));
        assertEquals(0, solution.pivotIndexOptimized(new int[]{0, 0, 0}));
    }


}